/*
 * Pràctica 1 curs 25-26: segona i tercera part
 * Classe MesuraDiaAmpliada
 */
public class MesuraDiaAmpliada {
    private static int vMin = 70;
    private static int vMax = 140;
    private int[] valors;

    /**
     * Constructor que rep tots els valors de les 24 mesures
     * 
     * @param valors taula amb el contingut de les 24 mesures
     */
    public MesuraDiaAmpliada(int[] valors) {
        this.valors = new int[24];
        if (valors.length == 24) {
            for (int i = 0; i < valors.length; i++) {
                this.valors[i] = valors[i];
            }
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
            valors[hora] = valor;
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
        String aux = "MesuraDia => vMin= " + vMin + " vMax= " + vMax;
        aux = aux + " array de " + valors.length + " posicions\n\t[";
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
        // opció 1: return new MesuraDiaAmpliada(valors);
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
        // tot i que retornarem un int, els càlculs s'han de fer en aritmètica entera
        // per
        // no perdre precisió
        double increment;

        if (hora >= 0 && hora < 23 && minuts >= 0 && minuts < 60) {
            // podem calcular l'increment/decrement de glucosa per cada minut
            increment = ((double) valors[hora + 1] - valors[hora]) / 60.0;
            // multiplicar pel número de minuts
            increment = increment * minuts;
            // sumar aquest increment/decrement al valor de l'hora
            return valors[hora] + (int) increment;
        } else
            return -1;
    }

    // Nous mètodes segona part de la pràctica

    /**
     * consultar el límit inferior del rang
     * @return vMin
     */
    public static int getVMinRang() {
        return vMin;
    }

    /**
     * consultar el límit superior del rang
     * @return vMax
     */
    public static int getVMaxRang() {
        return vMax;
    }

    /**
     * Modificar els valors del rang
     * @param vMin valor inferior del rang
     * @param vMax valor superior del rang
     */
    public static void setLimitsRang(int vMin, int vMax) {
        MesuraDiaAmpliada.vMin=vMin;
        MesuraDiaAmpliada.vMax=vMax;
    }

    /**
     * Calcular el número de mesures sota el valor mínim del rang
     * @return número de valors < vMin
     */
    public int numMesuresSotaRang() {
        int num = 0;
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] < vMin)
                num++;
        }
        return num;
    }

    /**
     * Calcular el número de mesures superiors al valor més gran del rang
     * @return número de valors > vMax
     */
    public int numMesuresSobreRang() {
        int num = 0;
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] > vMax)
                num++;
        }
        return num;
    }

    /**
     * Comprova si hi ha hagut un màxim d'una mesura fora els límits del rang
     * @return si es compleix la propietat
     */
    public boolean haEstatEstabilitzada() {
        return ((numMesuresSobreRang()+numMesuresSotaRang())<=1);
    }
}
