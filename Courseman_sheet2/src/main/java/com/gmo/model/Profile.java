package com.gmo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.gmo.validator.DateValidator;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Profile")
@Proxy(lazy=false)
public class Profile implements Serializable {
	private static final long serialVersionUID = -3465813074586302847L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="name")
	@NotBlank(message="required !!!")
	private String name;
	@Column
	private String address;
	@DateValidator
	@Column
	private String dob;
	@Column
	@Pattern(regexp= "Nam|nam|nu|Nu")
	@NotNull
	private String gender;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String status;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	private Users user;
	
	

	public Profile() {
	}

	public Profile(String name, String address, String dob, String gender, String phone, String email, 
			String status, Users user) {
		super();
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.user = user;
	}

	public Profile(String name,String dob, String gender, Users user) {
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
