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
public class UserService implements GenericService<Users> {
	@Autowired
	private GenericDAO<Users> genericDAO;

	@Override
	@Transactional
	public void create(Users t) {
		genericDAO.create(t);

	}

	@Override
	@Transactional
	public Users update(Users t) {
		return genericDAO.update(t);
	}

	@Override
	public Users get(Object id) {
		return genericDAO.get(id);
	}

	@Override
	public void delete(Object id) {
		genericDAO.delete(id);
	}

	@Override
	@Transactional
	public List<Users> listAll() {
		return genericDAO.listAll();
	}

	public void setGenericDAO(GenericDAO<Users> genericDAO) {
		this.genericDAO = genericDAO;
	}
	@Override
	public boolean checkLogin(String username,String password) {
		return  genericDAO.checkLogin(username, password);
	}

	@Override
	public boolean checkUser(String username) {
		return genericDAO.checkUser(username);
	}

	@Override
	public Users getDefaultRole(Object id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Users checkRole(String t) {
		// TODO Auto-generated method stub
		return genericDAO.checkRole(t);
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
		return genericDAO.updateUser(role, username);
	}

	@Override
	public boolean updateProfile(String name, String address, String dob, String gender, String phone, String email,
			 String status, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Users> listTeacher() {
		// TODO Auto-generated method stub
		return genericDAO.listTeacher();
	}

	@Override
	public List<Users> listEnrolmentOfAStudent(int userid) {
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
