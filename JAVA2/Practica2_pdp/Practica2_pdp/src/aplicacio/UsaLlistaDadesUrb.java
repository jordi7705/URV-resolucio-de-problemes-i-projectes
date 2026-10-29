package aplicacio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dades.*;

public class UsaLlistaDadesUrb {
	static Scanner teclat = new Scanner(System.in,"UTF-8"); //no lleigeix els accents correctament

	public static void main(String[] args) throws FileNotFoundException {
		int numLinies, liniaIni, liniaFi;

		System.out.println("Indica les línies a llegir del fitxer");
		System.out.println("Quina és la primera línia a llegir del fitxer (valor >=1)");
		liniaIni = Integer.parseInt(teclat.nextLine());
		System.out.println("Quina és l'última línia a llegir del fitxer (valor <=12324)");
		liniaFi = Integer.parseInt(teclat.nextLine());

		numLinies = liniaFi - liniaIni + 1;
		String[] dataset = llegirLiniesFitxer(liniaIni, liniaFi);

		// Completar el codi a partir d'aquí
		LlistaDadesUrb dades = new LlistaDadesUrb(numLinies);
		afegirDades(dataset, dades, numLinies);
		mostraMenu();

		int opcio = Integer.parseInt(teclat.nextLine());
		if (opcio > 12) {
			System.out.println("Error, numero més gran dels valors del menu");
		}
		while (opcio != 12) {
			switch (opcio) {

				case 1:
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

			}
			mostraMenu();
			opcio = Integer.parseInt(teclat.nextLine());
		}

	}

	private static void opcio2(LlistaDadesUrb dades) {
		System.out.println("Escriu el nom del municipi del cual vols borrar el conjunt de dades.\n");
		String municipi = teclat.nextLine();
		String a = dades.escorrecteMunicipi(municipi);
		System.out.println("Municipi " + municipi + " eliminat? ");
		System.out.println(a);

		dades.eliminarMunicipi(municipi);
	}

	private static void opcio3(LlistaDadesUrb dades) {
		System.out.println("El municipi amb mes superficie de la llista és:" + dades.dadesMesSuperfice());
	}

	private static void opcio4(LlistaDadesUrb dades) {
		System.out
				.println("El municipi amb mes percentatge de superficie verda de la llista és:" + dades.percentVerd());
	}

	private static void opcio5(LlistaDadesUrb dades) {
		System.out.println("Introduiu un municipi");
		String mun = teclat.nextLine();
		System.out.println(dades.escorrecteMunicipi(mun));
		String text = String.format("%.3f", dades.variacioDeSolUrbanitzable(mun));
		System.out.println("La variacio del sòl urbanitzable del municipi " + mun + " és: " + text + " Hectàrees");
	}

	private static void opcio6(LlistaDadesUrb dades) {
		System.out
				.println("El primer municipi de costa sense sòl urbanitzable és: " + dades.urbCostaSenseUrbanitzable());
	}

	private static void opcio7(LlistaDadesUrb dades) { 
		System.out.println("Introduiu el valor de la densitat en persones/Ha minima que voleu.");
		int dens = Integer.parseInt(teclat.nextLine());
		String[] taula = dades.municipiesMesDensitat(dens);
		System.out.println(
				"Els municipis amb més densitat del valor introduit son:" + LlistaDadesUrb.toStringLlistaString(taula));
	}

	private static void opcio8(LlistaDadesUrb dades) { 

		LlistaDadesUrb muntanya = dades.LlistaDadesCostaOMuntanya(2);
		System.out.println("Introduiu el valor de la densitat en persones/Ha minima que voleu.");
		int dens = Integer.parseInt(teclat.nextLine());
		String[] taula = muntanya.municipiesMesDensitat(dens);
		System.out.println("Els municipis de muntanya amb més densitat del valor introduit son:"
				+ LlistaDadesUrb.toStringLlistaString(taula));
	}

	private static void opcio9(LlistaDadesUrb dades) {
		LlistaDadesUrb costa = dades.LlistaDadesCostaOMuntanya(1);
		System.out.println("El municipi de costa amb el percentatge de zones verde mes alt de la llista és:"
				+ costa.percentVerd());
	}

	private static void opcio10(LlistaDadesUrb dades) {
		LlistaDadesUrb aux = dades.LlistaDadesCostaOMuntanya(3);
		System.out.println(
				"El municipi que no és ni de costa ni de muntanya que té més superficie és:" + aux.dadesMesSuperfice());
	}

	private static void opcio11(LlistaDadesUrb dades) {
		System.out.println("Introduiu un municipi");
		String mun = teclat.nextLine();
		System.out.println(dades.escorrecteMunicipi(mun));
		LlistaDadesUrb municipiAnys = dades.dadesMunicipi(mun);
		System.out.println("Dades del municipi al llarg dels anys:\n" + municipiAnys.toString());
	}

