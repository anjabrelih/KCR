%% Implementacija vmesnika možgani računalnik za klasifikacijo med dvema motoričnima aktivnostima
% Anja Brelih
% Januar 2023

% OPOMBE:
% funkcije F_getIntervalsm, f_CSP.m ter doClassification.m moratjo biti 
% vključene na poti (lahko sta dodani v mapo mcode, ki je že vključena v 
% pot).
%% ========================================================================
% Globalni parametri

% Začetna pot
cd ('/Users/anjabrelih/Documents/MATLAB')

%% ========================================================================
% Izbira testnega subjekta in aktivnosti
txt = input("Ali želite klasifikacijo opraviti na testnem subjetku 1? Y/N [Y]: ","s");
if isempty(txt)
    txt = 'Y';
end

if txt == 'Y'
    n = 0;
else
    s = input("Izberite testni subjekt (od 1 do 109): ");
    n = 1;
end

% Izbira motorične aktivnosti
fprintf("Izbirate lahko med naslednjimi motoričnimi aktivnostmi:\n" + ...
    "3 - Zapiranje in odprianje desne ali leve dlani.\n" + ...
    "4 - Zamišljanje zapiranja in odprianja desne ali leve dlani.\n" + ...
    "5 - Zapiranje in odprianje obeh dlani ali stopal.\n" + ...
    "6 - Zamišljanje zapiranja in odpiranja obeh dlani ali stopal.\n");
x = input("Katero želite klasificirati? (3, 4, 5, ali 6) ");
if (x == 3) && (x == 4) && (x == 5) && (x == 6)
    x = 3;
    disp("Vnesli ste neveljavno številko. Klasifikacijo bomo izvedli na aktivnosti 3.")
end

record = [];
for i = 0:2
    record = [record string(num2str(x+(i*4), "%02d"))];
end
%disp(record)
%size(record,2)


switch n
    case 0
        % Izbira privzetega testnega subjekta
        db_path = 'files/S001/'; % Preimenujte v ime vaše baze podatkov ter mapo izbranega testnega subjekta
        cd (db_path)
        start_file = 'S001';
        %file_name= 'S001R03.edf'; % Izbrana aktivnost (aktivnosti od 3-14)

    case 1
        % Poljubna izbira
        db_path = 'files'; % Preimenujte v ime vaše baze podatkov oziroma definirajte pot.

        % Izbira testnega subjekta [1 - 109]
        %s = input("Izberite testni subjekt (od 1 do 109): ");

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
            disp("Vnesli ste neveljavno številko. Klasifikacijo bomo izvedli na subjektu 1.")
            path = append(db_path,'/S001/');
            cd (path)
            start_file = 'S001';
        end

end


%% ========================================================================
t1sigs = {};
t2sigs = {};

