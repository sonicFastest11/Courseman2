	package com.gmo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmo.dao.GenericDAO;
import com.gmo.model.Course;
import com.gmo.model.Enrolment;
import com.gmo.model.Profile;
import com.gmo.model.Role;
import com.gmo.model.Users;

@Repository
public class EnrolmentDAO implements GenericDAO<Enrolment> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Enrolment t) {
		sessionFactory.getCurrentSession().save(t);

	}

	@Override
	public void delete(Object id) {
		Enrolment enrol = (Enrolment) sessionFactory.getCurrentSession().load(Enrolment.class, (Serializable) id);
		if (null != enrol) {
			this.sessionFactory.getCurrentSession().delete(enrol);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Enrolment> listAll() {
		return sessionFactory.getCurrentSession().createQuery("From Enrolment").list();
	}

	@SuppressWarnings("unchecked")
	public List<Enrolment> listEnrolmentOfAStudent(int userid) {
		return sessionFactory.getCurrentSession().createQuery("From Enrolment where userid=?").setParameter(0, userid)
				.list();
	}

	@Override
	public boolean checkEnrolment(Users userid, Course courseid) {
		String hql = "from Enrolment where userid=? and courseid=?";
		@SuppressWarnings("unchecked")
		List<Users> users = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, userid)
				.setParameter(1, courseid).list();
		if (users.size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Profile getProfile(Users user) {
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
	public boolean checkRoleName(String role_name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Enrolment checkRole(String t) {
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
	public boolean checkCourse(String code) {
		// TODO Auto-generated method stub
		return false;
	}

}
