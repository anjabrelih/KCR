function [T0, T1, T2] = F_getIntervals(cmt, annot, freq, siglen)
%% Vhod v funkcijo za pridobivanje intervalov: komentar, anotacije in frekvenca prebranega signala

% Definicija izhodnih spremenljivk
T0 = [];
T1 = [];
T2 = [];

cmt = string(cmt); % konvergiraj array cmt v string

for i = 1:size(annot)
    split = strsplit(cmt(i), " "); % razdelimo string
    duration = str2double(split(3))*freq-1; % -1, da ne vzamemo prvega vzorca naslednjega intervala
    stop = annot(i)+duration;% določimo konec intervala
    stop = min(stop, siglen);
    if (split(1)=="T0") % pogledamo za kater interval gre in ga dodamo izhodni spremenljivki
        T0 = [T0;[annot(i) stop]];
    elseif (split(1)=="T1")
        T1 = [T1;[annot(i) stop]];
    else
        T2 = [T2;[annot(i) stop]];
    end
end
end

