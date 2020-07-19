package springProjekat.in02projekat.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Bioskop implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private String adresa;
	
	@Column
	private String brojtelefona;
	
	@Column
	private String email;
	
	@ManyToMany
	@JoinTable(name = "menadzment" ,
			joinColumns = @JoinColumn(name = "bioskop_id", referencedColumnName = "id"),
		    inverseJoinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
			)
	private Set<Korisnik> menadzeri = new HashSet<Korisnik>();

	
	@OneToMany(mappedBy = "bioskop", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Sala> sale = new HashSet<Sala>();

	//@OneToMany(mappedBy = "bioskop")
	//private Set<RasporedOdrzavanjaFilmova> raspored = new HashSet<>();
	
	public Bioskop() {
	}
	
	public Bioskop(String naziv, String adresa, String brojtelefona, String email) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojtelefona = brojtelefona;
		this.email = email;
	}

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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojtelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojtelefona = brojTelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Korisnik> getMenadzeri() {
		return menadzeri;
	}

	public void setMenadzeri(Set<Korisnik> menadzeri) {
		this.menadzeri = menadzeri;
	}

	public Set<Sala> getSale() {
		return sale;
	}

	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}

	@Override
	public String toString() {
		return "Bioskop [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", brojTelefona=" + brojtelefona
				+ ", email=" + email + ", menadzeri=" + menadzeri + ", sale=" + sale + "]";
	}
	
	
	
}
