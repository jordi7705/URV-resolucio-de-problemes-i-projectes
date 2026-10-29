%Practica 5.2
%Alumnes: Izan Flores Tortosa i Jordi Vivas Sakuta

clear all
close all

A=0;
iteracions=1000;


for i = 1:iteracions
    nclients=poissrnd(5);
    paquets=0;
    for j =1:nclients
        numAleatori=rand();
         
        if numAleatori<=0.4
            paquets=paquets+1;
        end
         if (numAleatori>0.4 && numAleatori<=0.7)
            paquets=paquets+2;
         end
         if (numAleatori>0.7 && numAleatori<=0.9)
            paquets=paquets+3;
         end
         if numAleatori>0.9
            paquets=paquets+4;
         end
        
    end
    if(paquets<=10)
        A=A+1;
    end
end

fprintf('La probabilitat de que succeixi A es del %.2f%%\n',(A/iteracions)*100)
