package com.gmo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmo.dao.GenericDAO;
import com.gmo.model.Course;
import com.gmo.model.Profile;
import com.gmo.model.Role;
import com.gmo.model.Users;

@Repository
public class UserDAO implements GenericDAO<Users> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Users t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public Users update(Users t) {
		sessionFactory.getCurrentSession().update(t);
		return t;
	}

	@Override
	public Users get(Object id) {
		return (Users) sessionFactory.getCurrentSession().load(Users.class, (Serializable) id);
	}

	@Override
	public void delete(Object id) {
		Users user = (Users) sessionFactory.getCurrentSession().load(Users.class, (Serializable) id);
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Users> listAll() {
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	@Override
	public boolean checkLogin(String username, String password) {
		String hql = "from Users where username=? and password=?";
		@SuppressWarnings("unchecked")
		List<Users> users = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, username)
				.setParameter(1, password).list();
		if (users.size() == 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean checkUser(String username) {
		String hql = "from Users u where u.username=? ";
		@SuppressWarnings("unchecked")
		List<Users> users = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, username).list();
		if (users.size() == 1) {
			return true;
		} else {
			return false;
		}

	}


	@Override
	public Users checkRole(String username) {
		String hql = "FROM Users u where u.username = ?";
		Users user = null;
		@SuppressWarnings("unchecked")
		List<Users> results = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, username).list();
		if (results.size() == 1) {
			user = results.get(0);
		}
		return user;
	}


	@Override
	public boolean updateUser(Role role, String username) {
		String hql = "update Users u set u.roleid =:role where u.username =:username";

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("role", role).setParameter("username", username);
			query.executeUpdate();
			t.commit();
			session.close();
			return true;

		} catch (Exception e) {
			t.rollback();
			session.close();
			return false;

		}
	}

	@SuppressWarnings("unchecked")
	public List<Users> listTeacher() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Users u where u.roleid=3").list();
	}

	@Override
	public boolean updateProfile(String name, String address, String dob, String gender, String phone, String email,
			 String status, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Users> listEnrolmentOfAStudent(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getDefaultRole(Object id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean checkEnrolment(Users userid, Course courseid) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean checkCourse(String code) {
		// TODO Auto-generated method stub
		return false;
	}
}
