package com.gmo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmo.dao.GenericDAO;
import com.gmo.model.Course;
import com.gmo.model.Enrolment;
import com.gmo.model.Profile;
import com.gmo.model.Role;
import com.gmo.model.Users;
import com.gmo.service.GenericService;

@Service
@Transactional
public class EnrolmentService implements GenericService<Enrolment> {
	@Autowired
	GenericDAO<Enrolment> genericDAO;

	@Override
	public void create(Enrolment t) {
		genericDAO.create(t);
		
	}

	@Override
	public Enrolment update(Enrolment t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enrolment get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enrolment getDefaultRole(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object id) {
		genericDAO.delete(id);
		
	}

	@Override
	public List<Enrolment> listAll() {
		// TODO Auto-generated method stub
		return genericDAO.listAll();
	}

	@Override
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Enrolment checkRole(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkRoleName(String role_name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Profile getProfile(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(Role role, String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProfile(String name, String address, String dob, String gender, String phone, String email,
			 String status, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Enrolment> listTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enrolment> listEnrolmentOfAStudent(int userid) {
		// TODO Auto-generated method stub
		return genericDAO.listEnrolmentOfAStudent(userid);
	}


	@Override
	public boolean checkEnrolment(Users userid, Course courseid) {
		// TODO Auto-generated method stub
		return genericDAO.checkEnrolment(userid, courseid);
	}

	@Override
	public boolean checkCourse(String code) {
		// TODO Auto-generated method stub
		return false;
	}
}
