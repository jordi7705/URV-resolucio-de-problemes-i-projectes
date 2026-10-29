clear all
close all

%Ex 13/05

%AM

fs=1e8;
%moduluadora
Am=1;
dim=12000;
t=(0:dim-1)*1/fs;
fm=150e3;
Xm=cos(2*pi*fm*t);

%portadora
fc=10e6;
Ac=0.07;
Xc=Ac*cos(fc*pi*2*t);

%indexx modulacio
m= 0.4;
Sam= Xc.*(1+ m.*Xm);

%Resistencia
z=50;
%zero padding
figure(1)
[X,k]=FuncioTFZP(Sam, fs, dim*10);
xlabel('Frequencia(Hz)')
ylabel('Amplitud(V)')
title("Espectre SAM")

%plot
figure(2)
[PxBm]=FuncioPotencia(X,k,z);
xlabel('K(hz)')
ylabel('XDBL(dBm)')
title('Funcio Potencia Sam')
axis([9.6e6 1.04e7 -45 -10 ])


%PROB.


A=0;

numsims=10000;

for i = 1:numsims
    M1=rand();
    M2=rand();
    
    if(M1<0.7 && M2<0.5)
       A=A+1;
    end
    
end

fprintf('La probabilitat de que succeixi A es del %.2f%%\n', A/numsims *100);

%Ex 14/05
%BLS.

fs=1e8;
Am=1;
dim=12000;
t=(0:dim-1)*1/fs;
fm=160e3;
Xm=cos(2*pi*fm*t);

%portadora
fc=8e6;
Ac=0.25;
Xc=Ac*cos(fc*pi*2*t);


xm=Am*sin(2*pi*fm*t);
Sbli=Xm.*Xc + xm*Ac.*sin(2*pi*fc*t);
Sbls=Xm.*Xc - xm*Ac.*sin(2*pi*fc*t);


figure(3)
subplot(2,1,1)
[X , k]= FuncioTFZP(Sbli, fs, dim*10);
title('Espectre Sbli')
xlabel('k (Hz)')
ylabel('XBLUi')
axis([7e6 8e6 0 0.12])
subplot(2,1,2)
[X , k]= FuncioTFZP(Sbls, fs, dim*10);
title('Espectre Sbls')
xlabel('k (Hz)')
ylabel('XBLUs')
axis([8e6 8.3e6 0 0.15])


%FM


fs=4e6;
dim=20000;
Ts=1/fs;
t=[0:dim-1]*Ts;

%Portadora
Ac=1;
fc=3.5e6;
%moduladora
fm=1.3e3;

b=7.59; %mirar cuan B es zero en la j corresponent

xfm=Ac*cos(2*pi*fc*t + b*sin(2*pi*fm*t));




Ac=1; fc=3.5*10^6; fmax=22.5*10^3;

eixbeta= [1:10^-3:9];
J=besselj(2,eixbeta);
figure(4)
plot(J)
