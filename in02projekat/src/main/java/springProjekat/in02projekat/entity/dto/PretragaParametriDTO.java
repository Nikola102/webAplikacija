package springProjekat.in02projekat.entity.dto;

import java.util.Date;

public class PretragaParametriDTO {
	private String naziv;
	private String zanr;
	private int cena;
	private int tipSortiranja;
	private Date datum;

	public PretragaParametriDTO() {
		// TODO Auto-generated constructor stub
	}

	public PretragaParametriDTO(String naziv, String zanr, int cena, int tipSortiranja, Date datum) {
		super();
		this.naziv = naziv;
		this.zanr = zanr;
		this.cena = cena;
		this.tipSortiranja = tipSortiranja;
		this.datum = datum;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getTipSortiranja() {
		return tipSortiranja;
	}

	public void setTipSortiranja(int tipSortiranja) {
		this.tipSortiranja = tipSortiranja;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "PretragaParametriDTO [naziv=" + naziv + ", zanr=" + zanr + ", cena=" + cena + ", tipSortiranja="
				+ tipSortiranja + ", datum=" + datum + "]";
	}
	
	
}
