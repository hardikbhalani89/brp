package com.brp.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity  
@Table(name="usermaster")  
public class UserBean {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="profilepic")
	private String profilePic;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname; 
	@Column(name="mobileno")
	private String mobileno; 
	@Transient
	private List<MultipartFile> fileField;
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public List<MultipartFile> getFileField() {
		return fileField;
	}

	public void setFileField(List<MultipartFile> fileField) {
		this.fileField = fileField;
	}
	
}
