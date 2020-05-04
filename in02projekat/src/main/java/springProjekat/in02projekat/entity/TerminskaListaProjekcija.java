package springProjekat.in02projekat.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class TerminskaListaProjekcija implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int idfilm;
	
	@Column
	private int idbioskop;
	
	@Column
	private int idsala;
	
	@Column
	private Date date;
	
	@Column
	private int brrezervacija;

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

	public int getIdsala() {
		return idsala;
	}

	public void setIdsala(int iddala) {
		this.idsala = iddala;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getBrrezervacija() {
		return brrezervacija;
	}

	public void setBrrezervacija(int brrezervacija) {
		this.brrezervacija = brrezervacija;
	}

	@Override
	public String toString() {
		return "TerminskaListaProjekcija [id=" + id + ", idfilm=" + idfilm + ", idbioskop=" + idbioskop + ", idsala="
				+ idsala + ", date=" + date + ", brrezervacija=" + brrezervacija + "]";
	}

	
	
}
