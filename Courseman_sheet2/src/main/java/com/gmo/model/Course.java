package com.gmo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotBlank;

import com.gmo.validator.DateValidator;

@Entity
@Table(name = "course")
@Proxy(lazy = false)
public class Course implements Serializable {
	private static final long serialVersionUID = -3465813074586302847L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "code")
	@NotBlank(message = "required !!!")
	private String code;
	@Column(name = "name")
	@NotBlank(message = "required !!!")
	private String name;
	@Column(name = "time")
	@NotBlank(message = "required !!!")
	private String time;

	@Column(name = "fee")
	@NotBlank(message = "required !!!")
	private String fee;
	@Column(name = "startDate")
	@DateValidator
	private String startDate;
	@Column(name = "endDate")
	@DateValidator
	private String endDate;
	@Column(name = "type")
	private String type;

	@ManyToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private Users userid;

	@Transient
	private Integer idUser;

	@OneToMany(mappedBy = "course", targetEntity = Enrolment.class)
	private Set<Enrolment> enrolments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

//	public String getTeacher() {
//		return teacher;
//	}
//
//	public void setTeacher(String teacher) {
//		this.teacher = teacher;
//	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Enrolment> getEnrolments() {
		return enrolments;
	}

	public void setEnrolments(Set<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}

	public Users getUserid() {
		return userid;
	}

	public void setUserid(Users userid) {
		this.userid = userid;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	

//	public Set getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set users) {
//		this.users = users;
//	}

}
