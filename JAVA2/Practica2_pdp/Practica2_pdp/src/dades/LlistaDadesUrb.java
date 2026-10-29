package dades;

public class LlistaDadesUrb {
    private DadesUrb[] llista;
    private int numElem;

    public LlistaDadesUrb(int numLinies) {
        llista = new DadesUrb[numLinies];
        numElem = 0;
    }

    // general
    public int getNumElem() {
        return numElem;
    }

    // general
    public String toString() {
        String aux = "LlistaDadesUrb -> numero d'elements " + numElem;
        for (int i = 0; i < numElem; i++) {
            aux = aux + "\n\t" + llista[i];
        }
        return aux;
    }

    // punt 1
    /**
     * metode per afegir elements a la llista de objectes
     * 
     * @param aux
     */
    public void afegirDadesUrb(DadesUrb aux) {
        if (numElem < llista.length) {
            llista[numElem] = aux.copia();
            numElem++;
        }
    }

    // general

    public LlistaDadesUrb copia() {
        LlistaDadesUrb duplicat = new LlistaDadesUrb(llista.length);
        for (int i = 0; i < numElem; i++) {
            duplicat.afegirDadesUrb(llista[i]);
        }
        return duplicat;
    }

    // punt 2

    /**
     * metode que retorna el municipi amb mes superficie
     * 
     * @return
     */

    public DadesUrb dadesMesSuperfice() {

        int pos = 0;
        double max = 0.00;
        for (int i = 0; i < numElem; i++) {

            if (max < llista[i].getSuperficieTotal()) {
                max = llista[i].getSuperficieTotal();
                pos = i;
            }

        }
        return llista[pos];

    }

    // punt 3

    /**
     * metode que retorna una copia del municipi amb mes percentatge de zona verda
     * 
     * @return
     */
    public DadesUrb percentVerd() {
        DadesUrb aux = null;
        double max = 0.00;

        for (int i = 0; i < numElem; i++) {
            double total = llista[i].getSuperficieTotal();
            double zonaVerda = llista[i].getSuperficieVerda();
            double percentatge = (zonaVerda / total) * 100;

            if (max < percentatge) {
                max = percentatge;
                aux = llista[i].copia();
            }

        }
        return aux;
    }

    // punt 4
    /**
     * metode que rep per parametre el nomde un municipi i retorna la diferencia de
     * sol urbanitzable inicial amb l'actual, es a dir si el municipi a modificat la
     * superficie urbanitzable durant els anys
     * 
     * @param nomMunicipi
     * @return
     */
    public double variacioDeSolUrbanitzable(String nomMunicipi) {
        boolean trobat = false;
        double superfIni = 0, superfFinal = 0, variacioSol = 0;
        int i = 0;
        while (!trobat && i < numElem) {
            if (llista[i].getNomMunicipi().equalsIgnoreCase(nomMunicipi)) {
                superfIni = llista[i].getSuperficieUrbanitzable();
                trobat = true;

            }
            i++;

        }
        trobat = false;
        i = numElem - 1;
        while (!trobat && i > 0) {
            if (llista[i].getNomMunicipi().equalsIgnoreCase(nomMunicipi)) {
                trobat = true;
                superfFinal = llista[i].getSuperficieUrbanitzable();

            }
            i--;
        }
        variacioSol = superfFinal - superfIni;
        return variacioSol;

    }

