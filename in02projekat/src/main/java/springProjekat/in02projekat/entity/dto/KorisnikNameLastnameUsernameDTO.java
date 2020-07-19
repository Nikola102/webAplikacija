package springProjekat.in02projekat.entity.dto;

public class KorisnikNameLastnameUsernameDTO {
	private String name;
	private String surname;
	private String username;
	
	public KorisnikNameLastnameUsernameDTO() {
		// TODO Auto-generated constructor stub
	}

	public KorisnikNameLastnameUsernameDTO(String name, String surname, String username) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
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

	@Override
	public String toString() {
		return "KorisnikNameLastnameUsernameDTO [name=" + name + ", surname=" + surname + ", username=" + username
				+ "]";
	}
	
}
