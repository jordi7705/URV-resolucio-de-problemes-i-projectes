public class MesuraDia {
    private double[] hores;

    /**
	 * Constructor per defecte, sense paràmetres inicialitza a uns valors de
	 * referència
	 */
    public MesuraDia(){
        hores = new double[24];
        hores[0]=100.0;
        hores[1]=100.0;
        hores[2]=100.0;
        hores[3]=100.0;
        hores[4]=100.0;
        hores[5]=100.0;
        hores[6]=100.0;
        hores[7]=100.0;
        hores[8]=100.0;
        hores[9]=100.0;
        hores[10]=100.0;
        hores[11]=100.0;
        hores[12]=100.0;
        hores[13]=100.0;
        hores[14]=100.0;
        hores[15]=100.0;
        hores[16]=100.0;
        hores[17]=100.0;
        hores[18]=100.0;
        hores[19]=100.0;
        hores[20]=100.0;
        hores[21]=100.0;
        hores[22]=100.0;
        hores[23]=100.0;
    }
    
    /**
     * constructor de parametres no utilitzat degut a que no ens demanen parametres per teclat o això he entes dels enunciats
     */
      public MesuraDia(double h1,double h2,double h3,double h4,double h5,double h6,double h7,double h8,double h9,double h10,double h11,double h12,double h13,double h14,double h15,double h16,double h17,double h18,double h19,double h20,double h21,double h22,double h23,double h24){
        hores[0]=h1;
        hores[1]=h2;
        hores[2]=h3;
        hores[3]=h4;
        hores[4]=h5;
        hores[5]=h6;
        hores[6]=h7;
        hores[7]=h8;
        hores[8]=h9;
        hores[9]=h10;
        hores[10]=h11;
        hores[11]=h12;
        hores[12]=h13;
        hores[13]=h14;
        hores[14]=h15;
        hores[15]=h16;
        hores[16]=h17;
        hores[17]=h18;
        hores[18]=h19;
        hores[19]=h20;
        hores[20]=h21;
        hores[21]=h22;
        hores[22]=h23;
        hores[23]=h24;
    }
     
    /*
     * getter
     */
    public double getMesura(int i){
        return hores[i];
    }
    /*
     * setter
     */
    public void setMesura(int hora, double mesura){
        hores[hora]=mesura;
    }

    @Override
    public String toString(){
        return("Mesures del dia determinat ordenat per hores => "+hores[0]+" mg/dL , "+hores[1]+" mg/dL , "+hores[2]+" mg/dL , "+hores[3]+" mg/dL , "+hores[4]+" mg/dL , "+hores[5]+" mg/dL , "+hores[6]+" mg/dL , "+hores[7]+" mg/dL , "+hores[8]+" mg/dL , "+hores[9]+" mg/dL , "+hores[10]+" mg/dL , "+hores[11]+" mg/dL , "+hores[12]+" mg/dL , "+hores[13]+" mg/dL , "+hores[14]+" mg/dL , "+hores[15]+" mg/dL , "+hores[16]+" mg/dL , "+hores[17]+" mg/dL , "+hores[18]+" mg/dL , "+hores[19]+" mg/dL , "+hores[20]+" mg/dL , "+hores[21]+" mg/dL , "+hores[22]+" mg/dL , "+hores[23]+" mg/dL");
    }
    
     /*
      * duplicar objecte
      */
     public MesuraDia copia(MesuraDia dia){
        MesuraDia aux;
        aux=new MesuraDia();
        int i=0;
        while (i<hores.length){
            aux.hores[i]=dia.hores[i];
            i++;
        }
        return aux;
    }
    /*
     * comprovar si els dos objectes son iguals
     */
    public boolean esIgual(MesuraDia dia){
        boolean hoEs=true;
        int i=0;
        while(i<hores.length){
            if(this.hores[i]!=dia.getMesura(i)){
                hoEs=false;
            }
            i++;
        }
        return hoEs;
    }
    
    /*
     * metode específic per trobar el valor mes gran dintre del objecte
     */
    public double glucosaMesAltaDia(){
        int i=0;
        double max=0.00;
        while(i<hores.length){
            if(max<this.hores[i]){
        max=this.hores[i];}
        i++;
        }
        return max;
    } 
    /*
     * metode específic per trobar el valor mes petit dintre del objecte
     */
    public double glucosaMesBaixaDia(){
        int i=0;
        double min=200.00;
        while(i<hores.length){
            if(min>this.hores[i]){
        min=this.hores[i];}
        i++;
        }
        return min;
    } 
    /*
     * metode específic per calcular la diferencia entre el valor més gran i el mes petit del objecte
     */
    public double variacioMaxMin(MesuraDia dia){
        double max, min;
        max=dia.glucosaMesAltaDia();
        min=dia.glucosaMesBaixaDia();
        double dif= max-min; //diferencia del maxim valor i el minim
        return dif;
    }
    
    /*
     * metode específic per calcular la diferencia del càlcul de la variació entre dos objectes
     */
    public double difVariacio(MesuraDia dia){
        double diaactu, diacomp, dif;
        MesuraDia aux;
        aux = new MesuraDia();
        int i=0;
        while (i<hores.length){
            aux.hores[i]=this.hores[i]; //donant el valor del constructor a una nostra variable interna per tal de utilitzar metodes interns per facilitats
            i++;
        }
        diaactu=variacioMaxMin(aux);//metode intern abans mencionat
        diacomp=variacioMaxMin(dia);
        if (diaactu<diacomp){ //condició perque el resultat sempre doni positiu
            dif = diacomp - diaactu;
        } else {
            dif = diaactu - diacomp;
        }
        return dif;
    }

    /*
     * metode específic de la estimació de un valor en una instancia de temps concreta de manera linear
     */
    public double estimacioglucosa(int hora,int minut){
        double dada1,dada2,result;
        if(hora>22 ||minut >59||hora<0|| minut<0){
            return -1.00;
        }
        else{
        dada1= hores[hora];
        dada2=hores[hora+1];
        double t=minut/60.00;
        result=dada1+t*(dada2-dada1); //formula de linealitat per tal de que el valor en la instancia sigui proporcional
        
        return result;
        }
    }
    
}

