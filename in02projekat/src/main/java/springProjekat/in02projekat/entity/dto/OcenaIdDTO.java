package springProjekat.in02projekat.entity.dto;

public class OcenaIdDTO {
	Long idf;
	Long idk;
	int ocena;
	
	public OcenaIdDTO() {
		// TODO Auto-generated constructor stub
	}

	public OcenaIdDTO(Long idf, Long idk, int ocena) {
		super();
		this.idf = idf;
		this.idk = idk;
		this.ocena = ocena;
	}

	public Long getIdf() {
		return idf;
	}

	public void setIdf(Long idf) {
		this.idf = idf;
	}

	public Long getIdk() {
		return idk;
	}

	public void setIdk(Long idk) {
		this.idk = idk;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	@Override
	public String toString() {
		return "OcenaIdDTO [idf=" + idf + ", idk=" + idk + ", ocena=" + ocena + "]";
	}
	
	
	
	
}
