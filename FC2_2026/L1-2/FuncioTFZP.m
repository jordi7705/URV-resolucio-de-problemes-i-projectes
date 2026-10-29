function [X , k]= FuncioTFZP( x , fs , dimFinal) 

punts=length(x);

X=(1/punts) * fft(x,dimFinal);

k=( 0 : dimFinal-1 )*(fs/dimFinal) -(fs/2);

plot(k , fftshift( abs(X)) , '-*' )

end