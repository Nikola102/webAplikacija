package springProjekat.in02projekat.entity.dto;

public class KorisnikZaListuDTO {
	private Long id;
	private String name;
	private String surname;
	private String role;
	
	public KorisnikZaListuDTO() {
	}
	
	public KorisnikZaListuDTO(Long Id, String name, String surname, String role) {
		this.id = Id;
		this.name = name;
		this.surname = surname;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long Id) {
		this.id = Id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
