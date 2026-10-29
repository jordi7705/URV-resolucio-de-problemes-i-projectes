public class UsaMesuraDiaAmpliada {
        public static void main(String[] args) throws Exception {
                System.out.println("Aplicació per validar la classe MesuraDia");

                validarConstructors();
                validarGetterSettersToString();
                validarCopiaIguals();
                validarNivellGlucosaMesAlt();
                validarVariacioNivellsGlucosa();
                validarDiferenciaVariacio();
                validarEstimarValors();
                consultarRang();
                validarmodificarlimits();
                validarmesuresinferiorsrang();
                validarmesuresuperiorsrang();
                validarestabilitatGlucosa();
        }

        private static void validarConstructors() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar constructors\n");
                int[] v1 = { 75, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 125,
                                120, 135 };
                int[] v2error = { 90, 95, 92, 91, 89, 85, 85, 85, 90 };
                MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
                System.out.println("Constructor amb dades correctes: " + d1);
                MesuraDiaAmpliada d2 = new MesuraDiaAmpliada(v2error);
                System.out.println("Constructor amb dades INcorrectes: " + d2);

        }

        private static void validarGetterSettersToString() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar GetterSettersToString\n");
                int[] v1 = { 90, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 125,
                                120, 105 };

                MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
                System.out.println("Mesures de d1 inicials amb toString:\n" + d1); // no cal posar la crida a toString
                                                                                   // de forma
                                                                                   // explícita
                System.out.println("Mesures de d1 inicials amb els getters: ");
                for (int i = 0; i < v1.length; i++) {
                        System.out.print(d1.getMesuraHora(i) + ", ");
                }
                System.out.println();

                System.out.println("Modifiquem el primer valor amb el setter");
                d1.setMesuraHora(0, 100);
                System.out.println("Mesures de d1 modificades:\n" + d1);

                System.out.println("Modifiquem tot el contingut amb el setter de tot el conjunt");
                int[] vMod = { 91, 93, 91, 99, 87, 87, 87, 87, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110,
                                105,
                                125,
                                120, 105 };
                d1.setMesures(vMod);
                System.out.println("Mesures de d1 modificades:\n" + d1);

        }

        private static void validarCopiaIguals() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar CopiaIguals\n");
                int[] v1 = { 90, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 125,
                                120, 105 };

                MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
                MesuraDiaAmpliada d2 = d1.copia();
                MesuraDiaAmpliada d3 = d1;

                System.out.println("d2 és un duplicat de d1 i per tant són iguals: " + d1.iguals(d2));
                d1.setMesuraHora(0, 88);
                System.out.println(
                                "He modificat un valor de d1, per tant, ara el seu duplicat ja no serà igual: "
                                                + d1.iguals(d2));

                System.out.println(
                                "d3 és una referència que apunta a d1 (no un duplicat), per tant, sempre serà igual a d1 tant si es modifica com si no: "
                                                + d1.iguals(d3));

        }

        private static void validarNivellGlucosaMesAlt() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar nivell de glucosa més alt\n");
                int[] v1 = { 90, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 125,
                                120, 105 };

                MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
                System.out.println("Valors mesures: " + d1);
                System.out.println("Valor més alt en una posició intermitja: " + d1.valorMesAlt());

                int[] v2 = { 190, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110,
                                105,
                                125,
                                120, 105 };

                MesuraDiaAmpliada d2 = new MesuraDiaAmpliada(v2);
                System.out.println("Valors mesures: " + d2);
                System.out.println("Valor més alt en la primera posició: " + d2.valorMesAlt());

                int[] v3 = { 90, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 125,
                                120, 195 };

                MesuraDiaAmpliada d3 = new MesuraDiaAmpliada(v3);
                System.out.println("Valors mesures: " + d3);
                System.out.println("Valor més alt en la posició final: " + d3.valorMesAlt());

        }

        private static void validarVariacioNivellsGlucosa() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar variació nivells de glucosa\n");

                int[] v1 = { 90, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 125,
                                120, 105 };

                MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
                System.out.println("Valors mesures: " + d1);
                System.out.println("Variació: " + d1.variacioDia());

                int[] v2 = { 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90,
                                90, 90 };

                MesuraDiaAmpliada d2 = new MesuraDiaAmpliada(v2);
                System.out.println("Valors mesures: " + d2);
                System.out.println("Variació quan hi ha el mateix valor a totes les posicions: " + d2.variacioDia());

        }

        private static void validarDiferenciaVariacio() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar diferencia variació\n");

                int[] v1 = { 90, 95, 92, 91, 89, 85, 85, 85, 90, 110, 115, 105, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 125,
                                120, 105 };

                MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
                System.out.println("Valors mesures: " + d1);
                System.out.println("Variació: " + d1.variacioDia());

                int[] v2 = { 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90,
                                90, 90 };

                MesuraDiaAmpliada d2 = new MesuraDiaAmpliada(v2);
                System.out.println("Valors mesures: " + d2);
                System.out.println("Variació quan hi ha el mateix valor a totes les posicions: " + d2.variacioDia());

                System.out.println(
                                "la diferencia de variació entre els dos dies és: " + d1.diferenciaValorsVariacio(d2));

        }

        private static void validarEstimarValors() {
                System.out.println(
                                "----------------------------------------------------------------------------------------------");
                System.out.println("\n\nValidar Estimar Valors\n");
                int[] v1 = { 90, 95, 92, 91, 89, 85, 85, 85, 90, 120, 115, 85, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 125,
                                120, 105 };
                MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);

                System.out.println("Calculem l'estimació de tots els minuts entre les 8 i les 9. Increment positiu.");
                for (int i = 0; i < 60; i++) {
                        System.out.print("\tm: " + i + " V: " + d1.valorGlucosaEstimat(8, i));
                }

                System.out.println(
                                "\nCalculem l'estimació de tots els minuts entre les 10 i les 11. Increment negatiu.");
                for (int i = 0; i < 60; i++) {
                        System.out.print("\tm: " + i + " V: " + d1.valorGlucosaEstimat(10, i));
                }

                System.out.println("\nCalculem l'estimació de tots els minuts entre les 5 i les 6. Valors iguals");
                for (int i = 0; i < 60; i++) {
                        System.out.print("\tm: " + i + " V: " + d1.valorGlucosaEstimat(5, i));
                }
                System.out.println();
        }

        private static void consultarRang() { //consultar rang de glucosa
                String aux = MesuraDiaAmpliada.limitRang();
                System.out.println(aux);
        }

        private static void validarmodificarlimits() { //modificar rang de glucosa
               String aux = MesuraDiaAmpliada.modificaLimitsRang(80, 130);
               System.out.println(aux);
        }

        private static void validarmesuresinferiorsrang(){
                int valors;
                int[] v1 = { 20, 30, 30, 30, 89, 85, 85, 85, 90, 120, 115, 85, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 125,
                                120, 150 }; //dia amb valors inferiors al rang
                MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
                valors = MesuraDiaAmpliada.consultavalorsinf();
                System.out.println("El dia "+ d1);
                System.out.println("presentava "+ valors+" valors inferiors al rang han sigut substituits per valors dintre del rang");

        }

        private static void validarmesuresuperiorsrang(){
                int valors;
                int[] v1 = { 20, 30, 30, 91, 89, 85, 85, 85, 90, 120, 115, 85, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 150,
                                170, 150 };//dia amb valors superios al rang
                MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
                valors = MesuraDiaAmpliada.consultavalorsup();
                System.out.println("El dia "+ d1);
                System.out.println("presentava "+ valors+" valors superiors al rang han sigut substituits per valors dintre del rang");
                
        }

        private static void validarestabilitatGlucosa(){
           
                int[] v1 = { 20, 30, 30, 91, 89, 85, 85, 85, 90, 120, 115, 85, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 150,
                                170, 150 }; //dia amb nivells de glucosa NO estables durant el dia
                MesuraDiaAmpliada d1 = new MesuraDiaAmpliada(v1);
                String aux=MesuraDiaAmpliada.glucosaEstable();
                System.out.println(aux);

                int[] v2 = { 100, 100, 100, 91, 89, 85, 85, 85, 90, 120, 115, 85, 100, 99, 125, 130, 128, 120, 115, 110,
                                105, 100,
                                100, 100 }; //dia amb nivells de glucosa estables durant el dia
                MesuraDiaAmpliada d2 = new MesuraDiaAmpliada(v2);
                String aux2=MesuraDiaAmpliada.glucosaEstable();
                System.out.println(aux2);

                

        }
        



}
