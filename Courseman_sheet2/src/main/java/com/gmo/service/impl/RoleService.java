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
public class RoleService implements GenericService<Role> {
	@Autowired
	private GenericDAO<Role> genericDAO;

	@Override
	public void create(Role t) {
		genericDAO.create(t);
	}

	@Override
	@Transactional
	public Role update(Role t) {
		return genericDAO.update(t);
	}

	@Override
	public Role get(Object id) {
		return genericDAO.get(id);
	}

	@Override
	public void delete(Object id) {
		genericDAO.delete(id);
	}

	@Override
	@Transactional
	public List<Role> listAll() {
		return genericDAO.listAll();
	}

	public void setDao(GenericDAO<Role> dao) {
		this.genericDAO = dao;
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
	public Role getDefaultRole(Object id) {
		// TODO Auto-generated method stub
		return genericDAO.getDefaultRole(id);
	}


	@Override
	public Role checkRole(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkRoleName(String role_name) {
		// TODO Auto-generated method stub
		return genericDAO.checkRoleName(role_name);
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
	public List<Role> listTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> listEnrolmentOfAStudent(int userid) {
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
