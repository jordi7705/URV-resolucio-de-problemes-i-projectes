

public class UsaMesuraDia {
    public static void main(String[] args) throws Exception {
        //1.Crida constructor
        MesuraDia dia1 = new MesuraDia();
        
        //2.Crida getter
        int i=2;
        double aux=dia1.getMesura(i);
        System.out.println("la hora 3 del dia 1 te un valor de "+aux+" mg/dL");
        i=5;
        aux=dia1.getMesura(i);
        System.out.println("la hora 5 del dia 1 te un valor de "+aux+" mg/dL");

        //3.Crida setter
        dia1.setMesura(5, 81.6);
        aux=dia1.getMesura(i);
        System.out.println("la hora 5 del dia 1 modificat te un valor de "+aux+" mg/dL");
        System.out.println(dia1.toString());

        //4.Crear una copia del objecte
        MesuraDia dia2=new MesuraDia();
        dia2.copia(dia1);
        System.out.println("Dia 2 => "+dia2.toString());

        //5. Comprovar si els dos dies son iguals
        System.out.println("el dia 1 i el dia 2 son iguals? "+dia1.esIgual(dia2));
        dia2.setMesura(7, 78.3); //canviem alguns parametres per mes visualització dels metodes aplicats
        System.out.println("el dia 1 i el dia 2 son iguals? "+dia1.esIgual(dia2));
        
        //6. Comprovar nivell mes alt de glucosa en un dia
         dia1.setMesura(22, 115);
        double max;
        max=dia1.glucosaMesAltaDia();
        System.out.println("Nivell més alt de glucosa del dia 1 => "+max+" mg/dL");
        
        //7. Càlcul del nivell de variacio de la glucosa de un dia
        double var;
        var=dia1.variacioMaxMin(dia1);
        String s = String.format("%.2f", var);
        System.out.println("Nivell de variació de la glucosa dia 1 => "+s+" mg/dL");
        
        
        //8. Càlcul de la diferencia de variació de una dia i una altre instancia
        double dif;
       
        dif = dia2.difVariacio(dia1);
        String s2 = String.format("%.2f", dif);
        System.out.println("La diferencia entre les dues variacions és de: "+s2+" mg/dL");
        
        //9. Estimació de un valor de glucosa en un instant de temps determinat
        double estim;
        estim=dia1.estimacioglucosa(22, 30);
        if(estim==-1){ //condició provisional de dades introduides erroneament
        System.out.println("data introduida erronia");
        }
        else
        System.out.println("l'estimació de glucosa a l'hora introduida és: "+estim+" mg/dL");
    }
}