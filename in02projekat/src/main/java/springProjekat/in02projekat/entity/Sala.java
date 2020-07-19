package springProjekat.in02projekat.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Sala implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int kapacitet;
	
	@Column
	private String oznaka;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Bioskop bioskop;
	
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private Set<TerminskaListaProjekcija> terminskirasporedfilm = new HashSet<>();
	
	public Sala() {
		// TODO Auto-generated constructor stub
	}

	public Sala(Long id, int kapacitet, String oznaka, Bioskop bioskop,
			Set<TerminskaListaProjekcija> terminskirasporedfilm) {
		super();
		this.id = id;
		this.kapacitet = kapacitet;
		this.oznaka = oznaka;
		this.bioskop = bioskop;
		this.terminskirasporedfilm = terminskirasporedfilm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}

	public Set<TerminskaListaProjekcija> getTerminskirasporedfilm() {
		return terminskirasporedfilm;
	}

	public void setTerminskirasporedfilm(Set<TerminskaListaProjekcija> terminskirasporedfilm) {
		this.terminskirasporedfilm = terminskirasporedfilm;
	}
	
	
}
