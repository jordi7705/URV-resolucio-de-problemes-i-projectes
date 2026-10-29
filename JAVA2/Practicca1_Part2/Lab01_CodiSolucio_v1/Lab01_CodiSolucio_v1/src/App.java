public class App {
    public static void main(String[] args) throws Exception {
        validacioConstructors();
		comparacioConstructorSetter();
		validacioIguals();
		validacioDiaSeguent();
		validacioDiaAnterior();
		validacioDataEsAnyTraspas();
		validacioDataInferiorAltra();
		validacioDiesEntreDuesDates();

	}

	private static void validacioConstructors() {
		System.out.println("\n\nValidació dels constructors");
		Data data, dataIniciCurs;

		System.out.println("Constructor sense parametres");
		data = new Data();
		System.out.println(data);

		System.out.println("Constructor amb parametres, data correcta");
		dataIniciCurs = new Data(8, 9, 2025);
		System.out.println(dataIniciCurs);

		System.out.println("Constructor amb parametres, data incorrecta");
		data = new Data(29, 2, 2025);
		System.out.println(data);
	}

	private static void comparacioConstructorSetter() {
		Data data;

		System.out.println("\n\nComparacio constructor i setter");
		data = new Data();
		System.out.println(data);
		data = new Data(10, 10, 2023);
		System.out.println(data);
		data.setData(15, 10, 2023);
		System.out.println(data);
		// debuga aquest mètode i revisa com es modifiquen les referencies de l'objecte
		// data

	}

	private static void validacioIguals() {
		System.out.println("\n\nValidació del mètode esIgual");
		Data data, data2;
		System.out.println("comprova si dos dates son iguals, dates iguals");
		data = new Data(27, 7, 2011);
		data2 = new Data(27, 7, 2011);
		System.out.println(data.esIgual(data2));

		System.out.println("comprova si dos dates son iguals, dates diferents");
		data.setData(27, 7, 2011);
		data2.setData(28, 7, 2011);
		System.out.println(data.esIgual(data2));
	}

	private static void validacioDiaSeguent() {
		System.out.println("\n\nValidació del mètode diaSeguent");
		Data data, dataSeguent;

		System.out.println("Dia seguent al 27/07/23");
		data = new Data(27, 7, 2023);
		dataSeguent=data.diaSeguent();
		System.out.println(dataSeguent);

		System.out.println("Dia seguent al 31/07/23 en un mes de 31 dies");
		data = new Data(31, 7, 2023);
		dataSeguent=data.diaSeguent();
		System.out.println(dataSeguent);

		System.out.println("Dia seguent al 30/09/23 en un mes de 30 dies");
		data = new Data(30, 9, 2023);
		dataSeguent=data.diaSeguent();
		System.out.println(dataSeguent);

		System.out.println("Dia seguent al 28/02/23 en un febrer no any de traspas");
		data = new Data(28, 2, 2023);
		dataSeguent=data.diaSeguent();
		System.out.println(dataSeguent);

		System.out.println("Dia seguent al 28/02/2020 en un febrer any de traspas");
		data = new Data(28, 2, 2020);
		dataSeguent=data.diaSeguent();
		System.out.println(dataSeguent);

		System.out.println("Dia seguent al 31/12/23, últim dia de l'any");
		data = new Data(31, 12, 2023);
		dataSeguent=data.diaSeguent();
		System.out.println(dataSeguent);
	}

	// FIXAR-SE EN LA FORMA DIFERENT DE CRIDAR A diaSeguent I A diaAnterior
	// AIXÒ ÉS DEGUT A COM S'HA DEFINIT LA CAPÇALERA DEL MÈTODE.

	private static void validacioDiaAnterior() {
		System.out.println("\n\nValidació del mètode diaAnterior");
		Data data;

		System.out.println("Dia anterior al 1/3/23 en un febrer no any de traspas");
		data = new Data(1, 3, 2023);
		data.diaAnterior();
		System.out.println(data);

		System.out.println("Dia anterior al 1/3/20 en un febrer any de traspas");
		data = new Data(1, 3, 2020);
		data.diaAnterior();
		System.out.println(data);

		// afegir les validacions que falten...

	}

	private static void validacioDataEsAnyTraspas() {
		System.out.println("\n\nValidació del mètode que comprova si una data és d'un any de traspas");
		Data data;
		System.out.println("donada una data comprova si es any de traspas, any de traspas ");
		data = new Data(27, 7, 2012);
		System.out.println(data.esDataAnyTraspas());

		System.out.println("donada una data comprova si es any de traspas, no any de traspas ");
		data = new Data(27, 7, 2011);
		System.out.println(data.esDataAnyTraspas());
	}

	private static void validacioDataInferiorAltra() {
		System.out.println("\n\nValidació del mètode per comprovar si una data és inferior o igual a una altra");
		Data data, data2;

		data = new Data(27, 7, 2023);
		data2 = new Data(27, 7, 2023);
		if (data.esDataInferiorOigual(data2))
			System.out.println(data + " es inferior o igual a " + data2);
		else
			System.out.println(data2 + " es inferior o igual a " + data);

		data = new Data(27, 7, 2024);
		data2 = new Data(27, 7, 2023);
		if (data.esDataInferiorOigual(data2))
			System.out.println(data + " es inferior o igual a " + data2);
		else
			System.out.println(data2 + " es inferior o igual a " + data);

		data = new Data(29, 7, 2023);
		data2 = new Data(27, 7, 2023);
		if (data.esDataInferiorOigual(data2))
			System.out.println(data + " es inferior o igual a " + data2);
		else
			System.out.println(data2 + " es inferior o igual a " + data);
	}

	private static void validacioDiesEntreDuesDates() {
		System.out.println(
				"\n\nValidació del mètode que calcula en número de dies entre dues dates, LA DATA per paràmetre SEMPRE ES MAJOR que l'actual");
		Data data, data2;
		System.out.println("nombre de dies entre dues dates, ");
		data = new Data(27, 7, 2023);
		data2 = new Data(27, 8, 2023);
		System.out.println(data.numDiesAData(data2));

		System.out.println("nombre de dies entre dues dates, dates iguals");
		data2 = new Data(27, 7, 2023);
		System.out.println(data.numDiesAData(data2));

		System.out.println("nombre de dies entre dues dates, un any de diferencia any de traspas");
		data = new Data(27, 2, 2020);
		data2 = new Data(27, 2, 2021);
		System.out.println(data.numDiesAData(data2));
		System.out.println("nombre de dies entre dues dates, un any de diferencia no any de traspas");
		data = new Data(27, 2, 2022);
		data2 = new Data(27, 2, 2023);
		System.out.println(data.numDiesAData(data2));
		System.out.println("nombre de dies des de l'inici de la nostra era");
		data2 = new Data(1, 10, 2023);
		data = new Data(1, 1, 1);
		System.out.println(data.numDiesAData(data2));

		System.out.println(
				"nombre de dies quan la data sobre la que es crida no és inferior a la que es passa per paràmetre");
		data = new Data(27, 2, 2014);
		data2 = new Data(27, 2, 2013);
		System.out.println(data.numDiesAData(data2));
	}
}
