package springProjekat.in02projekat.entity.dto;

public class BioskopZaListuDTO {
	private Long id;
	private String naziv;
	private String adresa;
	private String brojtelefona;
	private String email;
	
	public BioskopZaListuDTO() {
		// TODO Auto-generated constructor stub
	}

	public BioskopZaListuDTO(Long id, String naziv, String adresa, String brojtelefona, String email) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojtelefona = brojtelefona;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojtelefona() {
		return brojtelefona;
	}

	public void setBrojtelefona(String brojtelefona) {
		this.brojtelefona = brojtelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
