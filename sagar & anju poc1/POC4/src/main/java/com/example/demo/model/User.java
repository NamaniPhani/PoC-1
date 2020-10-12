package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//	@Pattern(regexp = "/^[a-zA-Z0-9]+$/{3-30}", message = "UserName already exits in database.")
//	@Column(unique = true)
	private String userName;

	public User() {
//		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + "]";
	}

}
