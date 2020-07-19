package springProjekat.in02projekat.entity.dto;

public class KorisnikLogovanjeDTO {
	private String username;
	private String password;
	
	public KorisnikLogovanjeDTO() {
	}
	
	public KorisnikLogovanjeDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
