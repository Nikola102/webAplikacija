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
	
	@ManyToMany
	@JoinTable(name = "TerminskiRaporedSala",
				joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name= "lista_id",referencedColumnName = "id")
				)
	private Set<TerminskaListaProjekcija> terminskirasporedsala = new HashSet<>();
}
