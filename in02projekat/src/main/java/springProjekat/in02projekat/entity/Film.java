package springProjekat.in02projekat.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Film implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private String opis;
	
	@Column
	private String zanr;
	
	@Column
	private int trajanje;
		
	@Column
	private double srednjaocena;
	
	@ManyToMany
	@JoinTable(name = "Odgledani_filmovi" ,
			joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
		    inverseJoinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
			)
	private Set<Korisnik> korisnici = new HashSet<Korisnik>();
	
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
	private Set<RasporedOdrzavanjaFilmova> raspored = new HashSet<>();
	
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
	private Set<TerminskaListaProjekcija> terminskirasporedfilm = new HashSet<>();
	
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
	private Set<Ocena> ocene= new HashSet<>(); 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
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

	public double getSrednjaocena() {
		return srednjaocena;
	}

	public void setSrednjaocena(double srednjaocena) {
		this.srednjaocena = srednjaocena;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", zanr=" + zanr + ", trajanje=" + trajanje
				 + ", srednjaocena=" + srednjaocena + "]";
	}

	
	
}
