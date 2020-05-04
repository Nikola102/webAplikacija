package springProjekat.in02projekat.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Ocena implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int idgledaoc;
	
	@Column
	private int idfilm;
	
	@Column
	private int dataocena;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdgledaoc() {
		return idgledaoc;
	}

	public void setIdgledaoc(int idgledaoc) {
		this.idgledaoc = idgledaoc;
	}

	public int getIdFilm() {
		return idfilm;
	}

	public void setIdFilm(int idgilm) {
		this.idfilm = idgilm;
	}

	public int getDataocena() {
		return dataocena;
	}

	public void setDataocena(int dataocena) {
		this.dataocena = dataocena;
	}

	@Override
	public String toString() {
		return "Ocena [id=" + id + ", idgledaoc=" + idgledaoc + ", idfilm=" + idfilm + ", dataocena=" + dataocena + "]";
	}

	
}
