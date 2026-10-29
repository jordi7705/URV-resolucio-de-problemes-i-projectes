/*
 * Pràctica 1 curs 25-26: primera part
 * Classe MesuraDia
 */
public class MesuraDiaAmpliada {
    private int[] valors;

    private static int valorIni = 70, valorFi = 140, valorsuperior = 0, valorinf = 0; // valors static per determinar el
                                                                                      // rang que es dessitja en aquest
    // cas de 70 a 140

    /**
     * Constructor que rep tots els valors de les 24 mesures
     * 
     * @param valors taula amb el contingut de les 24 mesures
     */
    public  MesuraDiaAmpliada(int[] valors) {
        int valorsuperior = 0;
        int valorinf = 0;
        this.valorsuperior = 0;
        this.valorinf = 0;
        this.valors = new int[24];
        if (valors.length == 24) {
            for (int i = 0; i < valors.length; i++) {
                if (valors[i] >= valorIni && valors[i] <= valorFi) { // condicio per comprovar que els valors estan
                                                                     // dintre del rang establert
                    this.valors[i] = valors[i];
                } else if (valors[i] <= valorIni) {
                    this.valors[i] = valorIni;
                    valorinf++; // mirem els valors que son inferiors al rang

                } else {
                    this.valors[i] = valorIni;
                    valorsuperior++; // mirem els valors que son superiors al rang
                }
            }
            this.valorsuperior = valorsuperior;
            this.valorinf = valorinf;
        }
        // si no es reben els 24 valors, la taula estarà tota a 0's
    }

    /**
     * Getter: consulta la mesura de glucosa en una certa hora
     * 
     * @param hora - valor de l'hora on es vol consultar la mesura
     * @return si l'hora està en el rang [0-24) valor de glucosa en l'hora indicada,
     *         si l'hora indicada és incorrecte retorna -1
     */
    public int getMesuraHora(int hora) {
        if (hora >= 0 && hora < 24)
            return valors[hora];
        else
            return -1;
    }

    /**
     * Setters: modifica el valor de la mesura en una certa hora
     * 
     * @param hora  - valor de l'hora on es vol modificar la mesura
     * @param valor - nou valor a guardar
     */
    public void setMesuraHora(int hora, int valor) {
        if (hora >= 0 && hora < 24) {

            if (valors[hora] >= valorIni && valors[hora] <= valorFi) { // condicio per comprovar que els valors estan
                                                                       // dintre del rang establert
                this.valors[hora] = valor;
            } else {
                this.valors[hora] = valorIni;
            }

        }
    }

    /**
     * Setters: modifica tot el conjunt de mesures
     * 
     * @param valors
     */
    public void setMesures(int[] valors) {
        if (valors.length == 24) {
            for (int i = 0; i < valors.length; i++) {
                this.valors[i] = valors[i];
            }
        }
        // si no es reben els 24 valors, considerem que alguna cosa és incorrecte i no
        // modifiquem res
    }

    /**
     * toString: mètode per mostrar el contingut de l'objecte
     * 
     * @return Cadena de text amb el contingut de la instancia
     */
    public String toString() {
        String aux = "MesuraDia => array de " + valors.length + " posicions\n\t[";
        for (int i = 0; i < valors.length - 1; i++) {
            aux = aux + valors[i] + ", ";
        }
        aux = aux + valors[valors.length - 1] + "]";
        return aux;
    }

    /**
     * crear un duplicat de la instància
     * 
     * @return duplicat de l'objecte sobre el què s'aplica
     */
    public MesuraDiaAmpliada copia() {
        // opció 1: return new MesuraDia(valors);
        // opció 2:
        MesuraDiaAmpliada duplicat = new MesuraDiaAmpliada(valors);
        return duplicat;
    }

    /**
     * Comprovar si les dades d’una instància coincideixen amb les d’una altra
     * (valors iguals i en les mateixes hores)
     * 
     * @param altreMesura nova instància amb la que es compara l'actual
     * @return cert si tot el contingut és el mateix i en el mateix ordre
     */
    public boolean iguals(MesuraDiaAmpliada altreMesura) {
        boolean totIgual = true;
        // és un algorisme de cerca (no es considera vàlid fer un recorregut)
        int i = 0;
        while (totIgual && i < valors.length) {
            if (this.valors[i] != altreMesura.valors[i])
                totIgual = false;
            else
                i++;
        }
        return totIgual;
    }

