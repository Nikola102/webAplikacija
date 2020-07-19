package springProjekat.in02projekat.entity.dto;

import java.util.Date;

public class KorisnikDTO {
	private Long id;
	private String name;
	private String surname;
	private String phonenumber;
	private String username;
	private String password;
	private String mail;
	private Date birthday;
	private String role;
	
	public KorisnikDTO(){
	}	
	
	public KorisnikDTO(Long id, String username, String password, String name, String surname, String phonenumber,
			String mail, String role ,Date birthday) {
		System.out.println("Poruka iz korisnikDTO");
		System.out.println(username);
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.mail = mail;
		this.birthday = birthday;
		this.role = role;
	}
	
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/*public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}*/
	
	
	
}