for i=1:size(record,2)
    % Preberemo datoteke
    file_name = strcat(start_file,'R',convertStringsToChars(record(i)),'.edf');
    [sigs, freq, tm] = rdsamp(file_name, 1:64); % [signali, frekvenca vzorčenja, časovni indeks]
    % Signali so od 1-64; 65 je oznaka (https://www.physionet.org/content/eegmmidb/1.0.0/64_channel_sharbrough.pdf)

    % Preberi anotacije signalov iz datoteke edf.event (za vzorce 3-14)
    [annot, atyp, sbtyp, chn, nm, cmt] = rdann(file_name, 'event');

    % Določitev intervalov s funkcijo F_getIntervals
    [T0, T1, T2] = F_getIntervals(cmt,annot,freq, size(sigs,1));

    % Transponiramo signal
    sigs = sigs.';

    % Intervale dodamo v array
    for j=1:size(T1,1)
        t1sigs{end+1} = sigs(:, T1(j,1):T1(j,2));
    end
    for j=1:size(T2,1)
        t2sigs{end+1} = sigs(:, T2(j,1):T2(j,2));
    end
end

%% KEO filter

% Definiramo pasovno prepustni filter od 8 - 13 Hz
fb = [0 8 8 13 13 freq/2]/(freq/2); %določimo vrednosti (frekvence) in delimo z nyquistovo frekvenco
ints = [0 0 1 1 0 0]; % kje prepuščamo in kje dušimo
n = 69; % število točk - to spreminjamo, da dobimo čimbolši filter (npr. 100 je baje preveč)
%35, 50, 70, 80, 60, 65, 68, 69

% filter (Least-squares linear-phase FIR filter design)
b = firls(n, fb, ints);

%% Učenje prostorskih vzorcev SPV (CSP), filtriranje s filtrom KEO ter računanje logaritem variance

% Učimo s prvo aktivnostjo T1 in prvo aktivnostjo T2
[W] = f_CSP(cell2mat(t1sigs(1)), cell2mat(t2sigs(1)));

% Odstranimo elementa za učenje iz celice
t1sigs(1) = [];
t2sigs(1) = [];

% Uporabimo filter W, KEO filter in izračunamo logaritem variance
% T1
lvt1 = zeros(size(t1sigs,2),2);
for i = 1:size(t1sigs,2)
    csp_t = W * cell2mat(t1sigs(i)); % filtriranje s fitrom W
    csp_e = [csp_t(1,:).', csp_t(size(csp_t,1),:).'].'; % ekstremizirane komponente
    csp_fir = filter(b,1,csp_e); % Filtriramo signale s FIR (KEO) filtrom
    lvt1(i,1) = log(var(csp_fir(1,:))); % logaritem variance
    lvt1(i,2) = log(var(csp_fir(2,:)));
    
    % Močnostni spekter
    fftSig = fft(csp_fir);
    len = length(csp_fir);
    %f = (0:len-1)*(freq/len);
    pow = abs(fftSig).^2/len;
    %figure
    %plot(f,pow)
    %title("T1")
    %fftlv1(i,1) = log(var(fftSig(1,:)));
    %fftlv1(i,2) = log(var(fftSig(2,:)));

    pow1(i,1) = log(var(pow(1,:)));
    pow1(i,2) = log(var(pow(2,:)));
end

% T2
lvt2 = zeros(size(t2sigs,2),2);
for i = 1:size(t2sigs,2)
    csp_t = W * cell2mat(t2sigs(i)); % filtriranje s fitrom W
    csp_e = [csp_t(1,:).', csp_t(size(csp_t,1),:).'].'; % ekstremizirane komponente
    csp_fir = filter(b,1,csp_e); % Filtriramo signale s FIR (KEO) filtrom
    lvt2(i,1) = log(var(csp_fir(1,:))); % logaritem variance
    lvt2(i,2) = log(var(csp_fir(2,:)));

    % Močnostni spekter
    fftSig = fft(csp_fir);
    len = length(csp_fir);
    %f = (0:len-1)*(freq/len);
    pow = abs(fftSig).^2/len;
    %figure
    %plot(f,pow)
    %title("T2")
    %fftlv2(i,1) = log(var(fftSig(1,:)));
    %fftlv2(i,2) = log(var(fftSig(2,:)));
    
    pow2(i,1) = log(var(pow(1,:)));
    pow2(i,2) = log(var(pow(2,:)));
end

%% Scatter plot logaritma variance
figure
scatter(lvt1(:,1), lvt1(:,2), 'o')
hold on
scatter(lvt2(:,1), lvt2(:,2), 'x')
legend('T1','T2')
title('Značilke aktivnosti T1 in T2 v prostoru komponent')

figure
scatter(pow1(:,1), pow1(:,2), 'o')
hold on
scatter(pow2(:,1), pow2(:,2), 'x')
legend('T1','T2')
title('Značilke aktivnosti T1 in T2 v frekvenčnem prostoru preko močnostnih spektrov')

%% Klasifikacija z linearno diskriminantno analizo (LDA) in kvadratično diskriminantno analizo (QDA)
% Naredimo datoteke
featVFile = 'featureVectors.txt';
classFile = 'referenceClass.txt';

fvf = fopen(featVFile, "wt");
rcf = fopen(classFile, "wt");

% Zapis v datoteke
for i=1:size(lvt1,1)
    %fprintf(fvf, "%.8f %.8f\n", lvt1(i,1), lvt1(i,2));
    fprintf(fvf, "%.8f %.8f %.8f %.8f\n", lvt1(i,1), lvt1(i,2), pow1(i,1), pow1(i,2));
    fprintf(rcf, "T1\n");
end
for i=1:size(lvt2,1)
    %fprintf(fvf, "%.8f %.8f\n", lvt2(i,1), lvt2(i,2));
    fprintf(fvf, "%.8f %.8f %.8f %.8f\n", lvt2(i,1), lvt2(i,2), pow2(i,1), pow2(i,2));
    fprintf(rcf, "T2\n");
end

fclose(fvf);
fclose(rcf);

%% Klasifikacija
doClassification('featureVectors.txt', 'referenceClass.txt', {1,1}, 10, 50, 0)
