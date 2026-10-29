package dades;

public class LlistaMedalles {

    private Medalla[] llista;
    private int numElem;

    public LlistaMedalles(int numLinies) {
        llista = new Medalla[numLinies];
        numElem = 0;
    }

    // punt 1
    public void afegirMedalla(Medalla n) {
        if (numElem < llista.length) {
            llista[numElem] = n.copia();
            numElem++;
        }
    }

    // general
    public int getNumElem() {
        return numElem;
    }

    // general
    public String toString() {
        String aux = "LlistaMedalles => numElem: " + numElem;
        for (int i = 0; i < numElem; i++) {
            aux = aux + "\n\t" + llista[i];
        }
        return aux;
    }

    // general
    public LlistaMedalles copia() {
        LlistaMedalles duplicat = new LlistaMedalles(llista.length);
        for (int i = 0; i < numElem; i++) {
            duplicat.afegirMedalla(llista[i]);
        }
        return duplicat;
    }

    // punt 2
    public int numMedallesPaisJocs(String nomCiutat, int anyJocs, String tipusMedalla, String pais) {
        int num = 0;

        for (int i = 0; i < numElem; i++) {
            if (llista[i].celebratEn(nomCiutat) && llista[i].celebratAny(anyJocs)
                    && llista[i].esTipusMedalla(tipusMedalla) && llista[i].esDaquestPais(pais)) {
                num++;
            }
        }

        return num;
    }

    // punt 3
    public Medalla primeraMedalla(String tipusMedalla, String sexe, int anyJocs) {
        Medalla aux = null;
        boolean trobada = false;
        int pos = 0;

        while (pos < numElem && !trobada) {
            if (llista[pos].esTipusMedalla(tipusMedalla) && llista[pos].esDaquestSexe(sexe)
                    && llista[pos].celebratAny(anyJocs)) {
                trobada = true;
                aux = llista[pos];
            }
            pos++;
        }
        return aux;
    }

    // punt 4
    public Medalla primeraMedallaFemenina(String nomCiutat, int anyJocs) {
        Medalla aux = null;
        boolean trobada = false;
        int pos = 0;

        while (pos < numElem && !trobada) {
            if (llista[pos].esDaquestSexe("Women") && llista[pos].celebratEn(nomCiutat) && llista[pos].celebratAny(anyJocs)) {
                trobada = true;
                aux = llista[pos];
            }
            pos++;
        }
        if (trobada) {
            return aux.copia();
        } else {
            return aux; // no podem fer un duplicat del null

        }
    }

    // punt 5
    public String paisMesMedallesTipus(String tipusMedalla) {
        // en primer lloc hem d'anar calculant les medalles que ha obtingut cada país
        // del tipus indicat
        int numPaisos = 0;
        // nro màxim de diferents paisos que ens podem trobar és 136
        // podríem haver fet un primer mètode auxiliar per calcular això
        String[] paisos = new String[140];
        int[] numMedalles = new int[140];
        String pais;
        int posPais;

        for (int i = 0; i < numElem; i++) {
            if (llista[i].esTipusMedalla(tipusMedalla)) {
                pais = llista[i].getPais();
                posPais = posicioPais(paisos, numPaisos, pais);
                if (posPais == -1) {
                    // primera medalla del pais que trobem
                    if (numPaisos < paisos.length) {
                        paisos[numPaisos] = pais;
                        numMedalles[numPaisos] = 1;
                        numPaisos++;
                    }
                } else {
                    numMedalles[posPais]++;
                }
            }
        }

        // un cop tenim les medalles calculades busquem el país que en té més (si empat
        // qualsevol)
        if (numPaisos == 0) {
            // no hem trobat cap dada del tipus de medalla
            return null;
        } else {
            int posMax = 0;
            int numMax = numMedalles[posMax];
            for (int i = 0; i < numPaisos; i++) {
                if (numMedalles[i] > numMax) {
                    numMax = numMedalles[i];
                    posMax = i;
                }
            }
            return paisos[posMax];
        }
    }

