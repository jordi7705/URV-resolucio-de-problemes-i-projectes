%Practica 1 TDS 
% Valentine Jain i Jordi Vivas

%PRÀCTICA 2 QUANTIFICACIÓ
clear all
close all

%1

%a

Ts=1*10^-6;
t=[-1:Ts:1];

x=t;

figure(1)
subplot(1,1,1)
plot(t,x,"Black")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio senyal rampa x(t) en temps')
grid on;
%b
vmax=max(x);
vmin=min(x);

nbits=4;
n=2^nbits;
delta=(vmax-vmin)/n;
x4b=quant(x,delta);

x_error=x-x4b;

%c
hold on;
plot(t,x4b,"Blue")
plot(t,x_error,"Red")
legend("senyal","senyal quantificat","error de quantificació")
hold off;

%2 bits
nbits=2;
n=2^nbits;
delta=(vmax-vmin)/n;
x2b=quant(x,delta);

x_error2=x-x2b;


%1 bit

nbits=1;
n=2^nbits;
delta=(vmax-vmin)/n;
x1b=quant(x,delta);

x_error1=x-x1b;

%e f

figure(2)
subplot(1,3,1)
plot(t,x,"Black")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio senyal rampa x(t) en temps')
grid on;

hold on;
plot(t,x4b,"Blue")
plot(t,x_error,"Red")
legend("senyal","senyal quantificat","error de quantificació")
hold off;


figure(2)
subplot(1,3,2)
plot(t,x,"Black")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
grid on;

hold on;
plot(t,x2b,"Blue")
plot(t,x_error2,"Red")
legend("senyal","senyal quantificat","error de quantificació")
hold off;

figure(2)
subplot(1,3,3)
plot(t,x,"Black")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
grid on;

hold on;
plot(t,x1b,"Blue")
plot(t,x_error1,"Red")
legend("senyal","senyal quantificat","error de quantificació")
hold off;


%2
%a
load shorttalk.mat

Fs=40000;

Ts=1/Fs;

nts=[0:Ts:3];

figure(3)
subplot(1,1,1)
plot(nts,shorttalk,"Black")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio senyal shorttalk en temps')
axis([1.5 1.55 -0.5 0.5])
grid on;


%b
sh_vmax=max(shorttalk);
sh_vmin=min(shorttalk);

nbits=4;
n=2^nbits;
delta=(sh_vmax-sh_vmin)/n;
shorttalk_4b=quant(shorttalk,delta);

short_error=shorttalk-shorttalk_4b;

hold on;
plot(nts,shorttalk_4b,"Blue")
plot(nts,short_error,"Red")
axis([1.5 1.55 -0.5 0.5])
legend("senyal","senyal quantificat","error de quantificació")
hold off;

sn=var(shorttalk)/var(short_error);

SN=10*log10(sn);
disp("El S/N es de 12,5573 dB")


%c d e 
%8 bits
nbits=8;
n=2^nbits;
delta=(sh_vmax-sh_vmin)/n;
shorttalk_8b=quant(shorttalk,delta);

short_error8=shorttalk-shorttalk_8b;

sn8=var(shorttalk)/var(short_error8);

SN8=10*log10(sn8);
disp("El S/N 8 bits es de 34,7597 dB")

figure(4)
subplot(4,1,1)
plot(nts,shorttalk,"Black")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio senyal shorttalk en temps')
axis([1.5 1.55 -0.5 0.5])
grid on;

hold on;
plot(nts,shorttalk_8b,"Blue")
plot(nts,short_error8,"Red")
axis([1.5 1.55 -0.5 0.5])
legend("senyal","senyal quantificat","error de quantificació")
hold off;


%6 bits

nbits=6;
n=2^nbits;
delta=(sh_vmax-sh_vmin)/n;
shorttalk_6b=quant(shorttalk,delta);

short_error6=shorttalk-shorttalk_6b;

sn6=var(shorttalk)/var(short_error6);

SN6=10*log10(sn6);
disp("El S/N 6 bits es de 23,1541 dB")

figure(4)
subplot(4,1,2)
plot(nts,shorttalk,"Black")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio senyal shorttalk en temps')
axis([1.5 1.55 -0.5 0.5])
grid on;

hold on;
plot(nts,shorttalk_6b,"Blue")
plot(nts,short_error6,"Red")
axis([1.5 1.55 -0.5 0.5])
legend("senyal","senyal quantificat","error de quantificació")
hold off;

%2 bits

nbits=2;
n=2^nbits;
delta=(sh_vmax-sh_vmin)/n;
shorttalk_2b=quant(shorttalk,delta);

short_error2=shorttalk-shorttalk_2b;

sn2=var(shorttalk)/var(short_error2);

SN2=10*log10(sn2);
disp("El S/N 2 bits es de 3,2961 dB")

