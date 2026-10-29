public class UsaControlMensual {
   public static void main(String[] args) throws Exception {
      System.out.println("Aplicació per validar la classe Control Mensual\n");

      // validar els mètodes afegits
      validarContructor();
      validarAfegirDades();
      validarGettersSetters();
      validarDiferenciaDeValorsMesGran();
      validarMaxDiesGlucosaEstable();
      validarQuiMesEstable();

   }

   private static void validarContructor() {
      System.out.println("1. Validar constructor i metode toString\n");
      ControlMensual c1 = new ControlMensual("Pep Guardiola", 4); // creem amb el constructor el nostre objecte
      System.out.println(c1.toString()); // validem també el metode toString

   }

   private static void validarAfegirDades() {
      System.out.println("2. Validar metode d'afegir dades en un dia concret\n");
      int[] v1 = { 90, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110, 105, 125,
            120, 105 };// Mesuria dia ampliat per un dia

      MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
      ControlMensual c1 = new ControlMensual("Pep Guardiola", 4); // creem amb el constructor el nostre objecte

      c1.afegirDadesDia(d1, 2);
      System.out.println(c1.toString() + "\n");

   }

   public static void validarGettersSetters() {
      System.out.println("3. Validar setters i getters\n");
      ControlMensual c1 = new ControlMensual("Pep Guardiola", 4); // creem amb el constructor el nostre objecte

      int[] v1 = { 90, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110, 105, 125,
            120, 105 };// Mesuria dia ampliat per un dia

      MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
      int dia = 1;
      c1.setDia(d1, dia);
      System.out.println("Les mesures del dia " + dia + " son:\n " + c1.getContingutConcret(dia) + "\n"); // validem
                                                                                                          // tant com
      // el setter com el
      // getter

   }

   public static void validarDiferenciaDeValorsMesGran() {
      System.out.println("4. Validar el dia del mes amb la diferencia variació més gran\n");
      ControlMensual c1 = new ControlMensual("Pep Guardiola", 4); // creem amb el constructor el nostre objecte

      for (int i = 0; i < c1.DiesMes() + 1; i++) {
         int[] v1 = { 90, 95, 92, 91, 90, 90, 90, 90, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110, 105,
               125,
               120, 105 };// Mesuria dia ampliat diferent per cada dia del mes per fer la variacio de cada
                          // un

         MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
         c1.setDia(d1, i);
      }
      int diaDelMes1 = c1.maxVariacio();
      System.out.println("Del seguent c1: \n" + c1.toString());
      System.out.println("El dia del mes amb la diferencia variació més gran és el dia " + diaDelMes1
            + " , del c1 anterior Degut a que tots els dies son iguals");
      // El pdf demana que si hi han dos iguals otortgui el primer trobat per aixo
      // aquest resultat
      int[] v1 = { 70, 95, 92, 91, 90, 90, 90, 90, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110, 105, 125,
            120, 140 };// Mesuria dia ampliat amb variació mes gran

      MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
      c1.setDia(d1, 17);

      int diaDelMes = c1.maxVariacio();
      System.out.println("Del seguent c1: \n" + c1.toString());
      System.out.println(
            "El dia del mes amb la diferencia variació més gran és el dia " + diaDelMes + " , del c1 anterior\n");
   }

   public static void validarMaxDiesGlucosaEstable() {
      System.out.println("5. Validar el numero de dies consecutius amb nivells estables de glucosa\n");
      ControlMensual c1 = new ControlMensual("Pep Guardiola", 2); // creem amb el constructor el nostre objecte
      for (int i = 0; i < c1.DiesMes() + 1; i++) {
         int[] v1 = { 90, 95, 92, 91, 90, 90, 90, 90, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110, 105,
               125,
               120, 105 };// Mesuria dia ampliat diferent per cada dia del mes per fer la variacio de cada
                          // un

         MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
         c1.setDia(d1, i);
      }
      int consecutius = c1.maxDiesConsecutius();
      System.out.println("Del seguent c1: \n" + c1.toString());
      System.out.println("El major numero de dies consecutius amb nivells estables de glucosa a sigut de: "
            + consecutius + " , del c1 anterior");

      int[] v1 = { 60, 95, 92, 91, 90, 90, 90, 90, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110, 105,
            125,
            120, 190 };// Mesuria dia ampliat diferent per cada dia del mes per fer la variacio de cada
                       // un

      MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
      c1.setDia(d1, 12);
      int consecutius1 = c1.maxDiesConsecutius();
      System.out.println("Del seguent c1: \n" + c1.toString());
      System.out.println("El major numero de dies consecutius amb nivells estables de glucosa a sigut de: "
            + consecutius1 + " , del c1 anterior\n");

   }

   public static void validarQuiMesEstable() {
      System.out.println("6. Validar quin mes es mes estable si el actual o el rebut per parametre\n");
      ControlMensual c1 = new ControlMensual("Pep Guardiola", 5); // creem amb el constructor el nostre objecte
      for (int i = 0; i < c1.DiesMes() + 1; i++) {
         int[] v1 = { 90, 95, 92, 91, 90, 90, 90, 90, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110, 105,
               125,
               120, 105 };// Mesuria dia ampliat diferent per cada dia del mes per fer la variacio de cada
                          // un

         MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
         c1.setDia(d1, i);
      }
      MesuraDiaAmpliada[] aux = new MesuraDiaAmpliada[c1.DiesMes() + 1];
      for (int i = 0; i < c1.DiesMes() + 1; i++) {
         int[] v2 = { 90, 95, 92, 91, 90, 90, 90, 90, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110, 105,
               125,
               120, 105 };// Mesuria dia ampliat diferent per cada dia del mes per fer la variacio de cada
                          // un

         MesuraDiaAmpliada d2 = new MesuraDiaAmpliada(v2);
         aux[i] = d2;
      }
      System.out.println("\nEntre l'instancia actual \n" + c1.toString() + "\ni l'intancia rebuda");
      String estable = c1.mesEstable(aux); // les dos instancies son igual han de donar la mateixa estabilitat
      System.out.println(estable);

      int[] v1 = { 60, 95, 92, 91, 90, 90, 90, 90, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110, 105,
            125,
            120, 190 };// Mesuria dia ampliat diferent per cada dia del mes per fer la variacio de cada
                       // un

      MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
      c1.setDia(d1, 12); // modifiquem la actual per veure si el metode funciona en aquesta situacio
      System.out.println("\nEntre l'instancia actual \n" + c1.toString() + "\ni l'intancia rebuda");
      String estable2 = c1.mesEstable(aux);
      System.out.println(estable2);

      for (int i = 0; i < c1.DiesMes() + 1; i++) {
         int[] v2 = { 60, 95, 92, 91, 90, 90, 90, 90, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110, 105,
               125,
               120, 190 };// Mesuria dia ampliat diferent per cada dia del mes per fer la variacio de cada
                          // un

         MesuraDiaAmpliada d2 = new MesuraDiaAmpliada(v2);
         aux[i] = d2; // modifiquem la rebuda per veure si el metode funciona en aquesta altre
                      // situacio
      }
      System.out.println("\nEntre l'instancia actual \n" + c1.toString() + "\ni l'intancia rebuda");
      String estable3 = c1.mesEstable(aux);
      System.out.println(estable3);

   }

}
