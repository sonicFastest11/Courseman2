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
public class ProfileService implements GenericService<Profile> {
	@Autowired
	private GenericDAO<Profile> genericDAO;

	@Override
	@Transactional
	public void create(Profile t) {
		genericDAO.create(t);
	}

	@Override
	public Profile update(Profile t) {
		// TODO Auto-generated method stub
		return genericDAO.update(t);
	}

	@Override
	public Profile get(Object id) {
		// TODO Auto-generated method stub
		return genericDAO.get(id);
	}

	@Override
	public Profile getDefaultRole(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Profile> listAll() {
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
	public Profile checkRole(String t) {
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
		return genericDAO.getProfile(user);
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
		return genericDAO.updateProfile(name, address, dob, gender, phone, email,  status, id);
	}

	@Override
	public List<Profile> listTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profile> listEnrolmentOfAStudent(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkEnrolment(Users userid, Course courseid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkCourse(String code) {
		// TODO Auto-generated method stub
		return false;
	}

}
