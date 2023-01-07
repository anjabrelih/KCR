%% Izločanje očesnih artefaktov z uporabo postopka analize neodvisnih komponent (ANK)
% Anja Brelih
% Januar 2023

% OPOMBE:
% funkcija fastica.m mora biti vključena na poti (lahko je dodana v mapo
% mcode, ki je že vključena v pot).

%% ========================================================================
% Global parameters
db_path = 'files'; % Preimenujte v ime vaše baze podatkov oziroma definirajte pot.
cd ('/Users/anjabrelih/Documents/MATLAB') % začetna pot
%% ========================================================================
% Izbira testnega subjekta [1 - 109]
s = input("Izberite testni subjekt (od 1 do 109): ");

% Ustvari pot do mape
if (s >= 1) && (s <= 9)
    path = append(db_path,sprintf('/S00%d',s));
    cd (path)
    start_file = sprintf('S00%d',s);
elseif (s >= 10) && (s <= 99)
    path = append(db_path,sprintf('/S0%d',s));
    cd (path)
    start_file = sprintf('S0%d',s);
elseif (s >= 100) && (s <= 109)
    path = append(db_path,sprintf('/S%d',s));
    cd (path)
    start_file = sprintf('S%d',s);
else
    disp("Vnesli ste neveljavno številko. Izločanje očesnih artefaktov bomo izvedli na subjektu 1.")
    path = append(db_path,'/S001/');
    cd (path)
    start_file = 'S001';
end

%% ========================================================================
% Izbira poskusa [1-14]
x = input("Izberite željen poskus (od 1 do 14): ");

% Ustvari pot do datoteke
if (x >= 1) && (x <= 9)
    file_name = append(start_file,sprintf('R0%d.edf', x));
elseif (x >= 10) && (x <= 14)
    file_name = append(start_file,sprintf('R%d.edf', x));
else
    disp("Vnesli ste neveljavno številko. Izločanje očesnih artefaktov bomo izvedli na poskusu 3.")
    file_name = append(start_file,'R03.edf');
end

