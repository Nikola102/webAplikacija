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
	
	public Ocena() {
		// TODO Auto-generated constructor stub
	}

	public Ocena(Long id, Korisnik korisnik, Film film, int dataocena) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.film = film;
		this.dataocena = dataocena;
	}

	public Ocena(Korisnik korisnik, Film film, int dataocena) {
		super();
		this.korisnik = korisnik;
		this.film = film;
		this.dataocena = dataocena;
	}

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