	public static void mostraMenu() {
		System.out.println("\n\nOpcions del menu:");
		System.out.println("\n\t1. Mostrar el conjunt de dades de la llista.");
		System.out.println(
				"\t2. Eliminar el conjunt de dades d'un municipi.");
		System.out.println(
				"\t3. Mostrar la informació del municipi que té la superfície total més gran de Catalunya.");
		System.out.println(
				"\t4. Mostrar la informació del municipi que té el percentatge de superfície destinat a zones verdes més alt de Catalunya.");
		System.out.println(
				"\t5. Mostrar l'increment o decrement de la superfície de sòl urbanitzable al llarg dels anys d'un municipi.");
		System.out.println("\t6. Mostrar les dades del primer municipi de costa que no disposa de sòl urbanitzable.");
		System.out
				.println("\t7. Mostrar el nom dels municipis que tenen una densitat de població superior a un valor.");
		System.out.println(
				"\t8. Mostrar el nom dels municipis de muntanya que tenen una densitat de població superior a un valor.");
		System.out.println(
				"\t9. Mostrar la informació del municipi de costa que té el percentatge de superfície destinat a zones verdes més alt de Catalunya.");
		System.out.println(
				"\t10. Mostrar la informació del municipi que no és ni de costa ni de muntanya que té la superfície total més gran de Catalunya.");
		System.out.println(
				"\t11. Mostrar l'evolució de la població anual d'un municipi en els diferents anys on tenim dades.");
		System.out.println("\t12. Sortir del programa.");
		System.out.print("\n\t\t\tIndica opcio:\n");
	}

	private static String[] llegirLiniesFitxer(int liniaIni, int liniaFi) throws FileNotFoundException {
		String[] result;
		String dada;
		int nLinies;
		if (liniaIni < 1)
			liniaIni = 1;
		if (liniaFi > 12324)
			liniaFi = 12324;
		nLinies = liniaFi - liniaIni + 1;
		result = new String[nLinies];

		Scanner f = new Scanner(new File("Dades_Urban.csv"), "UTF-8");

		String capcalera = f.nextLine();
		System.out.println("El format de les dades en cada línia és el següent\n" + capcalera);
		// ens saltem les línies fins a la liniaIni
		for (int i = 1; i < liniaIni; i++) {
			dada = f.nextLine();
		}
		// ara anirem guardant les nLinies que sí volem llegir
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}

	private static void afegirDades(String[] dataset, LlistaDadesUrb dades, int numLinies) {
		String[] trossos;
		int anyDades;
		String nomMunicipi;
		String comarca;
		boolean esMunicipiDeCosta;
		boolean esMunicipiDeMuntanya;
		int numHabitants;
		double superficie_ha;
		double superfSolUrba_ha;
		double superfSolUrbanitzable_ha;
		double superfSolNOurbanitzable_ha;
		double superfIndustrial_ha;
		double superfServeis_ha;
		double superfLogistica_ha;
		double superfZonesVerdes_ha;
		double superfEquipHabitant_m2;
		DadesUrb n;

		for (int i = 0; i < dataset.length; i++) {
			trossos = dataset[i].split(";");
			anyDades = Integer.parseInt(trossos[0]);
			nomMunicipi = trossos[1];
			comarca = trossos[2];
			if (Integer.parseInt(trossos[3]) == 1) {
				esMunicipiDeCosta = true;
			} else {
				esMunicipiDeCosta = false;
			}

			if (trossos[4].equals("Zona de muntanya")) {
				esMunicipiDeMuntanya = true;
			} else {
				esMunicipiDeMuntanya = false;
			}
			numHabitants = Integer.parseInt(trossos[5]);
			superficie_ha = Double.parseDouble(trossos[6].replace(",", "."));
			superfSolUrba_ha = Double.parseDouble(trossos[7].replace(",", "."));
			superfSolUrbanitzable_ha = Double.parseDouble(trossos[8].replace(",", "."));
			superfSolNOurbanitzable_ha = Double.parseDouble(trossos[9].replace(",", "."));
			superfIndustrial_ha = Double.parseDouble(trossos[10].replace(",", "."));
			superfServeis_ha = Double.parseDouble(trossos[11].replace(",", "."));
			superfLogistica_ha = Double.parseDouble(trossos[12].replace(",", "."));
			superfZonesVerdes_ha = Double.parseDouble(trossos[13].replace(",", "."));
			superfEquipHabitant_m2 = Double.parseDouble(trossos[14].replace(",", "."));

			n = new DadesUrb(anyDades, nomMunicipi, comarca, esMunicipiDeCosta, esMunicipiDeMuntanya, numHabitants,
					superficie_ha, superfSolUrba_ha, superfSolUrbanitzable_ha, superfSolNOurbanitzable_ha,
					superfIndustrial_ha, superfServeis_ha, superfLogistica_ha, superfZonesVerdes_ha,
					superfEquipHabitant_m2);
			dades.afegirDadesUrb(n);
		}

	}

}