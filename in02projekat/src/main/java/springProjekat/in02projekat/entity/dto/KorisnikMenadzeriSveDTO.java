package springProjekat.in02projekat.entity.dto;

import java.util.HashSet;
import java.util.Set;

import springProjekat.in02projekat.entity.Bioskop;

public class KorisnikMenadzeriSveDTO {
	private Long id;
	private String name;
	private String surname;
	private String username;
	private Set<Bioskop> bioskopi = new HashSet<>();
	
	public KorisnikMenadzeriSveDTO() {
	}

	public KorisnikMenadzeriSveDTO(Long id, String name, String surname, String username, Set<Bioskop> bioskopi) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.bioskopi = bioskopi;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Bioskop> getBioskopi() {
		return bioskopi;
	}

	public void setBioskopi(Set<Bioskop> bioskopi) {
		this.bioskopi = bioskopi;
	}
	
	
}
