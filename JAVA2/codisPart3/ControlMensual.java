/*
 * Pràctica 1 curs 25-26: tercera part
 * Classe ControlMensual
 */
public class ControlMensual {
    private String nomPersona;
    private String mes;
    private MesuraDiaAmpliada[] mesuresMes;
    private int numMesures;

    /**
     * Constructor, guarda el nom i el mes i inicialitza la taula de mesures al
     * nombre de dies del mes
     * 
     * @param nomPersona
     * @param mes        en valor cadena de text
     */
    public ControlMensual(String nomPersona, String mes) {
        this.nomPersona = nomPersona;
        this.mes = mes.toUpperCase(); // decidim guardar internament en majúscules
        int numDies = diesMes(this.mes);
        if (numDies != -1)
            mesuresMes = new MesuraDiaAmpliada[numDies];
        else
            mesuresMes = new MesuraDiaAmpliada[0];
        // si el mes és erroni no permetrem guardar cap dada en aquell objecte
        numMesures = 0;
    }

    // al ser mètodes interns i privats no hem de fer documentació en format JAVADOC
    private int diesMes(String nomMes) {
        String[] mesos = { "GENER", "FEBRER", "MARÇ", "ABRIL", "MAIG", "JUNY", "JULIOL", "AGOST", "SETEMBRE", "OCTUBRE",
                "NOVEMBRE", "DESEMBRE" };
        int[] dies = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int pos = posicioMesTaula(mesos, nomMes);
        if (pos != -1)
            return dies[pos];
        else
            return -1;
    }

    private int posicioMesTaula(String[] mesos, String nomMes) {
        // cerca
        int pos = 0;
        boolean trobat = false;

        while (!trobat && pos < mesos.length) {
            if (nomMes.equals(mesos[pos]))
                trobat = true;
            else
                pos++;
        }
        if (trobat)
            return pos;
        else
            return -1;
    }

    /**
     * mètode que afegeix les dades de mesura d'un dia a la següent posició lliure
     * de la taula
     * 
     * @param dades
     */
    public void afegirDadesMesura(MesuraDiaAmpliada dades) {
        if (numMesures < mesuresMes.length) {
            mesuresMes[numMesures] = dades.copia();
            numMesures++;
        }
    }

    /**
     * mètode per modificar les dades d'un dia específic.
     * 
     * @param dades noves dades de mesures
     * @param dia   a modificar en el format [0-numDiesMes-1]
     */
    public void setDadesMesuraDia(MesuraDiaAmpliada dades, int dia) {
        if (dia >= 0 && dia < numMesures) {
            mesuresMes[dia] = dades.copia();
        }
    }

    /**
     * mètode que consulta i retorna les dades d'un dia específic
     * 
     * @param dia a consultar en el format [0-numDiesMes-1]
     * @return les dades del dia indicat si aquest existeix
     */
    public MesuraDiaAmpliada getDadesMesuraDia(int dia) {
        if (dia >= 0 && dia < numMesures) {
            return (mesuresMes[dia]); // opcionalment .copia()
        } else
            return null;
    }

    /**
     * mètode toString
     * 
     * @return cadena amb el contingut de la instància
     */
    public String toString() {
        String aux = "ControlMensual => ";
        aux = aux + " Nom persona: " + nomPersona + " dades del mes: " + mes + " de " + diesMes(mes)
                + " dies i valors mesures de cada dia:\n";

        if (numMesures > 0) {
            for (int i = 0; i < numMesures - 1; i++) {
                aux = aux + mesuresMes[i] + ",\n";
            }
            aux = aux + mesuresMes[numMesures - 1] + "]";
        }
        return aux;
    }

    /**
     * mètode que calcula el dia on hi ha hagut un valor més gran de variació entre
     * el nivell màxim del dia i el mínim
     * 
     * @return el valor del dia en el rang [0-nDiesMes-1]
     */
    public int diaDiferenciaMesGranVariacio() {
        int diffMax = 0, diff, diaDiffMax = 0;
        for (int i = 0; i < numMesures; i++) {
            diff = mesuresMes[i].variacioDia();
            if (diff > diffMax) {
                diffMax = diff;
                diaDiffMax = i; // les posicions de la taula van de [0-nDiesMes-1]. Si es vol en el rang 
                                // [1, nDiesMes] només caldria sumar 1
            }
        }
        return diaDiffMax;
    }

    /**
     * mètode que calcula el màxim número de dies on hi ha hagut la glucosa
     * estabilitzada
     * 
     * @return el número de dies
     */
    public int maxDiesConsecutiusEstabilitzats() {
        // taula auxiliar on guardarem si el dia ha estat amb mesures estabilitzades o
        // no
        boolean[] diesEstab = new boolean[numMesures];
        for (int i = 0; i < numMesures; i++) {
            diesEstab[i] = mesuresMes[i].haEstatEstabilitzada();
        }

        // ara calculem quantes posicions consecutives estan a true i ens quedem amb el
        // valor més alt
        int posIni = 0, pos = 0;
        int llarg = 0, llargMax = 0;

        while (pos < numMesures) {
            while (pos < numMesures && diesEstab[pos])
                pos++;
            llarg = pos - posIni;
            if (llarg > llargMax) {
                llargMax = llarg;
            }
            posIni = pos + 1;
            pos = posIni;
        }

        return llargMax;
    }

    /**
     * mètode que comprova si la instància actual ha tingut més dies consecutius la
     * glucosa estable versus la de la instància rebuda per paràmetre
     * 
     * @param c2 dades de control mensual a comparar amb la instància actual
     * @return si l'actual ha estat més estable
     */
    public boolean esMesEstableA(ControlMensual c2) {
        return this.maxDiesConsecutiusEstabilitzats() > c2.maxDiesConsecutiusEstabilitzats();
    }

}
