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
public class ProfileDAO implements GenericDAO<Profile> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Profile t) {
		sessionFactory.getCurrentSession().save(t);

	}

	@Override
	public Profile update(Profile t) {
		sessionFactory.getCurrentSession().update(t);
		return t;

	}

	@Override
	public Profile get(Object id) {
		// TODO Auto-generated method stub
		return (Profile) sessionFactory.getCurrentSession().load(Profile.class, (Serializable) id);
	}

	@SuppressWarnings("unchecked")
	public List<Profile> listAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Profile  ").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Profile getProfile(Users user) {
		Profile userProfile = null;
		String hql = "FROM Profile p WHERE p.user=:user";
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("user", user);
			List<Profile> userList = query.list();
			if (userList.size() == 1) {
				userProfile = userList.get(0);
			}
			t.commit();
			session.close();
			return userProfile;

		} catch (Exception e) {
			t.rollback();
			session.close();
		}
		return userProfile;
	}

	@Override
	public boolean updateProfile(String name, String address, String dob, String gender, String phone, String email,
			 String status, int id) {
		String hql = "update Profile p set p.name =:name , p.address = :address, p.dob = :dob, p.gender = :gender, p.phone = :phone, p.email = :email,  p.status = :status  "
				+ "where p.id =:id";
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("name", name).setParameter("address", address).setParameter("dob", dob)
					.setParameter("gender", gender).setParameter("phone", phone).setParameter("email", email)
					.setParameter("status", status).setParameter("id", id);
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
	public boolean updateUser(Role role, String username) {
		// TODO Auto-generated method stub
		return false;
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
