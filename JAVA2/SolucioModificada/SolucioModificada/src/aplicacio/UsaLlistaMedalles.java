package aplicacio;

import dades.*;
import java.io.*;
import java.util.Scanner;

public class UsaLlistaMedalles {
	static Scanner teclat = new Scanner(System.in,"UTF-8");

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Indica el número de línies a llegir del fitxer (màxim 21694)");
		int numLinies = Integer.parseInt(teclat.nextLine());
		String[] dataset = llegirLiniesFitxer(numLinies);

		// Codi solució

		LlistaMedalles dades = new LlistaMedalles(numLinies);
		afegirDadesLinies(dataset, numLinies, dades);

		// TODO QÜESTIONARI

		// Posar el codi de resposta a les preguntes del qüestionari
		// a partir d'aquí
		// no cal llegir res de teclat, defineix atributs i fixa els valors
		// d'entrada als mètodes segons indiqui l'enunciat de les preguntes

		// pots comentar la resta de codi a partir d'aqui per facilitar-te
		// els jocs de proves.

		mostraMenu();
		int opcio = Integer.parseInt(teclat.nextLine());
		while (opcio != 14) {
			switch (opcio) {
				case 1:
					// 1. Mostrar el conjunt de mesures de la llista
					System.out.println("Les dades de la llista: " + dades);
					break;
				case 2:
					opcio2(dades);
					break;
				case 3:
					opcio3(dades);
					break;
				case 4:
					opcio4(dades);
					break;
				case 5:
					opcio5(dades);
					break;
				case 6:
					opcio6(dades);
					break;
				case 7:
					opcio7(dades);
					break;
				case 8:
					opcio8(dades);
					break;
				case 9:
					opcio9(dades);
					break;
				case 10:
					opcio10(dades);
					break;
				case 11:
				    opcio11(dades);
					break;
				case 12:
				    opcio12(dades);
					break;
				case 13:
				    opcio13(dades);
					break;
			}
			mostraMenu();
			opcio = Integer.parseInt(teclat.nextLine());
		}

	}

	public static void mostraMenu() {
		System.out.println("\n\nOpcions del menu:");
		System.out.println("\n\t1. Mostrar el conjunt de mesures de la llista");
		System.out.println(
				"\t2. Mostrar el número de medalles aconseguides per un país, d'un cert tipus, en els jocs d'un any en una ciutat");
		System.out.println(
				"\t3. Mostrar les dades de la primera medalla que hi ha a la llista d'un cert tipus, obtinguda per una persona d'un determinat sexe i en un any");
		System.out.println(
				"\t4. Mostrar les dades de la primera medalla aconseguida per una dona en els jocs olímpics d'un cert any");
		System.out.println(
				"\t5. Mostrar el país que ha aconseguit més medalles d'un cert tipus. Les dades necessàries s'indiquen per teclat");
		System.out.println("\t6. Mostrar el medaller del país");
		System.out.println("\t7. Mostrar qui ha aconseguit les medalles en un tipus de prova i en uns jocs.");
		System.out.println(
				"\t8. En el conjunt de medalles d'un tipus de prova i jocs, mostrar les dades de la primera medalla que hi ha a la llista d'un cert tipus, obtinguda per una persona d'un determinat sexe i en un any");
		System.out.println(
				"\t9. En el conjunt de medalles d'un tipus de prova i jocs, mostrar el país que ha aconseguit més medalles d'un cert tipus");
		System.out.println("\t10. Eliminar el conjunt de medalles d'uns jocs en una prova");
		System.out.println("\t11. Sortir");
		System.out.print("\n\t\t\tIndica opcio:\n");
	}

	public static void opcio2(LlistaMedalles dades) {
		String nomCiutat, tipusMedalla, pais;
		int anyJocs;
		// això ho llegirem de teclat
		nomCiutat = "beijing";
		anyJocs = 2022;
		tipusMedalla = "GOLD";
		pais = "SWE";
		int numMedalles = dades.numMedallesPaisJocs(nomCiutat, anyJocs, tipusMedalla, pais);
		System.out.println("El numero de medalles " + tipusMedalla + " aconseguides pel pais " + pais
				+ " en els jocs de " + anyJocs + " celebrat a " + nomCiutat + " ha estat de " + numMedalles);
	}

	public static void opcio3(LlistaMedalles dades) {
		String tipusMedalla, sexe;
		int anyJocs;
		// això ho llegirem de teclat
		anyJocs = 2022;
		tipusMedalla = "GOLD";
		sexe = "Women";
		Medalla aux = dades.primeraMedalla(tipusMedalla, sexe, anyJocs);
		System.out.println("Les dades de la primera medalla del tipus " + tipusMedalla + " en l'any " + anyJocs
				+ " aconseguida per " + sexe + " es: " + aux);
	}

	public static void opcio4(LlistaMedalles dades) {
		int anyJocs;
		String nomCiutat;
		// això ho llegirem de teclat
		nomCiutat = "beijing";
		anyJocs = 2022;
		Medalla aux = dades.primeraMedallaFemenina(nomCiutat, anyJocs);
		System.out.println("Les dades de la primera medalla en l'any " + anyJocs + " celebrat a " + nomCiutat
				+ " aconseguida per una dona es: " + aux);
	}

	public static void opcio5(LlistaMedalles dades) {
		String tipusMedalla;
		// això ho llegirem de teclat
		tipusMedalla = "BRONZE";
		String pais = dades.paisMesMedallesTipus(tipusMedalla);
		System.out.println("El pais que ha tingut més medalles del tipus " + tipusMedalla + " es " + pais);
	}

	public static void opcio6(LlistaMedalles dades) {
		String pais;
		// això ho llegirem de teclat
		pais = "SWE";
		int[] medaller = dades.medaller(pais);
		System.out.println(
				"MEDALLER del pais: " + pais + " [ " + medaller[0] + ", " + medaller[1] + ", " + medaller[2] + "]");
	}

	public static void opcio7(LlistaMedalles dades) {
		String nomCiutat, nomProva;
		int anyJocs;
		// això ho llegirem de teclat
		nomCiutat = "beijing";
		anyJocs = 2022;
		nomProva = "Ice Dance";
		LlistaMedalles aux = dades.medallesJocsIprova(nomProva, nomCiutat, anyJocs);
		System.out.println("Als jocs de " + anyJocs + " celebrats a " + nomCiutat + " en la prova " + nomProva
				+ " s'han obtingut les seguents medalles");
		System.out.println(aux);
	}

	public static void opcio8(LlistaMedalles dades) {
		// primer agafem la subllista com en l'opcio 7
		String nomCiutat, nomProva;
		int anyJocs;
		// això ho llegirem de teclat
		nomCiutat = "beijing";
		anyJocs = 2022;
		nomProva = "Ice Dance";
		LlistaMedalles aux = dades.medallesJocsIprova(nomProva, nomCiutat, anyJocs);

		// ara, sobre el resultat de la llista aux, apliquem el mateix que hem fet a
		// l'opcio 3

		String tipusMedalla, sexe;
		// això ho llegirem de teclat
		tipusMedalla = "GOLD";
		sexe = "Mixed";
		Medalla m = aux.primeraMedalla(tipusMedalla, sexe, anyJocs);
		System.out.println("Les dades de la primera medalla del tipus " + tipusMedalla + " en l'any " + anyJocs
				+ " a la ciutat de " + nomCiutat + " aconseguida per " + sexe + " en la prova: " + nomProva + " es: "
				+ m);

	}

	public static void opcio9(LlistaMedalles dades) {
		// primer agafem la subllista com en l'opcio 7
		String nomCiutat, nomProva;
		int anyJocs;
		// això ho llegirem de teclat
		nomCiutat = "beijing";
		anyJocs = 2022;
		nomProva = "Ice Dance";
		LlistaMedalles aux = dades.medallesJocsIprova(nomProva, nomCiutat, anyJocs);

		// ara, sobre el resultat de la llista aux, apliquem el mateix que hem fet a
		// l'opcio 5

		String tipusMedalla;
		// això ho llegirem de teclat
		tipusMedalla = "GOLD";
		String pais = aux.paisMesMedallesTipus(tipusMedalla);
		System.out.println("El pais que ha tingut més medalles del tipus " + tipusMedalla + " es " + pais
				+ "Als jocs de " + anyJocs + " celebrats a " + nomCiutat + " en la prova " + nomProva);
	}

	public static void opcio10(LlistaMedalles dades) {
		String nomCiutat, nomProva;
		int anyJocs;
		// això ho llegirem de teclat
		nomCiutat = "beijing";
		anyJocs = 2022;
		nomProva = "Ice Dance";

		LlistaMedalles aux = dades.medallesJocsIprova(nomProva, nomCiutat, anyJocs);
		System.out.println("Als jocs de " + anyJocs + " celebrats a " + nomCiutat + " en la prova " + nomProva
				+ " s'han obtingut les seguents medalles");
		System.out.println(aux);

		dades.eliminarMedallesJocs(nomCiutat, anyJocs, nomProva);

		aux = dades.medallesJocsIprova(nomProva, nomCiutat, anyJocs);
		System.out.println("Despres d'eliminar als jocs de " + anyJocs + " celebrats a " + nomCiutat + " en la prova "
				+ nomProva + " s'han obtingut les seguents medalles");
		System.out.println(aux);
	}

	public static void opcio11(LlistaMedalles dades){
		String pais;
		LlistaMedalles aux;
		pais="USA";
		aux=dades.medallespais(pais);
		System.out.println(aux);
	}

	public static void opcio12(LlistaMedalles dades){
		String pais;
		int anyini, anyfin, aux;
		pais="USA";
		anyini=2022;
		anyfin=2018;
		aux=dades.quantesMedallesAnys(pais, anyini, anyfin);
		System.out.println("Medalles en aquest periode: "+aux);
	}

	public static void opcio13(LlistaMedalles dades){
		String nomprova, tipusmedalla;
		String[] aux;
		nomprova="Curling";
		tipusmedalla="GOLD";
		aux=dades.paisosUnaMeda(nomprova, tipusmedalla);
		System.out.println(aux);
	}

	private static void afegirDadesLinies(String[] dataset, int numLinies, LlistaMedalles dades) {
		String[] trossos, jocs;
		String disciplina, poblacioJocs, nomProva, genere, medalla, tipusParticipacio, paisAtleta;
		int anyJocs;

		Medalla n;
		for (int i = 0; i < dataset.length; i++) {
			trossos = dataset[i].split(";");
			disciplina = trossos[0];
			jocs = trossos[1].split("-");
			poblacioJocs = jocs[0];
			anyJocs = Integer.parseInt(jocs[1]);
			nomProva = trossos[2];
			genere = trossos[3];
			medalla = trossos[4];
			tipusParticipacio = trossos[5];
			paisAtleta = trossos[6];
			n = new Medalla(disciplina, poblacioJocs, anyJocs, nomProva, genere, medalla, tipusParticipacio,
					paisAtleta);
			dades.afegirMedalla(n);

		}
	}

	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		String[] result;
		if (nLinies < 0)
			nLinies = 0;
		if (nLinies > 21694)
			nLinies = 21694;
		result = new String[nLinies];
		Scanner f = new Scanner(new File("SolucioModificada/olympic_medals_part_UTF8.csv"));

		String capcalera = f.nextLine();
		System.out.println("El format de les dades en cada línia és el següent\n" + capcalera);
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}

}