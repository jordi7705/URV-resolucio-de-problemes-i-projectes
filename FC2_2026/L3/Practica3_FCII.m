%Pràctica 3
%Alumnes: Izan Flores Tortosa i Jordi Vivas Sakuta
clear all
close all

%1. Senyal modular

Am=1;
fs=1e8;
dim=12000;
t=(0:dim-1)*1/fs;
fm=125e3;
Xm=cos(2*pi*fm*t);

%2. Senyal portadora

fc=3.2e6;
Ac=0.25;
Xc=Ac*cos(fc*pi*2*t);

%3. Senyal en AM

m= 0.8;
Sam= Xc.*(1+ m.*Xm);

%4
figure(1)
subplot(2,1,1)
plot(t, Sam)
xlabel('Temps(s)')
ylabel('Tensio(V)')
title('Senyal Sam')
axis([0 40e-6 -0.5 0.5])


%5. Espetre Sam

subplot(2,1,2)
[X,k]=FuncioTFZP(Sam, fs, dim*10);
xlabel('Frequencia(Hz)')
ylabel('Amplitud(V)')
title("Espectre SAM")
axis([2.9e6 3.5e6 0 0.12])

%6. Index de modulació

Emax=0.4492;
Emin=0.05;
m_e=(Emax-Emin)/(Emax+Emin);

%7. Freqüències portadora y moduladora.

% Els valors de fc i fm comprovat amb els cursors corresponen a 
% als valors introduits als apartats previs: fc= 3.2 MHz fm= 125 kHz

%8. Potència dBm de  la senyal AM

z=50;
figure(2)
[PxBm]=FuncioPotencia(X,k,z);
xlabel('K(hz)')
ylabel('XDBL(dBm)')
title('Funcio Potencia Sam')
axis([2.9e6 3.5e6 -30 -5])

%9.Index de modulació a partir de l'espectre 
dBm2=-12.9;
dBm1=-5;
% dBm2-dBm1=20*log(m)-6
% (dBm2-dBm1+6)/20=log(m)
mnova= 10^((dBm2-dBm1+6)/20);
disp(['m :', ])
disp(mnova)


%10. Senyal DBL

Sdbl= Xm.*Xc;

%11. Gràfica Sdbl

figure(3)
subplot(2,1,1)
plot(t, Sdbl);
xlabel('Temps(s)')
ylabel('Tensio(V)')
title('Senyal Sdbl')
axis([0 40e-6 -0.3 0.3])

%12. Espectre senyal Sdbl

subplot(2,1,2)
[X,k]=FuncioTFZP(Sdbl, fs, dim*10);
xlabel('k (Hz)')
ylabel('XDBL')
title('Espectre senyal Sdbl')
axis([2.9e6 3.5e6 0 0.08])

%13. Senyal BLU; BLS i BLI

xm=Am*sin(2*pi*fm*t);
Sbli=Xm.*Xc + xm*Ac.*sin(2*pi*fc*t);
Sbls=Xm.*Xc - xm*Ac.*sin(2*pi*fc*t);

%14. Representació gràfica BLS i BLI

z=50;
figure(4)
subplot(2,1,1)
[X , k]= FuncioTFZP(Sbli, fs, dim*10);
title('Espectre Sbli')
xlabel('k (Hz)')
ylabel('XBLUi')
axis([2.9e6 3.5e6 0 0.12])
subplot(2,1,2)
[X , k]= FuncioTFZP(Sbls, fs, dim*10);
title('Espectre Sbls')
xlabel('k (Hz)')
ylabel('XBLUs')
axis([2.9e6 3.5e6 0 0.12])










