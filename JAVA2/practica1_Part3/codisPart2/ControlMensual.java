public class ControlMensual {

    private String nom, mes;
    private MesuraDiaAmpliada[] contingut;

    /**
     * contructor per parametres
     * 
     * @param controlMens
     */
    public ControlMensual(String nom, int mes) {
        this.nom = nom;

        if (mescorrecte(mes)) {
            this.mes = getMesString(mes); // guardar el nom del més i no el numero per donar menys marge d'error al
                                          // escriure el mes
        }
        this.contingut = new MesuraDiaAmpliada[DiesMes()];
        for (int i = 0; i < DiesMes(); i++) {
            int[] v1 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                    -1, -1 }; // afegim un numero imposible per detectar que no tenim mesures

            MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
            this.contingut[i] = d1;
        }

    }

    /**
     * getter del nom
     * 
     * @return
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * getter del mes
     * 
     * @return
     */
    public String getMes() {
        return this.mes;
    }

    /**
     * getter del contingut de cada dia del mes
     * 
     * @return
     */
    public MesuraDiaAmpliada[] getContingut() {
        return this.contingut;
    }

    /**
     * getter del contingut de un dia concret
     * 
     * @return
     */
    public MesuraDiaAmpliada getContingutConcret(int i) {
        return this.contingut[i - 1];
    }

    /**
     * setter del nom
     * 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * setter del mes
     * 
     * @param mes
     */
    public void setMes(int mes) {
        this.mes = getMesString(mes);
    }

    /**
     * setter del dia
     * 
     * @param m1
     * @param dia
     */
    public void setDia(MesuraDiaAmpliada m1, int dia) {
        if (dia == 0) {
            this.contingut = contingut;
        } else {
            this.contingut[dia - 1] = m1;
        }

    }

    /**
     * retornar cuants dies te el més seleccionat
     * 
     * @param mes2
     * @return
     */
    public int DiesMes() {

        if (mes == "Gener" || mes == "Març" || mes == "Maig" || mes == "Juliol" || mes == "Agost" || mes == "Octubre"
                || mes == "Decembre") {
            return 31;
        }
        if (mes == "Febrer") {
            return 28; // a la pràctica és menciona que l'any es el de 2025 per tant no és any de
                       // traspàs
        } else {
            return 30;
        }
    }

    /**
     * Comprovar que el mes introduit sigui correcte
     * 
     * @param mes2
     * @return
     */
    private boolean mescorrecte(int mes2) {
        boolean HoEs = false;
        if (mes2 >= 1 && mes2 <= 12) {
            HoEs = true;
        }
        return HoEs;
    }

    /**
     * metode per representar la nostre instancia
     */
    public String toString() {
        String aux = "L'usuari: " + nom + ", dades el mes de " + mes + ":\n";

        for (int i = 0; i < contingut.length; i++) {
            if (contingut[i].getMesuraHora(1) == -1) {
                aux = aux + "Dia " + (i + 1) + ": sense Mesures\n";
            } else {
                aux = aux + "Dia " + (i + 1) + ": Mesures -> " + contingut[i] + "\n";
            }
        }

        return aux;
    }

    /**
     * metode que afegeix les dades de un dia concret
     * 
     * @param m1
     * @param dia
     */
    public void afegirDadesDia(MesuraDiaAmpliada m1, int dia) {

        setDia(m1, dia);

    }

    /**
     * metode que mira el dia amb la maxima variacio del mes
     * 
     * @return
     */
    public int maxVariacio() {
        int dia = 0;
        int max = 0;
        for (int i = 0; i < contingut.length; i++) {
            if (contingut[i].variacioDia() > max) {
                max = contingut[i].variacioDia();
                dia = i + 1;
            }
        }
        return dia;
    }

    /**
     * metode que mira el maxim de dies consecutius estables
     * 
     * @return
     */
    public int maxDiesConsecutius() {
        int Max = 0;
        int i = 0;
        int contador = 0;
        boolean HoEs = false;

        while (i < DiesMes()) {

            HoEs = contingut[i].haEstatEstabilitzada();
            if (HoEs) {
                contador++;
                if (contador > Max) {
                    Max = contador;
                }
            } else {
                contador = 0;

            }
            i++;
        }
        return Max;
    }
/**
 * metode que retorna quina instancia es mes estable si la rebuda o l'actual
 * @param aux
 * @return
 */
    public String mesEstable(MesuraDiaAmpliada[] aux) {
        int actual = maxDiesConsecutius();
        MesuraDiaAmpliada[] original = contingut;
        this.contingut = aux;
        int rebuda = maxDiesConsecutius();
        this.contingut = original;

        if (actual > rebuda) {
            return "L'instancia actual és mes estable que la rebuda";
        }
        if (actual == rebuda) {
            return "Les dos instancies son igual d'estables";
        } else {
            return "L'instancia rebuda és mes estable que la actual";
        }

    }

    /**
     * Obtenir el nom del més introduit per numero per facilitats a la hora de programar
     * 
     * @param mes2
     * @return
     */
    private String getMesString(int mes2) {
        if (mes2 == 1) {
            return "Gener";
        }
        if (mes2 == 2) {
            return "Febrer";
        }
        if (mes2 == 3) {
            return "Març";
        }
        if (mes2 == 4) {
            return "Abril";
        }
        if (mes2 == 5) {
            return "Maig";
        }
        if (mes2 == 6) {
            return "Juny";
        }
        if (mes2 == 7) {
            return "Juliol";
        }
        if (mes2 == 8) {
            return "Agost";
        }
        if (mes2 == 9) {
            return "Septembre";
        }
        if (mes2 == 10) {
            return "Octubre";
        }
        if (mes2 == 11) {
            return "Novembre";
        } else {
            return "Decembre";
        }
    }
}
