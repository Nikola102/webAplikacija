package springProjekat.in02projekat.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class RasporedOdrzavanjaFilmova implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Film film;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Bioskop bioskop;
	
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

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
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
		return "RasporedOdrzavanjaFilmova [id=" + id + ", film=" + film + ", bioskop=" + bioskop + ", date=" + date
				+ ", cena=" + cena + "]";
	}

	
	
}
