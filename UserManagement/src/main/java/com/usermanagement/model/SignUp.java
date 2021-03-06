package com.usermanagement.model;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;


@Document(collection="signup")
public class SignUp {
	@Override
	public String toString() {
		return "SignUp [id=" + id + ", name=" + name + ", emailId=" + emailId + ", contact=" + contact + ", username="
				+ username + ", password=" + password + ", confirmpassword=" + confirmpassword + "]";
	}
	@Id
	private Long id;
	@NotEmpty(message="name should not be empty")
	private String name;
	@Email(message = "not a valid email")
	@NotEmpty(message="email should not be empty")
	private String emailId;
	@NotNull(message="contact should not be empty")
	private int contact;
	@NotEmpty(message="username should not be empty")
	private String username;
	@NotEmpty(message="password should not be empty")
	private String password;
	@NotEmpty(message="confirmpassword should not be empty")
	private String confirmpassword;
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}


	public SignUp( String name, String emailId, int contact, String username, String password,
			String confirmpassword) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.contact = contact;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}
	
	
	public SignUp() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
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
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	

}
