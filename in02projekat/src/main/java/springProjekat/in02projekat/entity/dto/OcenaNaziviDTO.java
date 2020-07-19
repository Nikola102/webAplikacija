package springProjekat.in02projekat.entity.dto;

public class OcenaNaziviDTO {
	String film;
	String user;
	int ocena;
	
	public OcenaNaziviDTO() {
		// TODO Auto-generated constructor stub
	}

	public OcenaNaziviDTO(String film, String user, int ocena) {
		super();
		this.film = film;
		this.user = user;
		this.ocena = ocena;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	@Override
	public String toString() {
		return "OcenaDTO [film=" + film + ", user=" + user + ", ocena=" + ocena + "]";
	}
	
	
	
}
