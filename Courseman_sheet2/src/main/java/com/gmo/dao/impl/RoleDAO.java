package com.gmo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmo.dao.GenericDAO;
import com.gmo.model.Course;
import com.gmo.model.Profile;
import com.gmo.model.Role;
import com.gmo.model.Users;

@Repository
public class RoleDAO implements GenericDAO<Role> {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Role> listAll() {

		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}

	@Override
	public void create(Role t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);

	}

	@Override
	public Role update(Role t) {
		sessionFactory.getCurrentSession().update(t);
		return t;
	}

	@Override
	public Role get(Object id) {

		return (Role) sessionFactory.getCurrentSession().get(Role.class, (Serializable) id);
	}

	@Override
	public void delete(Object id) {
		Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, (Serializable) id);
		if (null != role) {
			this.sessionFactory.getCurrentSession().delete(role);
		}

	}

	@Override
	public boolean checkRoleName(String role_name) {
		String hql = "from Role r where r.role_name=? ";
		@SuppressWarnings("unchecked")
		List<Role> roles = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, role_name).list();
		if (roles.size() == 1) {
			return true;
		} else {
			return false;
		}
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
		return (Role) sessionFactory.getCurrentSession().get(Role.class, (Serializable) 4);
	}

	@Override
	public Role checkRole(String t) {
		// TODO Auto-generated method stub
		return null;
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
