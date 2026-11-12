%Practica 4 TDS 
% Valentine Jain i Jordi Vivas

%PRACTICA 4 SISTEMES DISCRETS I TRANSFORMADA Z
clear all
close all

%1

%a

Numerador = [0 1 1];
Denominador = [1 0 -0.89];
ts = 0.1;
sistema1 = tf (Numerador, Denominador, ts) 

%b
figure(1)
pzmap(sistema1);
xlabel('al Axis')
ylabel('I axis)')
title('pole zero map')

%c
disp("plos")
pole(sistema1)
disp("ceros")
zero(sistema1)

%d
figure(2)
impulse(sistema1);
xlabel('Time ')
ylabel('Amplitud')
title('impulse response')

%e
figure(3)
step(sistema1); 
xlabel('Time ')
ylabel('Amplitud')
title('Step response')


%2
%a
G=10;
Array_zeros=[-1j 1j];
Array_pols=[0 0.5-0.5j 0.5+0.5j 0.9 ];
sistema2 = zpk (Array_zeros, Array_pols, G, ts) 

%b
figure(4)
subplot(2,1,1)
impulse(sistema2); 
xlabel('Time ')
ylabel('Amplitud')
title('Step response')

figure(4)
subplot(2,1,2)
step(sistema2); 
xlabel('Time ')
ylabel('Amplitud')
title('Step response')

%c
Array_pols2=[0 0.5-0.5j 0.5+0.5j 1.1 ];
sistema3 = zpk (Array_zeros, Array_pols2, G, ts) 

figure(5)
subplot(2,1,1)
impulse(sistema3); 
xlabel('Time ')
ylabel('Amplitud')
title('Step response')
xlim([0 6])
ylim([0 10*10^4])


figure(5)
subplot(2,1,2)
step(sistema3); 
xlabel('Time ')
ylabel('Amplitud')
title('Step response')
axis([0 6 0 10*10^4]);
disp("inestable pol fora del rang del cercle unitari, l'esglanoament i l'exponencialitat")

%3
%a
x=[1 2 3];
disp("La longitud de x es:")
length(x)

%b
h=[3 2 1];
disp("La longitud de h es:")
length(h)
%c
y=conv(x,h);
longy=length(x)+length(h)-1;

%d

figure(6)
subplot(3,1,1)
stem(x,"black") 
title('x(n)')

figure(6)
subplot(3,1,2)
stem(h,"blue") 
title('h(n)')

figure(6)
subplot(3,1,3)
stem(y,"green") 
title('y(n)')

%e
disp("La longitud de y es:")
longy
disp("que es la longitud de x + la de h -1")

%4

figure(7)
subplot(3,2,1)

%a
n=-5:20;
A= 3;
impulse =(n==5);
stem(n, impulse)
title("delta retardada")

%b
unitstep= 5*(n > 0);

subplot(3,2,2)
stem(n, unitstep)
title("Esgraó")

%c
N1=-2;
N2=3;

subplot(3,2,3)
u1=(n>=N1);
u2=(n>=N2);
pols=0.25*(u1-u2);
stem(n,pols)
title("Pols cuadrat")

%d
subplot(3,2,4)
u=(n>=0);
rampa=n.*u;
stem(n,rampa)
title("rampa")

%e
subplot(3,2,5)
a=1.1;
exp_creixent=(a.^n).*(n>=0);
stem(n,exp_creixent);
title("Exponencial creixent")

%f
subplot(3,2,6)
a=0.9;
exp_decreixent=(a.^n).*(n>=-5);
stem(n,exp_decreixent);
title("Exponencial decreixent")










