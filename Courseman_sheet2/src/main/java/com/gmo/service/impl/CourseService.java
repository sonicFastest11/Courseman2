package com.gmo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmo.dao.GenericDAO;
import com.gmo.model.Course;
import com.gmo.model.Profile;
import com.gmo.model.Role;
import com.gmo.model.Users;
import com.gmo.service.GenericService;

@Service
@Transactional
public class CourseService implements GenericService<Course> {
	@Autowired
	GenericDAO<Course> courseDAO;

	@Override
	@Transactional
	public void create(Course t) {
		courseDAO.create(t);

	}

	@Override
	public Course update(Course t) {
		// TODO Auto-generated method stub
		return courseDAO.update(t);
	}

	@Override
	public Course get(Object id) {
		// TODO Auto-generated method stub
		return courseDAO.get(id);
	}

	@Override
	public void delete(Object id) {
		courseDAO.delete(id);

	}

	@Override
	public List<Course> listAll() {
		// TODO Auto-generated method stub
		return courseDAO.listAll();
	}
	@Override
	public boolean checkCourse(String code) {
		// TODO Auto-generated method stub
		return courseDAO.checkCourse(code);
	}
	@Override
	public Course getDefaultRole(Object id) {
		// TODO Auto-generated method stub
		return null;
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
	public Course checkRole(String t) {
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
	public List<Course> listTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> listEnrolmentOfAStudent(int userid) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean checkEnrolment(Users userid, Course courseid) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
