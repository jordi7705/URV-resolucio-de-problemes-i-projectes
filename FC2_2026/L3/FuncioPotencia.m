function [PxdBm] = FuncioPotencia ( X , k , Z) 

Px=1/Z * (X.*conj(X))

PxdBm=10*log10 (Px*1000)

plot(k,fftshift(PxdBm))



end