package springProjekat.in02projekat.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
public class TerminskaListaProjekcija implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Film film;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Sala sala;

	
	@ManyToMany
	@JoinTable(name = "Biti_odgledani",
			joinColumns = @JoinColumn (name = "projekcija_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
			)
	private Set<Korisnik> buducikorisnici = new HashSet<Korisnik>();
	
	@Column
	private int Cena;
	
	@Column
	private int brrezervacija;
	
	@Column
	private Date date;
	
	
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

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Set<Korisnik> getBuducikorisnici() {
		return buducikorisnici;
	}

	public void setBuducikorisnici(Set<Korisnik> buducikorisnici) {
		this.buducikorisnici = buducikorisnici;
	}

	public int getCena() {
		return Cena;
	}

	public void setCena(int cena) {
		Cena = cena;
	}

	public int getBrrezervacija() {
		return brrezervacija;
	}

	public void setBrrezervacija(int brrezervacija) {
		this.brrezervacija = brrezervacija;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TerminskaListaProjekcija [id=" + id + ", film=" + film + ", sala=" + sala + ", buducikorisnici="
				+ buducikorisnici + ", Cena=" + Cena + ", brrezervacija=" + brrezervacija + ", date=" + date + "]";
	}
	
	
}
