package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto implements Comparable<Voto>{
	
	private String nome; //tdp
	private int voto; //28
	private LocalDate data; //15/06/2020
	
	public Voto(String nome, int voto, LocalDate data) {
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}
	
	public Voto(Voto v) {//copy constructor -> crea un nuovo voto uguale a se stesso
		this.nome = v.nome;
		this.voto = v.voto;
		this.data = v.data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return nome + "  " + voto + "  " + data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public Voto clone() {
		Voto v = new Voto(this.nome, this.voto, this.data);
		return v;
	}

	@Override
	public int compareTo(Voto o) {
		/*<0 se this < other
		 * >0 se this > other
		 * ==0 se this == other
		 */
		return this.nome.compareTo(o.nome);
	}
}
