package springProjekat.in02projekat.entity.dto;


public class BioskopDTO {

	private String naziv;
	private String adresa;
	private String brojtelefona;
	private String email;
	private String menadzerusername;
	
	public BioskopDTO() {
		System.out.println("Iz bioskopDTO bez parametara");
	}

	public BioskopDTO(String naziv, String adresa, String brojtelefona, String email, String menadzerusername) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojtelefona = brojtelefona;
		this.email = email;
		this.menadzerusername = menadzerusername;
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

	public String getmenadzerusername() {
		return menadzerusername;
	}

	public void setmenadzerUsername(String menadzerusername) {
		this.menadzerusername = menadzerusername;
	}
	
	
}