    // Punt 5
    /**
     * Metode que retorna una instancia que presenta costa i no te superficie
     * urbanitzable
     * 
     * @return
     */
    public DadesUrb urbCostaSenseUrbanitzable() {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < numElem) {
            if (llista[i].esMunicipiDeCosta() && llista[i].getSuperficieUrbanitzable() == 0) {
                trobat = true;

            } else
                i++;

        }
        return llista[i];
    }

    // Punt 6
    /**
     * metode que retorna una taula de strings de les poblacions amb mes densitat de
     * poblacio que la densitat introduida per parametre
     * 
     * @param dens
     * @return
     */
    public String[] municipiesMesDensitat(double dens) {
        String[] taula = new String[numElem];
        int pos = 0;

        for (int i = 0; i < numElem; i++) {
            double densitat = llista[i].copia().getNumHabitants() / llista[i].copia().getSuperficieTotal();
            if (dens < densitat && !esRepetit(llista[i].getNomMunicipi(), taula)) {
                taula[pos] = llista[i].copia().getNomMunicipi();

                pos++;

            }
        }

        return taula;

    }

    // Punt 7
    /**
     * Metode que retorna una subllista de un municipi al llarg dels anys
     * 
     * @param municipi
     * @return
     */
    public LlistaDadesUrb dadesMunicipi(String municipi) {
        LlistaDadesUrb dadesMun = new LlistaDadesUrb(numElem);

        for (int i = 0; i < numElem; i++) {
            if (llista[i].getNomMunicipi().equalsIgnoreCase(municipi)) {
                dadesMun.afegirDadesUrb(llista[i]);
            }
        }
        return dadesMun;

    }

    // Punt 8
    /**
     * Metode que retorna un llista dels municipis amb una especificacio si son de
     * costa, muntanya o cap
     * 
     * @param tipus
     * @return
     */
    public LlistaDadesUrb LlistaDadesCostaOMuntanya(int tipus) {

        LlistaDadesUrb subllista = new LlistaDadesUrb(numElem);
        if (tipus == 1) { // llista municipis de costa

            for (int i = 0; i < numElem; i++) {
                if (llista[i].esMunicipiDeCosta()) {
                    subllista.afegirDadesUrb(llista[i]);
                }

            }
            return subllista;
        }
        if (tipus == 2) { // llista municipis de muntanya

            for (int i = 0; i < numElem; i++) {
                if (llista[i].esMunicipiDeMuntanya()) {
                    subllista.afegirDadesUrb(llista[i]);
                }

            }
            return subllista;
        }
        if (tipus == 3) { // llista municipis que no son de costa ni de muntanya

            for (int i = 0; i < numElem; i++) {
                if (!llista[i].esMunicipiDeCosta() && !llista[i].esMunicipiDeMuntanya()) {
                    subllista.afegirDadesUrb(llista[i]);
                }

            }
            return subllista;
        } else
            return null;
    }

    // Punt 9
    /**
     * Metode que elimina les dades d'un municipi introduit per parametre
     * 
     * @param municipi
     */
    public void eliminarMunicipi(String municipi) {

        for (int i = 0; i < numElem; i++) {
            if (llista[i].getNomMunicipi().equalsIgnoreCase(municipi)) {
                for (int j = i; j < numElem; j++) {
                    llista[j] = llista[j + 1];
                    numElem--;
                }
            }
        }

    }

    // Auxiliars
    public static String toStringLlistaString(String[] municipis) {
        String aux = "\nLlista de municipis";
        int i = 0;
        if (municipis[i] != null) {
            while (i < municipis.length && municipis[i] != null) {
                aux = aux + "\n\t" + municipis[i];
                i++;
            }
        }

        else {
            return "\nNo s'ha trobat cap element";
        }

        return aux;
    }

    public String escorrecteMunicipi(String m) {
        boolean HoEs = false;
        int i = 0;
        while (!HoEs && i < numElem) {
            if (llista[i].getNomMunicipi().equalsIgnoreCase(m)) {
                HoEs = true;
            } else
                i++;
        }

        if (HoEs) {
            return "S'ha trobat el municipi";
        }

        else {
            return "No s'ha trobat el municipi";
        }
    }

    public boolean esRepetit(String municipi, String[] taula) {
        boolean HoEs = false;
        int i = 0;
        while (!HoEs && i < taula.length && taula[i] != null) {
            if (taula[i].equalsIgnoreCase(municipi)) {
                HoEs = true;
            }
            i++;
        }
        return HoEs;

    }

}
