package springProjekat.in02projekat.entity.dto;

public class SalaDTO {
	private Long id;
	private int kapacitet;
	private String oznaka;
	private Long idb;

	public SalaDTO() {
	}

	public SalaDTO(Long id, int kapacitet, String oznaka, Long idb) {
		super();
		this.id = id;
		this.kapacitet = kapacitet;
		this.oznaka = oznaka;
		this.idb = idb;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public Long getIdb() {
		return idb;
	}

	public void setIdb(Long idb) {
		this.idb = idb;
	}
	
	
	
}
