package com.gmo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Users")
@Proxy(lazy = false)
public class Users implements Serializable {
	private static final long serialVersionUID = -2054386655979281969L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "username")
	@NotBlank(message = "required !!!")
	private String username;
	@Column(name = "password")
	@NotBlank(message = "required !!!")
	private String password;

	private String confirmPassword;

	@ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "roleid")
	private Role roleid;

	@OneToMany(mappedBy = "userid", targetEntity = Course.class)
	private Set<Course> courses;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Profile profile;

	@Transient
	private Integer idRole;

	@OneToMany(mappedBy = "user", targetEntity = Enrolment.class)
	private Set<Enrolment> enrolments;

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public Users() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Role getRoleid() {
		return roleid;
	}

	public void setRoleid(Role roleid) {
		this.roleid = roleid;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Enrolment> getEnrolments() {
		return enrolments;
	}

	public void setEnrolments(Set<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourse(Set<Course> courses) {
		this.courses = courses;
	}

}
