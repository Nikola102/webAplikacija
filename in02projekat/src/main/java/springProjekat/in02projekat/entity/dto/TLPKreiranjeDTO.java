package springProjekat.in02projekat.entity.dto;

import java.util.Date;

public class TLPKreiranjeDTO {
	private Long idf;
	private Long ids;
	private int cena;
	private Date datum;
	
	public TLPKreiranjeDTO() {
		// TODO Auto-generated constructor stub
	}

	public TLPKreiranjeDTO(Long idf, Long ids, int cena, Date datum) {
		super();
		this.idf = idf;
		this.ids = ids;
		this.cena = cena;
		this.datum = datum;
	}

	public Long getIdf() {
		return idf;
	}

	public void setIdf(Long idf) {
		this.idf = idf;
	}

	public Long getIds() {
		return ids;
	}

	public void setIds(Long ids) {
		this.ids = ids;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
}
