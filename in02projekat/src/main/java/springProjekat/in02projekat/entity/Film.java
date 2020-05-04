package springProjekat.in02projekat.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Film implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private String opis;
	
	@Column
	private String zanr;
	
	@Column
	private int trajanje;
	
	@Column
	private int brojocena;
	
	@Column
	private double srednjaocena;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public int getBrojocena() {
		return brojocena;
	}

	public void setBrojocena(int brojocena) {
		this.brojocena = brojocena;
	}

	public double getSrednjaocena() {
		return srednjaocena;
	}

	public void setSrednjaocena(double srednjaocena) {
		this.srednjaocena = srednjaocena;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", zanr=" + zanr + ", trajanje=" + trajanje
				+ ", brojocena=" + brojocena + ", srednjaocena=" + srednjaocena + "]";
	}

	
	
}
