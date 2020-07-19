package springProjekat.in02projekat.entity.dto;

public class OcenaKompletDTO {
	Long ido;
	Long idf;	
	Long idk;
	String username;
	String film;
	int ocena;
	
	public OcenaKompletDTO() {
		// TODO Auto-generated constructor stub
	}

	public OcenaKompletDTO(Long ido, Long idf, Long idk, String username, String film, int ocena) {
		super();
		this.ido = ido;
		this.idf = idf;
		this.idk = idk;
		this.username = username;
		this.film = film;
		this.ocena = ocena;
	}
	
	
	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Long getIdo() {
		return ido;
	}

	public void setIdo(Long ido) {
		this.ido = ido;
	}

	public Long getidf() {
		return idf;
	}

	public void setidf(Long idf) {
		this.idf = idf;
	}

	public Long getIdk() {
		return idk;
	}

	public void setIdk(Long idk) {
		this.idk = idk;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}
	
	
	
}
