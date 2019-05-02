package com.epita.fr.quiz.datamodel;

import javax.persistence.*;

@Entity
@Table(name="ADMIN")
public class AdminDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="U_ID")
	String userId;

	@Column(name="U_PWD")
	String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
