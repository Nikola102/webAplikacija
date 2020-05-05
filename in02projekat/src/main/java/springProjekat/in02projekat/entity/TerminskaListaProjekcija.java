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
	
	@ManyToMany(mappedBy = "terminskirasporedfilm")
	private Set <Film> filmoviProjekcija = new HashSet<>();
	
	
	@ManyToMany(mappedBy = "terminskirasporedsala")
	private Set <Sala> salaProjekcija = new HashSet<>();
	
	@Column
	private Date date;
	
	@Column
	private int brrezervacija;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
