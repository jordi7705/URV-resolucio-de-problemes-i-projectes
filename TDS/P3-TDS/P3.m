%Practica 3 TDS 
% Valentine Jain i Jordi Vivas

%PRÀCTICA 3 LA FREQÜÈNCIA EN EL DOMINI DISCRET
clear all
close all

%1
%a

n= 0:100;

%b
A=3;
fd1= 0.1;

Xn1 = A*sin(2*pi*fd1*n);

%c

fd2 = 7/25;
fd3 = 0.3;
fd4 = 1/sqrt(13);

Xn2 = A*sin(2*pi*fd2*n);
Xn3 = A*sin(2*pi*fd3*n);
Xn4 = A*sin(2*pi*fd4*n);

%d

%xn1 es periodica de periode 10
%xn2 son numeros racionals per tant també es periodica de periode 25
%xn3 es periodica de periode 10 també
%xn4 irracional per tant no periodica

%e

figure(1)
subplot(4,1,1)
stem(n,Xn1)
xlabel('Mostres')
ylabel('Amplitud(V)')
title('fd1 cicles/mostra')


subplot(4,1,2)
stem(n,Xn2)
xlabel('Mostres')
ylabel('Amplitud(V)')
title('fd2 cicles/mostra')


subplot(4,1,3)
stem(n,Xn3)
xlabel('Mostres')
ylabel('Amplitud(V)')
title('fd3 cicles/mostra')


subplot(4,1,4)
stem(n,Xn4)
xlabel('Mostres')
ylabel('Amplitud(V)')
title('fd4 cicles/mostra')


%f coincideixen amb les calculades

%2
A=10;

fd1= 0.02;
fd2 = 1.02;
fd3 = 2.02;
fd4 = -0.98;

Xn1 = A*sin(2*pi*fd1*n);
Xn2 = A*sin(2*pi*fd2*n);
Xn3 = A*sin(2*pi*fd3*n);
Xn4 = A*sin(2*pi*fd4*n);

figure(2)
subplot(4,1,1)
stem(n,Xn1)
xlabel('Mostres')
ylabel('Amplitud(V)')
title('fd1 cicles/mostra')


subplot(4,1,2)
stem(n,Xn2)
xlabel('Mostres')
ylabel('Amplitud(V)')
title('fd2 cicles/mostra')


subplot(4,1,3)
stem(n,Xn3)
xlabel('Mostres')
ylabel('Amplitud(V)')
title('fd3 cicles/mostra')


subplot(4,1,4)
stem(n,Xn4)
xlabel('Mostres')
ylabel('Amplitud(V)')
title('fd4 cicles/mostra')


%c

%com s'ha mencionat a la part teorica la freqüència fonamental es la
%mateixa per les 4 senyals per tant les cuatres senyals son iguals


%3
%a


t = linspace(0,0.1,1001);
A=5;

fa1=50;
fa2=550;

xa1 = A*sin(2*pi*t*fa1);
xa2 = A*sin(2*pi*t*fa2);


%b
Ts=2*10^-3;
%Fs=1/Ts;
n=0:Ts:0.1;

%c
xd1 = A*sin(2*pi*n*fa1);
xd2 = A*sin(2*pi*n*fa2);


%d
figure(3)
subplot(3,1,1)
plot(t,xa1)
xlabel('Temps')
ylabel('Amplitud(V)')
title('Xa1 i xa2')
grid on;

hold on;
plot(t,xa2,"Red")
hold off;



figure(3)
subplot(3,1,2)
stem(n,xd1)
xlabel('Mostres')
ylabel('Amplitud(V)')
title('x1n cicles/mostra')

figure(3)
subplot(3,1,3)
stem(n,xd2)
xlabel('Mostres')
ylabel('Amplitud(V)')
title('x2n cicles/mostra')
