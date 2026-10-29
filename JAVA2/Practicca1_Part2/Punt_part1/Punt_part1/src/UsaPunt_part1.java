public class UsaPunt_part1 {
    public static void main(String[] args) throws Exception {
        // utilitzem tot de mètodes static auxiliars per fer
        // més llegible el codi

       
         System.out.println(Punt.mostraFinestra());
         /*  validacioConstructors();
          validacioGettersSetters();
          validacioCopia();
          validacioIguals();
          validacioDistancia();
          validacioReflexio();*/
         

    }

    /**
     * Mètode auxiliar per validar les crides als constructors
     * s'aprofita per mostrar els valors del punt
     * utilitzant el toString de forma implícita (línia 23)
     * de forma explícita (línia 25)
     * i amb els getters (línia 27)
     */
    private static void validacioConstructors() {
        // prova constructor sense paràmetres i amb paràmetres
        Punt p1 = new Punt();
        System.out.println("El contingut de p1 es " + p1);
        Punt p2 = new Punt(8, 9);
        System.out.println("El contingut de p2 es " + p2.toString());
        Punt p3 = new Punt(1, 2);
        System.out.println("El contingut de p3 es ( " + p3.getX() + ", " + p3.getY() + ")");
    }

    private static void validacioGettersSetters() {
        System.out.println("\n\nValidem getters i setters");
        Punt p1 = new Punt(1, 2);
        System.out.println("Mostro el contingut amb els getters ( " + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("Mostro el contingut amb el toString per validar que és el mateix " + p1);
        System.out.println("Modifico els valors amb els setters x=10 i y=7");
        p1.setX(10);
        p1.setY(7);
        System.out.println("Mostro el nou contingut del punt modificat " + p1);
    }

    /**
     * Mètode auxiliar per validar el mètode copia
     */
    private static void validacioCopia() {
        System.out.println("\n\nValidem mètode còpia");
        Punt p2 = new Punt(8, 9);
        Punt p3;
        p3 = p2.copia();
        System.out.println("El contingut de p2 es " + p2);
        System.out.println("I el contingut del seu duplicat es: " + p3);
    }

    /**
     * Mètode auxiliar per validar el mètode iguals i treballar concepte de
     * referència i contingut.
     * En el codi de l'alumne és suficient trobar les 7 primeres línies
     */
    private static void validacioIguals() {
        System.out.println("\n\nValidem mètode iguals");
        Punt p2 = new Punt(8, 9);
        Punt p3 = p2.copia();
        if (p3.iguals(p2))
            System.out.println(p2 + " i " + p3 + " són punts amb el mateix contingut");
        else
            System.out.println(p2 + " i " + p3 + " NO són punts amb el mateix contingut");

        p3.setX(24);
        if (p3.iguals(p2))
            System.out.println(p2 + " i " + p3 + " són punts amb el mateix contingut");
        else
            System.out.println(p2 + " i " + p3 + " NO són punts amb el mateix contingut");

        // copiem la referencia, per veure què passa
        Punt p4;
        p4 = p2;

        if (p4.iguals(p2))
            System.out.println(p2 + " i " + p4 + " són punts amb el mateix contingut");
        else
            System.out.println(p2 + " i " + p4 + " NO són punts amb el mateix contingut");

        p4.setX(14);
        System.out.println("Ara modifiquem només el p4, no el p2, i QUÈ PASSA???");
        if (p4.iguals(p2))
            System.out.println(p2 + " i " + p4 + " són punts amb el mateix contingut");
        else
            System.out.println(p2 + " i " + p4 + " NO són punts amb el mateix contingut");

        if (p4 == p2)
            System.out.println("Les referències dels punts són iguals ");
        else
            System.out.println("Les referències dels punts NO són iguals  ");
    }

    /**
     * Mètode auxiliar per validar el mètode distància
     */
    private static void validacioDistancia() {
        System.out.println("\n\nValidem la distància");
        Punt p1 = new Punt(0, 0);
        Punt p2 = new Punt(3, 4);
        System.out.println("La distancia entre el punt " + p1 + " i el punt " + p2 + " es " + p1.distancia(p2));
    }

    /**
     * Mètode auxiliar per validar el mètode reflexió
     */
    private static void validacioReflexio() {
        System.out.println("\n\nValidem la reflexió");
        Punt p1 = new Punt(3, 4);
        Punt p2 = p1.reflexio();
        System.out.println("El punt " + p1 + " amb una reflexió segon l'eix de les x és " + p2);
        // una doble reflexió ha de donar el mateix punt
        Punt p3 = p2.reflexio();
        System.out.println("I si apliquem una segona reflexió torna a tenir el mateix valor" + p3);
    }

}
