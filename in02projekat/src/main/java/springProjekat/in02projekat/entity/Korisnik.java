package springProjekat.in02projekat.entity;


import java.io.Serializable;
import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
public class Korisnik implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String username;
	
	@Column 
	private String password;
	
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private String phonenumber;
	
	@Column 
	private String mail;
	
	@Column
	private Date birthday;
	
	@Column
	private String role;
	
	@Column
	private Boolean active;

	@ManyToMany(mappedBy = "korisnici")
	private Set <Film> odgledano = new HashSet<>();
	
	@ManyToMany(mappedBy = "buducikorisnici")
	private Set<Film> zagledati = new HashSet<Film>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Bioskop bioskop;
	
	@OneToMany(mappedBy = "korisnik")
	private Set<Ocena> ocene= new HashSet<>(); 
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Gledaoc [Id=" + Id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", surname=" + surname + ", phonenumber=" + phonenumber + ", mail=" + mail + ", birthday=" + birthday
				+ ", role=" + role + ", active=" + active + "]";
	}
	
	
}