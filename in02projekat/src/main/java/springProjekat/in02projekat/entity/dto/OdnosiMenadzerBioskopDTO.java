package springProjekat.in02projekat.entity.dto;

public class OdnosiMenadzerBioskopDTO {
	private Long idb;
	private Long idm;
	public OdnosiMenadzerBioskopDTO() {
		// TODO Auto-generated constructor stub
	}
	public OdnosiMenadzerBioskopDTO(Long idb, Long idm) {
		super();
		this.idb = idb;
		this.idm = idm;
	}
	public Long getIdb() {
		return idb;
	}
	public void setIdb(Long idb) {
		this.idb = idb;
	}
	public Long getIdm() {
		return idm;
	}
	public void setIdm(Long idm) {
		this.idm = idm;
	}
	
}
