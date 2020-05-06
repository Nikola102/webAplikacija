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
	
}
