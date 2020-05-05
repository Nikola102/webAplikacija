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
	private int brojtelefona;
	
	@Column
	private String email;
	
	@OneToMany(mappedBy = "bioskop", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	private Set <Korisnik> menadzeri = new HashSet<>();
	
	@OneToMany(mappedBy = "bioskop", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Sala> sale = new HashSet<Sala>();
	//RASPORED ODRZAVANJA FILMOVA

	@OneToMany(mappedBy = "bioskop")
	private Set<RasporedOdrzavanjaFilmova> raspored = new HashSet<>();
	
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

	public int getBrojTelefona() {
		return brojtelefona;
	}

	public void setBrojTelefona(int brojTelefona) {
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
