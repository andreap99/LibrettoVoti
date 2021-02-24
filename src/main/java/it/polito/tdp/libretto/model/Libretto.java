package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti = new ArrayList<>();

	public Libretto() {
		
	}

	public Libretto(Libretto lib) {//copy constructor
		this.voti.addAll(lib.voti);
	}
	
	public boolean add(Voto v) {
		if(this.isDuplicato(v) || this.isConflitto(v)) {
			//non inserire il voto
			return false;
		}else {
			voti.add(v);
			return true;
		}
		
	}
	
	public String stampaVotiUguali(int voto) {
		String s = "";
		for(Voto v : this.voti) {
			if(v.getVoto()==voto) {
				s += v.toString() + "\n";
			}
		}
		return s;
	}
	
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti) {
			if(v.getVoto()==voto) {
				nuovo.add(v);
			}
		}
		return nuovo;
	}
	
	public Libretto creaLibrettoMigliorato() {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti) {
			//Voto v2 = new Voto(v);
			Voto v2 = v.clone();
			if(v2.getVoto()>=24) {
				v2.setVoto(v2.getVoto()+2);
				if(v2.getVoto()>30)
					v2.setVoto(30);
			}else if(v2.getVoto()>=18 && v2.getVoto()<24){
				v2.setVoto(v2.getVoto()+1);
			}
			
			nuovo.add(v2);
		}
		return nuovo;
	}
	
	public Voto cercaVoto(String nomeCorso) {
		for(Voto v : this.voti) {
			if(v.getNome().equals(nomeCorso)) {
				return v;
			}
		}
		return null;
	}
	
	public boolean isDuplicato(Voto v) {
		Voto esiste = this.cercaVoto(v.getNome());
		if(esiste == null)
			return false;
		return (esiste.getVoto() == v.getVoto());
	}
	
	public boolean isConflitto(Voto v) {
		Voto esiste = this.cercaVoto(v.getNome());
		if(esiste == null)
			return false;
		return (esiste.getVoto() != v.getVoto());
	}
	
	public String toString() {
		String s = "";
		for(Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		return s;
	}
	
	public void ordinaPerCorso() {
		Collections.sort(this.voti);
	}
	
	public void ordinaPerVoto() {
		//Collections.sort(this.voti, new ConfrontaVotiPerValutazione());
		this.voti.sort(new ConfrontaVotiPerValutazione());
	}
	
	public void cancellaVotiScarsi() {// se < 24
		List<Voto> daRimuovere = new ArrayList<>();
		for(Voto v : this.voti) {
			if(v.getVoto()<24) {
				daRimuovere.add(v);
			}
		}
		this.voti.removeAll(daRimuovere);
		//for(Voto v : daRimuovere) {
			//this.voti.remove(v);
		//}
	}
	
}
