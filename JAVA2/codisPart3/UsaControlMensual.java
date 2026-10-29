public class UsaControlMensual {

        // subconjunt de valors per facilitar els jocs de proves
        // valors de dies estables en el rang [70-140]
        private static int[] v1 = { 90, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115,
                        110, 105, 125, 120, 105 };
        private static int[] v2 = { 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90,
                        90, 90, 90 };
        private static int[] v3 = { 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 104, 103, 102,
                        101, 100, 99, 98, 97 };
        private static int[] v4 = { 125, 125, 130, 130, 130, 130, 135, 130, 130, 125, 140, 140, 140, 135, 130, 130, 120,
                        120, 135, 135, 135, 130, 130, 135 };
        private static int[] v5 = { 105, 115, 115, 125, 130, 125, 125, 115, 130, 115, 130, 130, 115, 115, 130, 135, 140,
                        140, 135, 120, 140, 140, 120, 110 };
        private static int[] v6 = { 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140,
                        140, 140, 140, 140, 140, 140, 140 };

        // valors de dies NO estables en el rang [70-140]
        private static int[] v7 = { 150, 150, 150, 150, 150, 100, 100, 150, 150, 150, 150, 150, 150, 150, 150, 100, 100,
                        150, 150, 150, 150, 150, 150, 150 };
        private static int[] v8 = { 150, 150, 150, 150, 150, 150, 150, 150, 100, 150, 150, 150, 150, 150, 150, 150, 150,
                        150, 150, 150, 150, 150, 150, 150 };
        private static int[] v9 = { 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 150, 100,
                        150, 150, 150, 150, 150, 150, 150 };
        private static int[] v10 = { 100, 150, 150, 150, 150, 100, 150, 150, 150, 100, 150, 150, 150, 150, 150, 150,
                        150, 150, 150, 150, 150, 100, 150, 150 };

        private static MesuraDiaAmpliada m1 = new MesuraDiaAmpliada(v1);
        private static MesuraDiaAmpliada m2 = new MesuraDiaAmpliada(v2);
        private static MesuraDiaAmpliada m3 = new MesuraDiaAmpliada(v3);
        private static MesuraDiaAmpliada m4 = new MesuraDiaAmpliada(v4);
        private static MesuraDiaAmpliada m5 = new MesuraDiaAmpliada(v5);
        private static MesuraDiaAmpliada m6 = new MesuraDiaAmpliada(v6);
        private static MesuraDiaAmpliada m7 = new MesuraDiaAmpliada(v7);
        private static MesuraDiaAmpliada m8 = new MesuraDiaAmpliada(v8);
        private static MesuraDiaAmpliada m9 = new MesuraDiaAmpliada(v9);
        private static MesuraDiaAmpliada m10 = new MesuraDiaAmpliada(v10);

        public static void main(String[] args) throws Exception {
                System.out.println("Aplicació per validar la classe ControlMensual");

                validarConstructor();
                validarAfegirMesures();
                validarSetGetToString();
                validarDiaDiferenciaMesGran();
                validarNumDiesConsecutiusEstable();
                validarComparacioPersones();
        }

        private static void validarConstructor() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar constructor\n");
                ControlMensual persona1 = new ControlMensual("Persona 1", "SETEMBRE");
                System.out.println("\tDades inicials persona en el mes de setembre " + persona1);
                persona1 = new ControlMensual("Persona 1", "OCTUBRE");
                System.out.println("\tDades inicials persona en el mes d'octubre " + persona1);
                persona1 = new ControlMensual("Persona 1", "MES ERROR");
                System.out.println("\tDades inicials persona un mes que no existeix " + persona1);
        }

        private static void validarAfegirMesures() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar afegir mesures\n");

                ControlMensual persona1 = new ControlMensual("Persona 1", "MES ERROR");
                persona1.afegirDadesMesura(m1);
                System.out.println("\tIntentant afegir dades en persona en un mes que no existeix " + persona1);

                // Afegim algunes dades a un mes correcte.
                // repetirem algunes mesures per treballar només amb les dades definides al
                // principi
                persona1 = new ControlMensual("Persona 1", "SETEMBRE");
                persona1.afegirDadesMesura(m1);
                persona1.afegirDadesMesura(m10);
                persona1.afegirDadesMesura(m4);
                persona1.afegirDadesMesura(m3);
                persona1.afegirDadesMesura(m1);
                persona1.afegirDadesMesura(m2);
                persona1.afegirDadesMesura(m5);
                persona1.afegirDadesMesura(m4);
                persona1.afegirDadesMesura(m1);
                persona1.afegirDadesMesura(m10);
                System.out.println("\tAlgunes dades en persona en un mes correcte " + persona1);

        }

        private static void validarSetGetToString() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar GetterSettersToString\n");
                ControlMensual persona1 = new ControlMensual("Persona 1", "SETEMBRE");
                persona1.afegirDadesMesura(m1);
                persona1.afegirDadesMesura(m10);
                persona1.afegirDadesMesura(m4);
                System.out.println("\tAlgunes dades en persona en un mes correcte\n" + persona1);
                System.out.println("\n\n\tConsultem les dades de la persona el dia 2 del mes "
                                + persona1.getDadesMesuraDia(1));
                // ara modifiquem les dades d'aquest dia
                persona1.setDadesMesuraDia(m3, 1);
                // mostrem de nou les dades del dia
                System.out.println("\n\n\tConsultem les dades de la persona el dia 2 del mes "
                                + persona1.getDadesMesuraDia(1));
                // i mostrem totes les dades de la persona
                System.out.println("\n\n\tAlgunes dades de la persona un cop modificades\n" + persona1);
        }

        private static void validarDiaDiferenciaMesGran() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar dia diferencia mes gran\n");
                ControlMensual persona1 = new ControlMensual("Persona 1", "SETEMBRE");
                persona1.afegirDadesMesura(m2);
                System.out.println("Dia amb diferència més gran " + persona1.diaDiferenciaMesGranVariacio());
                persona1.afegirDadesMesura(m3);
                System.out.println("Dia amb diferència més gran " + persona1.diaDiferenciaMesGranVariacio());
                persona1.afegirDadesMesura(m4);
                persona1.afegirDadesMesura(m1);
                System.out.println("Dia amb diferència més gran " + persona1.diaDiferenciaMesGranVariacio());
                persona1.afegirDadesMesura(m5);
                persona1.afegirDadesMesura(m6);
                persona1.afegirDadesMesura(m7);
                persona1.afegirDadesMesura(m8);
                persona1.afegirDadesMesura(m9);
                persona1.afegirDadesMesura(m10);
                System.out.println("Dia amb diferència més gran " + persona1.diaDiferenciaMesGranVariacio());

        }

        private static void validarNumDiesConsecutiusEstable() {
                int numEstable = 4;
                // podem anar canviant valors i modificant els límits de la iteració
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar num dies consecutius estables\n");
                ControlMensual persona1 = new ControlMensual("Persona 1", "Setembre");
                for (int i = 0; i < numEstable; i++)
                        persona1.afegirDadesMesura(new MesuraDiaAmpliada(v1));
                persona1.afegirDadesMesura(new MesuraDiaAmpliada(v10));
                for (int i = 0; i < numEstable * 2; i++)
                        persona1.afegirDadesMesura(new MesuraDiaAmpliada(v1));
                persona1.afegirDadesMesura(new MesuraDiaAmpliada(v9));

                System.out.println(
                                "\nMostrem num dies consecutius la persona es estable "
                                                + persona1.maxDiesConsecutiusEstabilitzats());

        }

        private static void validarComparacioPersones() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar comparacio persones \n");

                ControlMensual persona1 = new ControlMensual("Persona 1", "Setembre");
                persona1.afegirDadesMesura(new MesuraDiaAmpliada(v1));
                persona1.afegirDadesMesura(new MesuraDiaAmpliada(v1));
                persona1.afegirDadesMesura(new MesuraDiaAmpliada(v2));
                persona1.afegirDadesMesura(new MesuraDiaAmpliada(v1));
                persona1.afegirDadesMesura(new MesuraDiaAmpliada(v1));
                persona1.afegirDadesMesura(new MesuraDiaAmpliada(v3));
                persona1.afegirDadesMesura(new MesuraDiaAmpliada(v10));
                persona1.afegirDadesMesura(new MesuraDiaAmpliada(v2));
                // System.out.println("Dades de la persona 1 " + persona1.toString());

                System.out.println(
                                "\nMostrem num dies consecutius la persona 1 es estable "
                                                + persona1.maxDiesConsecutiusEstabilitzats());

                ControlMensual persona2 = new ControlMensual("Persona 2", "Setembre");
                persona2.afegirDadesMesura(new MesuraDiaAmpliada(v1));
                persona2.afegirDadesMesura(new MesuraDiaAmpliada(v1));
                persona2.afegirDadesMesura(new MesuraDiaAmpliada(v4));
                persona2.afegirDadesMesura(new MesuraDiaAmpliada(v10));
                persona2.afegirDadesMesura(new MesuraDiaAmpliada(v3));
                persona2.afegirDadesMesura(new MesuraDiaAmpliada(v10));
                persona2.afegirDadesMesura(new MesuraDiaAmpliada(v4));
                persona2.afegirDadesMesura(new MesuraDiaAmpliada(v2));
                // System.out.println("Dades de la persona 2 " + persona2.toString());
                System.out.println(
                                "\nMostrem num dies consecutius la persona 2 es estable "
                                                + persona2.maxDiesConsecutiusEstabilitzats());

                System.out.println("\nMostrem que la persona1 és més estable que la 2 "
                                + persona1.esMesEstableA(persona2));
                System.out.println("\nMostrem que la persona2 NO és més estable que la 1 "
                                + persona2.esMesEstableA(persona1));
        }

}
