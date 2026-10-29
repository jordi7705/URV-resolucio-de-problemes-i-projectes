%Practica 1 TDS 
% Valentine Jain i Jordi Vivas

%1. EFECTE DEL MOSTREIG I TEOREMA DE NYQUIST
clear all
close all
%Creació del senyal analògic

%a
Ts=1*10^-6;
t=[0:Ts:1];

f1=20;
A1=5;
s1= A1*cos(2*pi*f1*t);

figure(1)
subplot(1,1,1)
plot(t,s1)
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio s1 en temps')


%b
fs=20;
ts=1/fs;
n=[0:ts:1];

%c
sd = A1*cos(2*pi*f1*n);

%d
hold;
stem(n,sd);

%e

f2=18; 
f3=10;
f4=5;
f5=2;

s2= A1*cos(2*pi*f2*t);
s3= A1*cos(2*pi*f3*t);
s4= A1*cos(2*pi*f4*t);
s5= A1*cos(2*pi*f5*t);

%f
sd2 = A1*cos(2*pi*f2*n);
sd3 = A1*cos(2*pi*f3*n);
sd4 = A1*cos(2*pi*f4*n);
sd5 = A1*cos(2*pi*f5*n);

figure(2)
subplot(5,1,1)
plot(t,s1)
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio s1 en temps')
hold;
stem(n,sd);

figure(2)
subplot(5,1,2)
plot(t,s2)
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio s2 en temps')
hold;
stem(n,sd2);

figure(2)
subplot(5,1,3)
plot(t,s3)
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio s3 en temps')
hold;
stem(n,sd3);

figure(2)
subplot(5,1,4)
plot(t,s4)
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio s4 en temps')
hold;
stem(n,sd4);

figure(2)
subplot(5,1,5)
plot(t,s5)
xlabel('Temps (t)')
ylabel('Voltatge (V)')
title('Representacio s5 en temps')
hold;
stem(n,sd5);

%h
%No son iguals analogicament ja que la senyal s2 no compleix Nyquist en
%cavni la s5 si es per aixo que la senyal de mostreix coincideix

%i 
%Les ultimes 3 si es poden identificar ja que si segueixen Nyquist en 
%canvi les dos primeres no

%2 AVALUACIÓ DEL TEOREMA DE NYQUIST AMB SENYALS REALS D’AUDIO

%a 
load dancehalldays.mat

Fdan=40000;

disp("delmat 3")
senyal_delmat= downsample( dancehalldays , 3);

sound(senyal_delmat,Fdan/3)
pause(12);

disp("delmat 2")
senyal_delmat2= downsample( dancehalldays , 2);

sound(senyal_delmat2,Fdan/2)
pause(12);

disp("delmat 4")
senyal_delmat4= downsample( dancehalldays , 4);

sound(senyal_delmat4,Fdan/4)
pause(12);

disp("delmat 5")
senyal_delmat5= downsample( dancehalldays , 5);

sound(senyal_delmat5,Fdan/5)
pause(12);

disp("delmat 8")
senyal_delmat8= downsample( dancehalldays , 8);

sound(senyal_delmat8,Fdan/8)
pause(12);

%%
%d
load("somoselectricos.mat")

disp("Somos electricos")
sound(somoselectricos,Fdan)
pause(12);
%e

disp("delmat 2")
senyal_delmat2= downsample( somoselectricos , 2);

sound(senyal_delmat2,Fdan/2)
pause(12);

disp("delmat 4")
senyal_delmat4= downsample( somoselectricos , 4);

sound(senyal_delmat4,Fdan/4)
pause(12);

disp("delmat 5")
senyal_delmat5= downsample( somoselectricos , 5);

sound(senyal_delmat5,Fdan/5)
pause(12);

disp("delmat 8")
senyal_delmat8= downsample( somoselectricos , 8);

sound(senyal_delmat8,Fdan/8)
pause(12);

%%
%f g
disp("delmat 5 downsample")
sound(senyal_delmat5,Fdan/5)
pause(12);

disp("delmat 5 decimate")
senyal_delmat5 = decimate(somoselectricos,5);
sound(senyal_delmat5,Fdan/5)
pause(12);

%h
disp("delmat 8 downsample")
sound(senyal_delmat8,Fdan/8)
pause(12);

disp("delmat 8 decimate")
senyal_delmat8 = decimate(somoselectricos,8);
sound(senyal_delmat8,Fdan/8)
pause(12);

%i
%El factor dalmat te sentit fins a un punt ja que redueix la memoria
%necesaria pero hi ha un limit on la perdua de calitat ja es notable
%El Decimate es millor ja que elimines el soroll per tant el audio es mes
%nitid

%%
%3

%a
fs2=40000;
Ts2=1/fs2;
nd=[0:Ts2:1];

F1=1000;
F2=2000;
F4=4000;
F6=6000;
F9=9000;
F11=11000;
F14=14000;
F16=16000;
F18=18000;
F19=19000;

A=1;
%b
d1=A*cos(2*pi*F1*nd);
d2=A*cos(2*pi*F2*nd);
d4=A*cos(2*pi*F4*nd);
d6=A*cos(2*pi*F6*nd);
d9=A*cos(2*pi*F9*nd);
d11=A*cos(2*pi*F11*nd);
d14=A*cos(2*pi*F14*nd);
d16=A*cos(2*pi*F16*nd);
d18=A*cos(2*pi*F18*nd);
d19=A*cos(2*pi*F19*nd);

%c
disp("d1");
sound(d1,F1)
pause(2);

disp("d2");
sound(d2,F2)
pause(2);

disp("d4");
sound(d4,F4)
pause(2);

disp("d6");
sound(d6,F6)
pause(2);

disp("d9");
sound(d9,F9)
pause(2);

disp("d11");
sound(d11,F11)
pause(2);

disp("d14");
sound(d14,F14)
pause(2);

disp("d19");
sound(d19,F19)
pause(2);

%A partir de la d19
%%
fs3=20000;
Ts3=1/fs3;
nd2=[0:Ts3:1];

d1=A*cos(2*pi*F1*nd2);
d2=A*cos(2*pi*F2*nd2);
d4=A*cos(2*pi*F4*nd2);
d6=A*cos(2*pi*F6*nd2);
d9=A*cos(2*pi*F9*nd2);
d11=A*cos(2*pi*F11*nd2);
d14=A*cos(2*pi*F14*nd2);
d16=A*cos(2*pi*F16*nd2);
d18=A*cos(2*pi*F18*nd2);
d19=A*cos(2*pi*F19*nd2);
d20=A*cos(2*pi*20000*nd2);

%c
disp("d1");
sound(d1,F1)
pause(2);

disp("d2");
sound(d2,F2)
pause(2);

disp("d4");
sound(d4,F4)
pause(2);

disp("d6");
sound(d6,F6)
pause(2);

disp("d9");
sound(d9,F9)
pause(2);

disp("d11");
sound(d11,F11)
pause(2);

disp("d14");
sound(d14,F14)
pause(2);

disp("d19");
sound(d19,F19)
pause(2);

disp("d20");
sound(d20,20000)
pause(2);

%la d9 i la d11 sonen igual