    private int posicioPais(String[] paisos, int numPaisos, String pais) {
        int pos = 0;
        boolean trobat = false;
        while (pos < numPaisos && !trobat) {
            if (paisos[pos].equalsIgnoreCase(pais)) {
                trobat = true;
            } else {
                pos++;
            }
        }

        if (!trobat) {
            return -1;
        } else {
            return pos;
        }
    }

    // punt 6
    public int[] medaller(String pais) {
        int[] dades = new int[3];
        for (int i = 0; i < numElem; i++) {
            if (llista[i].esDaquestPais(pais)) {
                if (llista[i].esTipusMedalla("GOLD")) {
                    dades[0]++;
                } else if (llista[i].esTipusMedalla("SILVER")) {
                    dades[1]++;
                } else if (llista[i].esTipusMedalla("BRONZE")) {
                    dades[2]++;
                }
            }
        }

        return dades;
    }

    // punt 7
    public LlistaMedalles medallesJocsIprova(String nomProva, String ciutat, int anyJocs) {
        LlistaMedalles aux = new LlistaMedalles(numElem); // no caldrien tantes posicions però...

        for (int i = 0; i < numElem; i++) {
            if (llista[i].esAquestaProva(nomProva) && llista[i].celebratEn(ciutat) && llista[i].celebratAny(anyJocs)) {
                aux.afegirMedalla(llista[i]);
            }
        }
        return aux;
    }

    // punt 8
    public void eliminarMedallesJocs(String ciutat, int anyJocs, String nomProva) {

        // anem a buscar primera posició on hi ha les dades dels jocs i prova que volem eliminar
        int posIni = 0;
        boolean trobat = false;
        while (posIni < numElem && !trobat) {
            if (llista[posIni].celebratEn(ciutat) && llista[posIni].celebratAny(anyJocs) && llista[posIni].esAquestaProva(nomProva)) {
                trobat = true;
            } else {
                posIni++;
            }
        }

        // anem a buscar primera posició on ja NO hi ha les dades dels jocs i prova a eliminar
        int posFi = posIni + 1;
        trobat = false;
        while (posFi < numElem && !trobat) {
            if (llista[posFi].celebratEn(ciutat) && llista[posFi].celebratAny(anyJocs) && llista[posFi].esAquestaProva(nomProva)) {
                posFi++;
            } else {
                trobat = true;
            }
        }
        // hem d'eliminar des de posIni a posFi-1

        if (posFi > posIni) {
            int pos1 = posIni;
            int pos2 = posFi;
            while (pos2 < numElem) {
                llista[pos1] = llista[pos2];
                pos1++;
                pos2++;
            }
            numElem = numElem - (posFi - posIni);
        }
    }

    public LlistaMedalles medallespais(String pais) {
        LlistaMedalles medallespais = new LlistaMedalles(numElem);
        for (int i = 0; i < numElem; i++) {
            if (llista[i].esDaquestPais(pais)) {
                medallespais.afegirMedalla(llista[i]);
            }
        }
        return medallespais;
    }

    public int quantesMedallesAnys(String pais, int anyini, int anyfin) {
        int contador = 0;
        for (int i = 0; i < numElem; i++) {
            if (llista[i].celebratAny(anyini)) {
                while (!llista[i].celebratAny(anyfin)) {
                    if (llista[i].esDaquestPais(pais)) {
                        contador++;
                    }
                    i++;
                }
            }
        }
        return contador;
    }

    public String[] paisosUnaMeda(String nomProva, String tipusMedalla) {
        String[] aux;
        Medalla aux2;
        aux = new String[140];
        for (int i = 0; i < numElem; i++) {
            aux2=llista[i];
            if (llista[i].esAquestaProva(nomProva) && llista[i].esTipusMedalla(tipusMedalla)) {
                    if (!llista[i].getPais().equals(aux2.getPais())) {
                        aux[i] = llista[i].getPais();
                    }
            }
        }
        return aux;
    }
}
