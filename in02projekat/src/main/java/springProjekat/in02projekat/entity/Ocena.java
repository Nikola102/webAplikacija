package springProjekat.in02projekat.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Ocena implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Korisnik korisnik;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Film film;
	
	@Column
	private int dataocena;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public int getDataocena() {
		return dataocena;
	}

	public void setDataocena(int dataocena) {
		this.dataocena = dataocena;
	}

	@Override
	public String toString() {
		return "Ocena [id=" + id + ", korisnik=" + korisnik + ", film=" + film + ", dataocena=" + dataocena + "]";
	}

	

	
}
