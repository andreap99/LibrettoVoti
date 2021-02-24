package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib;
	
	private void run() {
		this.lib = new Libretto();
		Voto v1 = new Voto("Tecniche di programmazione", 28, LocalDate.of(2020, 06, 28));
		Voto v2 = new Voto("Analisi II", 21, LocalDate.of(2019, 02, 16));
		lib.add(v1);
		lib.add(v2);
		if(lib.add(new Voto("Fisica I", 27, LocalDate.of(2020, 06, 29)))==false) {
			System.out.println("Errore nell'inserimento di Fisica I");
		}
		lib.add(new Voto("Programmazione ad oggetti", 30, LocalDate.of(2020, 01, 30)));
		System.out.println(this.lib.estraiVotiUguali(28));
		Voto votoCercato = this.lib.cercaVoto("Fisica I");
		if(votoCercato == null) {
			System.out.println("L'esame non è stato conseguito\n");
		}else {
			System.out.println("L'esame di "+votoCercato.getNome()+" è stato conseguito con "+votoCercato.getVoto()+"\n");
		}
		
		//4. 5.
		Voto analisi2 = new Voto("Analisi II", 21, LocalDate.now());
		Voto analisi3 = new Voto("Analisi II", 23, LocalDate.now());
		System.out.println("Analisi II con 21 è duplicato: "+ lib.isDuplicato(analisi2)+"/ conflitto: "+ lib.isConflitto(analisi2));
		System.out.println("Analisi II con 24 è duplicato: "+ lib.isDuplicato(analisi3)+"/ conflitto: "+ lib.isConflitto(analisi3));
		
		//7 Migliora libretto
		Libretto migliorato = lib.creaLibrettoMigliorato();
		System.out.println("Libretto principale:\n"+lib.toString());
		System.out.println("Libretto migliorato:\n"+migliorato.toString());
		
		//8
		Libretto alfabetico = new Libretto(lib);
		alfabetico.ordinaPerCorso();
		System.out.println("Libretto in ordine alfabetico:\n"+alfabetico.toString());
		Libretto perVoto = new Libretto(lib);
		perVoto.ordinaPerVoto();
		System.out.println("Libretto in ordine di valutazione:\n"+perVoto.toString());
		
		//9
		this.lib.cancellaVotiScarsi();
		System.out.println("Libretto dopo rimozione voti scarsi:\n"+lib.toString());
	}

	public static void main(String[] args) {
		TestLibretto test = new TestLibretto();
		test.run();
	}

}
