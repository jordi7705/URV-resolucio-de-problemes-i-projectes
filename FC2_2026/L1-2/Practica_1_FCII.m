%Pràctica 1-2 
%Alumnes: Izan Flores Tortosa i Jordi Vivas Sakuta
clear all
close all

%part 2
%3
fs=1.4*10^6;
Ts=1/fs;
Tobs=10*10^-3;
mostres= Tobs/Ts;
t=[0:mostres-1]*Ts;

%4
f1=850;
A1=4;
s1= A1*sin(2*pi*f1*t);

%5
f2=410;
A2=8;
s2= A2*sin(2*pi*f2*t);

f3=1580;
A3=3;
s3= A3*sin(2*pi*f3*t);

f4=0;
A4=6;
s4= A4*cos(2*pi*f4*t);

%6
figure(1)
subplot(3,1,1)
plot(s1)
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio s1 en temps')

%7
subplot(3,1,2)
[X, k]=FuncioTFZP(s1,fs,mostres);
xlabel('k(HZ)')
ylabel('S1(f)')
title('Representacio s1 en Frequencia')
axis([-1500 1500 0 2.5])

%8 i 9
subplot(3,1,3)
[X, k]=FuncioTFZP(s1,fs,(mostres*18));
xlabel('k(HZ)')
ylabel('S1(f)')
title('Representacio s1 en Frequencia ZP')
axis([-1500 1500 0 2.5])

%10
rf1= fs/mostres
rf2= fs/(mostres*18)

%part 3
%11

figure(2)
s12=s1+s2;
subplot(2,1,1)
plot(t,s12)
xlabel('temps')
ylabel('senyal s12')
title('Representacio grafica s12 respecte temps')

%12
subplot(2,1,2)
[X, k]=FuncioTFZP(s12,fs,mostres*10);
xlabel('Frequencia (Hz)')
ylabel('senyal s12')
title('Representacio grafica s12 respecte frequencia')
axis([-1100 1100 0 4])

%13
% els pics corresponen quan x = f1 (850) i quan x = f2 (410)

%14
ssuma=s1+s2+s3+s4;
figure(3)
subplot(2,1,1)
plot(t,ssuma)
xlabel('temps')
ylabel('senyal Ssuma')
title('Representacio grafica Ssuma respecte temps')

%15
subplot(2,1,2)
[X, k]=FuncioTFZP(ssuma,fs,mostres*10);
xlabel('Frequencia (Hz)')
ylabel('senyal ssuma')
title('Representacio grafica ssuma respecte frequencia')
axis([-2000 2000 0 7])

%16 els pics corresponen igual que a la primer senyal de suma a
% quan x = f1 (850), quan x = f2 (410) quan x=f3 (1580) i quan x=f4 (0)
%Hi ha pics imparell ja que presenta un pic a F = 0 

%part 4
%17
fq=650;
q20=4*square(2*pi*fq*t,20) + 4;
q50=10*square(2*pi*fq*t,50);

%18
figure(4)
subplot(2,1,1)

plot(t,q20)
xlabel('temps(t)')
ylabel('q20 (V)')
axis([0 0.01 0 9])

subplot(2,1,2)
plot(t,q50)
xlabel('temps(t)')
ylabel('q50 (V)')
axis([0 0.01 -11 11])

%19
figure(5)
subplot(2,1,1)
[X1, k]=FuncioTFZP(q20,fs,mostres*10);
xlabel('Frequencia (Hz)')
ylabel('senyal q20')
title('Representacio grafica q20 respecte frequencia')
axis([-3000 3000 0 2])


subplot(2,1,2)
[X2, k]=FuncioTFZP(q50,fs,mostres*10);
xlabel('Frequencia (Hz)')
ylabel('senyal q50')
title('Representacio grafica q50 respecte frequencia')
axis([-3000 3000 0 7])

%20
figure(6)
subplot(2,1,1)
[PxdBm]=FuncioPotencia(X1,k,50);
xlabel('Decibels (dB)')
ylabel('senyal q20')
title('Representacio grafica q20 respecte dB')
axis([-3000 3000 -20 20])


subplot(2,1,2)
[PxdBm]=FuncioPotencia(X2,k,50);
xlabel('Decibels (dB)')
ylabel('senyal q50')
title('Representacio grafica q50 respecte dB')
axis([-3000 3000 -30 30])

%part 4
%21
gs=1.6*10^6;
Ts=1/gs;
dim= 10000;
t=[0:dim-1]*Ts;

g1=4.5*10^3;
Ag1=1;
g= Ag1*sin(2*pi*g1*t);

%22
w_ham = window(@hamming , dim);
g_ham=g.*w_ham';

w_tri = window(@triang , dim);
g_tri=g.*w_tri';

%23
figure(7)
subplot(3,1,1)
plot(t,g)
xlabel('temps (s)')
ylabel('g(t)')
title('Gràfica senyal g')
axis([0 7*10^-3 -1 1])

subplot(3,1,2)
plot(t,g_ham)
xlabel('temps (s)')
ylabel('g_ham(t)')
title('Gràfica senyal g_ham')

subplot(3,1,3)
plot(t,g_tri)
xlabel('temps (s)')
ylabel('g_tri(t)')
title('Gràfica senyal g_tri')

%24 - 25
figure(8)
subplot(3,1,1)
[X , k]= FuncioTFZP( g , gs , dim*16);
xlabel('k (Hz)')
ylabel('G(f)')
title('Finestra rectangular')
axis([3500 5500 0 0.6])

subplot(3,1,2)
[X , k]= FuncioTFZP( g_ham , gs , dim*16);
xlabel('k (Hz)')
ylabel('G_HAM(f)')
title('Finestra hamming')
axis([3500 5500 0 0.3])

subplot(3,1,3)
[X , k]= FuncioTFZP( g_tri , gs , dim*16);
xlabel('k (Hz)')
ylabel('G_TRI(f)')
title('Finestra triangular')
axis([3500 5500 0 0.3])

%26. A la figura 8, observem la sinc centrada a fa Hz. Quina és la relació d’amplituds entre
%el màxim del lòbul principal de la sinc i el màxim del primer lòbul secundari?

rel_rect = 0.5 / 0.1;     
rel_hamm = 0.27 / 0.01;   
rel_tri  = 0.25 / 0.05;
%Indiqueu per la Command Window aquesta relació per tots tres tipus de finestres i
%indiqueu quina té millor relació LP/LS. Utilitzeu la funció disp(): 
disp(['Relació LP/LS finestra rectangular: 5', ])
disp(['Relació LP/LS finestra Hamming: 27', ])
disp(['Relació LP/LS finestra triangular: 5 ', ])

%La funció amb millor relacio és la funció hamming