    /**
     * Calcula el valor de nivell de glucosa més alt del dia
     * 
     * @return valor més alt
     */
    public int valorMesAlt() {
        int vMax = 0;
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] > vMax)
                vMax = valors[i];
        }
        return vMax;
    }

    /**
     * Calcula el valor de variació dels nivells de glucosa en el dia
     * 
     * @return la diferència entre el valor màxim del dia i el valor mínim
     */
    public int variacioDia() {
        int vMax = valorMesAlt();
        int vMin = valorMesBaix();
        return vMax - vMin;
    }

    // en els mètodes private no hem de fer comentaris de Javadoc,
    // sí comentaris interns per al manteniment del codi per part
    // del programador
    private int valorMesBaix() {
        int vMin = Integer.MAX_VALUE;
        // Integer.MAX_VALUE valor més gran que es pot guardar en una variable int
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] < vMin)
                vMin = valors[i];
        }
        return vMin;
    }

    /**
     * Calcula la diferencia entre els valors de variació entre la MesuraDia actual
     * i una altra instància rebuda per paràmetre.
     * 
     * @param altreMesura nova instància amb la que es calcula la variació respecte
     *                    a l'actual
     * @return variacio mesura actual - variacio mesura paràmetre
     */
    public int diferenciaValorsVariacio(MesuraDiaAmpliada altreMesura) {
        return this.variacioDia() - altreMesura.variacioDia();
    }

    /**
     * Calcula l'estimació del valor de glucosa en un instant de temps del dia
     * 
     * @param hora   en el rang [0-22] (no tenim una mesura més enllà de les 23
     *               hores)
     * @param minuts en [0-59]
     * @return el valor estimat si hora i minuts correctes. -1 en cas contrari.
     */
    public int valorGlucosaEstimat(int hora, int minuts) {
        // tot i que retornarem un int, els càlculs s'han de fer en aritmètica real per
        // no perdre precisió
        double increment;

        if (hora >= 0 && hora < 23 && minuts >= 0 && minuts < 60) {
            // podem calcular l'increment/decrement de glucosa per cada minut
            // hem de treballar amb aritmetica real per obtenir resultats correctes
            increment = ((double) valors[hora + 1] - valors[hora]) / 60.0;
            // multiplicar pel número de minuts
            increment = increment * minuts;
            // sumar aquest increment/decrement al valor de l'hora
            return valors[hora] + (int) increment;
        } else
            return -1;
    }

    /**
     * metode que consulta els limits del rang de glucosa es a dir els valors static
     * 
     * @return
     */
    public static String limitRang() {
        String lim = "El valor mínim de glucosa acceptat és de: " + valorIni
                + "\nI el valor màxim de glcosa acceptat és de: " + valorFi;

        return lim;
    }

    /**
     * metode que modifica els limits dels rang es a dir modifica els valors static
     * 
     * @param min
     * @param max
     * @return
     */
    public static String modificaLimitsRang(int min, int max) {
        MesuraDiaAmpliada.valorIni = min;
        MesuraDiaAmpliada.valorFi = max;
        String aux = "Els nous valors son:\n" + limitRang();
        return aux;
    }

    /**
     * metode que consulta els valors inferiors al rang de un dia
     * 
     * @return
     */
    public static int consultavalorsinf() {
        return valorinf;
    }

    /**
     * metode que consulta els valors superiors al rang de un dia
     * 
     * @return
     */
    public static int consultavalorsup() {
        return valorsuperior;
    }

    /**
     * metode que verifica si un dia conte valors estables o no
     * 
     * @return
     */
    public static String glucosaEstable() {
        int val1 = 0, val2 = 0;
        val1 = MesuraDiaAmpliada.consultavalorsup(); // mirem si hi ha dies inferiors o superiors al rang
        val2 = MesuraDiaAmpliada.consultavalorsinf();
        if (val1 == 0 && val2 == 0) {
            String aux = "El nivell de glucosa és estable durant el dia";
            return aux;
        } else {
            String aux = "El nivell de glucosa NO és estable durant el dia";
            return aux;
        }

    }
}
