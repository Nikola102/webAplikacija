package springProjekat.in02projekat.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class RasporedOdrzavanjaFilmova implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int idfilm;
	
	@Column
	private int idbioskop;
	
	@Column
	private Date date;
	
	@Column 
	private int cena;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public int getIdfilm() {
		return idfilm;
	}

	public void setIdfilm(int idfilm) {
		this.idfilm = idfilm;
	}

	public int getIdbioskop() {
		return idbioskop;
	}

	public void setIdbioskop(int idbioskop) {
		this.idbioskop = idbioskop;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "RasporedOdrzavanjaFilmova [id=" + id + ", idfilm=" + idfilm + ", idbioskop=" + idbioskop + ", date="
				+ date + ", cena=" + cena + "]";
	}


	
}
