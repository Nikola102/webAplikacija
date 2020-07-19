package springProjekat.in02projekat.entity.dto;

import java.util.Date;

public class TLPzaKarteDTO {
	private long id;
	private String imefilma;
	private String sala;
	private String bioskop;
	private Date vreme;
	
	public TLPzaKarteDTO() {
		// TODO Auto-generated constructor stub
	}

	public TLPzaKarteDTO(long id, String imefilma, String sala, String bioskop, Date vreme) {
		super();
		this.id = id;
		this.imefilma = imefilma;
		this.sala = sala;
		this.bioskop = bioskop;
		this.vreme = vreme;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImefilma() {
		return imefilma;
	}

	public void setImefilma(String imefilma) {
		this.imefilma = imefilma;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getBioskop() {
		return bioskop;
	}

	public void setBioskop(String bioskop) {
		this.bioskop = bioskop;
	}

	public Date getVreme() {
		return vreme;
	}

	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}
	
	
}
