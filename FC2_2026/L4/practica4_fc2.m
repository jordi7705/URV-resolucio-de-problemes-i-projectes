%Pràctica 4 
%Alumnes: Izan Flores Tortosa i Jordi Vivas Sakuta
clear all
close all

%1
fs=4*10^6;
dim=20000;
Ts=1/fs;
t=[0:dim-1]*Ts;

%2
Ac=10^-1;
fc=10^6;
fm=5*10^3;
fmax=10*10^3;

b=fmax/fm;

xfm=Ac*cos(2*pi*fc*t + b*sin(2*pi*fm*t));

figure(1)
subplot(2,1,1)
plot(t,xfm)
xlabel('Temps (t)')
ylabel('Amplitud (V)')
title('Representacio xfm en temps')
axis([0 0.2*10^-3 -0.2 0.2])

%3
b
disp(['la profunditat de modulació β del senyal xfm(t) es: 2', ])

%4
disp(['Com la nostra β = 2, es compleix que β>0.2, per tant es una senyal ' ...
    'FM de banda ampla.'])

%5

subplot(2,1,2)
[X , k]= FuncioTFZP( xfm , fs , dim*15);
xlabel('k (Hz)')
ylabel('Xfm(f)')
title('Espectre Xfm')
axis([0.97*10^6 1.03*10^6 0 0.03])

%6

%J0=0.22; J1=0.58; J2=0.35; J3=0.13; J4=0.03;
%wc=fc/(2*pi); wm=fm/(2*pi);
%xfmB=Ac*(J0*(b)*cos(wc*t) + J1*(b)*cos((wc+wm)*t)-cos((wc-wm)*t) + J2*(b)*cos((wc+2*wm)*t)-cos((wc-2*wm)*t) + J3*(b)*cos((wc+3*wm)*t)-cos((wc-3*wm)*t) + J4*(b)*cos((wc+4*wm)*t)-cos((wc-4*wm)*t));
bw = 4*fm*2
disp(['el ample de banda del senyal xfm(t) es: 40 kHz'])

%7

fm=10*10^3;
Am=3;
C1=0;
C2=15;

xm1= C1 + Am*cos(2*pi*fm*t);
xm2= C2 + Am*cos(2*pi*fm*t);

Ac=2;
K1=5*10^3;
fc=10^6;

Xc=Ac*cos(2*pi*fc*t);

fmax=K1*Am
b=fmax/fm

disp(['La desviació màxima de freqüència es: 15 kHz i la β = 1.5'])

%8

vfm1= Ac*cos(2*pi*(fc + K1*C1)*t + b*sin(2*pi*fm*t));
vfm2= Ac*cos(2*pi*(fc + K1*C2)*t + b*sin(2*pi*fm*t));

%9

figure(2)
subplot(2,1,1)
[X , k]= FuncioTFZP( vfm1 , fs , dim*15);
xlabel('k (Hz)')
ylabel('Vfm1(f)')
title('Espectre Vfm1')
axis([0.85*10^6 1.25*10^6 0 0.3])

subplot(2,1,2)
[X , k]= FuncioTFZP( vfm2 , fs , dim*15);
xlabel('k (Hz)')
ylabel('Vfm2(f)')
title('Espectre Vfm2')
axis([0.85*10^6 1.25*10^6 0 0.3])

%10

%  la freqüència central = fc en aquest cas = 1 Mhz

%  VFM1(f) està centrat en fc = 1 Mhz i VFM2(f) està centrat en 1.07 Mhz
 
%  VFM1(f) si està centrada on correspoon en canvi VFM2(f) no això es degut
%  a que la constant C2 no es igual a 0 com si ho es C1 per tant influeix
%  en el despaçament del espectre al sumarse amb fc dintre el coseno.

%11

Ac=1; fc=3.5*10^6; fmax=22.5*10^3;

eixbeta= [1:10^-3:9];
J=besselj(2,eixbeta);
figure(3)
plot(J)

disp(['Els valors de beta on pasa per 0 son 3 i 6'])

fm1=fmax/3
fm2=fmax/6

%12

xfm1=Ac*cos(2*pi*fc*t + b*sin(2*pi*fm1*t));
xfm2=Ac*cos(2*pi*fc*t + b*sin(2*pi*fm2*t));

%13

figure(4)
subplot(2,1,1)
[X , k]= FuncioTFZP( xfm1 , fs , dim*15);
xlabel('k (Hz)')
ylabel('Xfm1(f)')
title('Espectre Xfm1')
axis([4.7*10^5 5.3*10^5 0 0.3])

subplot(2,1,2)
[X , k]= FuncioTFZP( xfm2 , fs , dim*15);
xlabel('k (Hz)')
ylabel('Xfm2(f)')
title('Espectre Xfm2')
axis([4.7*10^5 5.3*10^5 0 0.3])

%14

