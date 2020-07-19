package springProjekat.in02projekat.entity.dto;

import java.util.Date;

public class PretragaPovratnaDTO {
	private String naziv;
	private Date vreme;
	private int cena;
	private String zanr;
	private int trajanje;
	private String bioskopNaziv;
	private String salaOznaka;
	private int preostalaMesta;
	private double srednjaOcena;
	private boolean odgovara;
	private Long idtlp;
	
	
	public PretragaPovratnaDTO() {
		// TODO Auto-generated constructor stub
	}

	

	
	
	public PretragaPovratnaDTO(String naziv, Date vreme, int cena, String zanr, int trajanje, String bioskopNaziv,
			String salaOznaka, int preostalaMesta, double srednjaOcena, boolean odgovara, Long idtlp) {
		super();
		this.naziv = naziv;
		this.vreme = vreme;
		this.cena = cena;
		this.zanr = zanr;
		this.trajanje = trajanje;
		this.bioskopNaziv = bioskopNaziv;
		this.salaOznaka = salaOznaka;
		this.preostalaMesta = preostalaMesta;
		this.srednjaOcena = srednjaOcena;
		this.odgovara = odgovara;
		this.idtlp = idtlp;
	}

	
	
	public Long getIdtlp() {
		return idtlp;
	}

	public void setIdtlp(Long idtlp) {
		this.idtlp = idtlp;
	}

	public boolean isOdgovara() {
		return odgovara;
	}

	public void setOdgovara(boolean odgovara) {
		this.odgovara = odgovara;
	}

	public double getSrednjaOcena() {
		return srednjaOcena;
	}

	public void setSrednjaOcena(double srednjaOcena) {
		this.srednjaOcena = srednjaOcena;
	}

	public int getPreostalaMesta() {
		return preostalaMesta;
	}

	public void setPreostalaMesta(int preostalaMesta) {
		this.preostalaMesta = preostalaMesta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Date getVreme() {
		return vreme;
	}

	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
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

	public String getBioskopNaziv() {
		return bioskopNaziv;
	}

	public void setBioskopNaziv(String bioskopNaziv) {
		this.bioskopNaziv = bioskopNaziv;
	}

	public String getSalaOznaka() {
		return salaOznaka;
	}

	public void setSalaOznaka(String salaOznaka) {
		this.salaOznaka = salaOznaka;
	}

	public void setWithOther(PretragaPovratnaDTO info) {
		this.setBioskopNaziv(info.getBioskopNaziv());
		this.setCena(info.getCena());
		this.setNaziv(info.getNaziv());
		this.setOdgovara(info.isOdgovara());
		this.setPreostalaMesta(info.getPreostalaMesta());
		this.setSalaOznaka(info.getSalaOznaka());
		this.setSrednjaOcena(info.getSrednjaOcena());
		this.setTrajanje(info.getTrajanje());
		this.setVreme(info.getVreme());
		this.setZanr(info.getZanr());
		this.setIdtlp(info.getIdtlp());
	}
	
	@Override
	public String toString() {
		return "PretragaPovratnaDTO [naziv=" + naziv + ", vreme=" + vreme + ", cena=" + cena + ", zanr=" + zanr
				+ ", trajanje=" + trajanje + ", bioskopNaziv=" + bioskopNaziv + ", salaOznaka=" + salaOznaka
				+ ", preostalaMesta=" + preostalaMesta + ", srednjaOcena=" + srednjaOcena + ", odgovara=" + odgovara
				+ "]";
	}
	
	
	
}