%% ========================================================================
% Preberi datoteko
[sigs, freq, tm] = rdsamp(file_name); % [signali, frekvenca vzorčenja, časovni indeks]
% Signali so od 1-64; 65 je oznaka (https://www.physionet.org/content/eegmmidb/1.0.0/64_channel_sharbrough.pdf)

% Preberi anotacije signalov iz datoteke edf.event (za vzorce 3-14)
if (x ~= 1) && (x ~= 2)
    [annot, atyp, sbtyp, chn, nm, cmt] = rdann(file_name, 'event');
end


%% Prikaz signalov FP1(22) in FP2(24) v časovni domeni
% z anotacijami v kolikor obstajajo (poskus 3-14)

figure
% FP1
subplot(2,1,1)
plot(tm,sigs(:,22))
xlabel('Čas [s]')
ylabel('Napetost [mV]') % ali je μV?
if (x ~= 1) && (x ~= 2)
    title('Osnovni signal FP1 z anotacijami')
    for i=1:length(annot)
        xline(tm(annot(i)), '--o', cmt(i))
    end
else
    title('Osnovni signal FP1')
end

% FP2
subplot(2,1,2)
plot(tm,sigs(:,24))
xlabel('Čas [s]')
ylabel('Napetost [mV]') % ali je μV?
if (x ~= 1) && (x ~= 2)
    title('Osnovni signal FP2 z anotacijami')
    for i=1:length(annot)
        xline(tm(annot(i)), '--o', cmt(i))
    end
else
    title('Osnovni signal FP2')
end

input("Pritisnite enter za nadaljevanje."); % Da pokaže izris in se ustavi pred analizo.
%% Analiza neodvisnih komponent (fastICA)
% icasig - neodvisne komponente
% A      - mešalna matrika
% W      - ločevalna matrika (inverz mešalne matrike A)

[icasig, A, W] = fastica(sigs(:,1:size(sigs,2)-1)'); % transponiramo matriko signalov in uporabimo le 1-64 (oz. predzadnjega signala)

%% Izris neodvisnih komponent (64)
n = 4; % Število oken
t = 16; % Želimo npr. 4 okna (po 16 komponent)
check_size = size(icasig,1)/n;

for i = n:-1:1 % Padajoča zanka, da je naraščujoči prikaz
    figure
    if (i == 4) && (check_size ~= n) % izjema v kolikor ni na voljo 64 signalov
        for j = 1+(t*(i-1)):size(icasig,1)
            subplot(8,2,(j-(t*(i-1)))) %subplot(število vrstic, število stolpcev, položaj)
            plot(icasig(j,:))
            ylim([-10 10])
            title(sprintf('Komponenta %d',j))
        end
    else
        for j = 1+(t*(i-1)):t+(t*(i-1))
            subplot(8,2,(j-(t*(i-1)))) %subplot(število vrstic, število stolpcev, položaj)
            plot(icasig(j,:)) % Prikaz samo prvih 2000 vzorcev - namesto : damo 1:2000
            ylim([-10 10])
            title(sprintf('Komponenta %d',j))
        end
    end
end

prompt = sprintf('V oglatih oklepajih [] brez ločil zapišite komponente (1-%d), ki jih želite izločiti: ',size(icasig,1));
m = input(prompt);
%% Odstranitev izbranih neodvisnih komponent

b = sort(m,'descend'); % Padajoči vrstni red, da lahko pravilno odstranimo komponente
Wap = inv(W); % inverz ločevalne matrike - približek matrike A
sigs_new = icasig; % neodvisne komponente signalov

% Odstranjevanje izbranih komponent iz mešalne matrike in signalov
for i = 1:length(b)
    Wap(:,b(i)) = [];
    sigs_new(b(i),:) = [];
end

Xap=Wap*sigs_new; % množimo rezultat odstranjevanja in dobimo signale brez mišičnih artefaktov

%% Izris končnega rezultata za FP1(22) in FP2(24)

% FP1
figure
sgtitle('Signal FP1')
subplot(3,1,1)
plot(tm,sigs(:,22))
Ylimit = get(gca, 'YLim'); % pridobi meje Y osi za uporabo pri naslednjih grafih
ylim(Ylimit)
xlabel('Čas [s]')
ylabel('Napetost [mV]') % ali je μV?
if (x ~= 1) && (x ~= 2)
    title('Osnovni signal FP1 z anotacijami')
    for i=1:length(annot)
        xline(tm(annot(i)), '--o', cmt(i))
    end
else
    title('Osnovni signal FP1')
end

subplot(3,1,2)
plot(tm,Xap(22,:))
ylim(Ylimit)
xlabel('Čas [s]')
ylabel('Napetost [mV]') % ali je μV?
if (x ~= 1) && (x ~= 2)
    title('Korigiran signal FP1 z anotacijami')
    for i=1:length(annot)
        xline(tm(annot(i)), '--o', cmt(i))
    end
else
    title('Korigrian signal FP1')
end

subplot(3,1,3)
plot(tm,sigs(:,22))
hold on
plot(tm,Xap(22,:))
ylim(Ylimit)
xlabel('Čas [s]')
ylabel('Napetost [mV]') % ali je μV?
if (x ~= 1) && (x ~= 2)
    title('Primerjava osnovnega in korigiranega signala FP1 z anotacijami')
    for i=1:length(annot)
        xline(tm(annot(i)), '--o', cmt(i))
    end
    legend('Osnovni signal','Korigiran signal','')
else
    title('Primerjava osnovnega in korigiranega signala signal FP1')
    legend('Osnovni signal','Korigiran signal')
end


% FP2
figure
sgtitle('Signal FP2')
subplot(3,1,1)
plot(tm,sigs(:,24))
Ylimit = get(gca, 'YLim');
ylim(Ylimit)
xlabel('Čas [s]')
ylabel('Napetost [mV]') % ali je μV?
if (x ~= 1) && (x ~= 2)
    title('Osnovni signal FP2 z anotacijami')
    for i=1:length(annot)
        xline(tm(annot(i)), '--o', cmt(i))
    end
else
    title('Osnovni signal FP2')
end

subplot(3,1,2)
plot(tm,Xap(24,:))
ylim(Ylimit)
xlabel('Čas [s]')
ylabel('Napetost [mV]') % ali je μV?
if (x ~= 1) && (x ~= 2)
    title('Korigiran signal FP2 z anotacijami')
    for i=1:length(annot)
        xline(tm(annot(i)), '--o', cmt(i))
    end
else
    title('Korigrian signal FP2')
end

subplot(3,1,3)
plot(tm,sigs(:,24))
hold on
plot(tm,Xap(24,:))
ylim(Ylimit)
xlabel('Čas [s]')
ylabel('Napetost [mV]') % ali je μV?
if (x ~= 1) && (x ~= 2)
    title('Primerjava osnovnega in korigiranega signala FP2 z anotacijami')
    for i=1:length(annot)
        xline(tm(annot(i)), '--o', cmt(i))
    end
    legend('Osnovni signal','Korigiran signal','')
else
    title('Primerjava osnovnega in korigiranega signala signal FP2')
    legend('Osnovni signal','Korigiran signal')
end