figure(4)
subplot(4,1,4)
plot(nts,shorttalk,"Black")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio senyal shorttalk en temps')
axis([1.5 1.55 -0.5 0.5])
grid on;

hold on;
plot(nts,shorttalk_2b,"Blue")
plot(nts,short_error2,"Red")
axis([1.5 1.55 -0.5 0.5])
legend("senyal","senyal quantificat","error de quantificació")
hold off;


%El de 4 bits

figure(4)
subplot(4,1,3)
plot(nts,shorttalk,"Black")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio senyal shorttalk en temps')
axis([1.5 1.55 -0.5 0.5])
grid on;

hold on;
plot(nts,shorttalk_4b,"Blue")
plot(nts,short_error,"Red")
axis([1.5 1.55 -0.5 0.5])
legend("senyal","senyal quantificat","error de quantificació")
hold off;

disp("short original")
sound(shorttalk,Fs)
pause(4)

%%
%quantificats
disp("short8")
sound(shorttalk_8b,Fs)
pause(4)
disp("short6")
sound(shorttalk_6b,Fs)
pause(4)
disp("short4")
sound(shorttalk_4b,Fs)
pause(4)
%%
disp("short2")
sound(shorttalk_2b,Fs)
%%
%error quantificacio

%%
disp("short_error8")
sound(short_error8,Fs)
pause(4)
disp("short_error6")
sound(short_error6,Fs)
pause(4)
disp("short_error4")
sound(short_error,Fs)
pause(4)
disp("short_error2")
sound(short_error2,Fs)

%El de 2 bits no es pot entendre perque l'error de quantificacio es molt
%gran

%Contra menys bits tinguem menor sera el valor de S/N en dB si degut a que
%perdem mes informació a menors nombres de bits

%3

%%

Kmu=255;
Ka=87.6;
xMu=compand(x,Kmu,vmax,'mu/compressor');
xa=compand(x,Ka,vmax,'a/compressor');

figure(5)
subplot(1,1,1)

plot(t,xa,"Red")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio senyal rampa x(t) en temps')
grid on;

hold on;
plot(t,x,"Black")
plot(t,xMu,"Blue")
hold off;


Expa=compand(xa,Ka,vmax,'a/expander');
ExpMu=compand(xMu,Kmu,vmax,'mu/expander');


figure(6)
subplot(1,1,1)

plot(t,Expa,"Red")
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio senyal rampa x(t) en temps')
grid on;

hold on;
plot(t,x,"Black")
plot(t,ExpMu,"Blue")
hold off;

%El resultat es el senyal original ja que hem fet un compand i despres un
%expand d'aquest


Ks=10;

%Compand
shorttalkMu =compand(shorttalk,Ks,vmax,'mu/compressor');

%Quantificar
nbits=8;
n=2^nbits;
delta=(vmax-vmin)/n;
shorttalkMu8b=quant(shorttalkMu,delta);

nbits=4;
n=2^nbits;
delta=(vmax-vmin)/n;
shorttalkMu4b=quant(shorttalkMu,delta);

nbits=2;
n=2^nbits;
delta=(vmax-vmin)/n;
shorttalkMu2b=quant(shorttalkMu,delta);

%Expand


shorttalkMu8bEx = compand(shorttalkMu8b,Ks,vmax,'mu/expander');

shorttalkMu4bEx = compand(shorttalkMu4b,Ks,vmax,'mu/expander');

shorttalkMu2bEx = compand(shorttalkMu2b,Ks,vmax,'mu/expander');

% error de quantificació

error8b = shorttalkEx - shorttalkMu8bEx;

error4b = shorttalkEx - shorttalkMu4bEx;

error2b = shorttalkEx - shorttalkMu2bEx;


%S/N

sn8=var(shorttalk)/var(error8b);
SN8=10*log10(sn8)
disp('dBs')

sn4=var(shorttalk)/var(error4b);
SN4=10*log10(sn4)
disp('dBs')

sn2=var(shorttalk)/var(error2b);
SN2=10*log10(sn2)
disp('dBs')

%Aplicant mu aconseguim aplificar els senyals de baixa amplitud es per aixo
%que aconseguim mes dBs

%Comparacio sounds

%quantificats
%%
disp("short8")
sound(shorttalk_8b,Fs)

pause(4)
disp("shorttalkMu8bEx")
sound(shorttalkMu8bEx,Fs)

pause(4)
disp("short4")
sound(shorttalk_4b,Fs)

pause(4)
disp("shorttalkMu4bEx")
sound(shorttalkMu4bEx,Fs)

pause(4)
disp("short2")
sound(shorttalk_2b,Fs)

pause(4)
disp("shorttalkMu2bEx")
sound(shorttalkMu2bEx,Fs)

%Els compensat en mu i despres quantificats tenen millor resultat aquesta
%diferencia es presenta mes a menys bits tingui el senyal digital