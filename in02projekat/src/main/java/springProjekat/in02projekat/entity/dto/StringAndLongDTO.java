package springProjekat.in02projekat.entity.dto;

public class StringAndLongDTO {
	private String string;
	private Long number;
	public StringAndLongDTO() {
		// TODO Auto-generated constructor stub
	}
	public StringAndLongDTO(String string, Long number) {
		super();
		this.string = string;
		this.number = number;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "StringAndLongDTO [string=" + string + ", number=" + number + "]";
	}
	
}
