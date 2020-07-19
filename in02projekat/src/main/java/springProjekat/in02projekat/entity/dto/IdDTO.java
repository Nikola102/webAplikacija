package springProjekat.in02projekat.entity.dto;

public class IdDTO {
	private Long id;
	public IdDTO() {
	}
	public IdDTO(Long id) {
		System.out.println("korisnik id sa parametrom");
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
