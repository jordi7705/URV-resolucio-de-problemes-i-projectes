%Practica 5.1 
%Alumnes: Izan Flores Tortosa i Jordi Vivas Sakuta

clear all
close all

A=0;
B=0;
numsims=1000;

for i = 1:numsims
    M1=rand();
    M2=rand();
    
    if(M1<0.6 && M2<0.7)
       A=A+1;
    end
    
    if(M1<0.6 || M2<0.7)
        B=B+1;
    end
    
end

fprintf('La probabilitat de que succeixi A es del %.2f%%\n', A/numsims *100);

fprintf('La probabilitat de que succeixi B es del %.2f%%\n', B/numsims *100);


fprint('Com mes gran numsims mes exacte es el resultat al calculat teoricament')