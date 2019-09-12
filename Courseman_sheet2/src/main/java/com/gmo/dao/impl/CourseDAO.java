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
public class CourseDAO implements GenericDAO<Course> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Course t) {
		sessionFactory.getCurrentSession().save(t);

	}

	@Override
	public Course update(Course course) {
		sessionFactory.getCurrentSession().update(course);
		return course;
	}

	@Override
	public Course get(Object id) {
		// TODO Auto-generated method stub
		return (Course) sessionFactory.getCurrentSession().get(Course.class, (Serializable) id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Course> listAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Course").list();
	}

	@Override
	public void delete(Object id) {
		Course course = (Course) sessionFactory.getCurrentSession().load(Course.class, (Serializable) id);
		if (null != course) {
			this.sessionFactory.getCurrentSession().delete(course);
		}

	}



	@Override
	public boolean checkCourse(String code) {
		String hql = "from Course c where c.code=? ";
		@SuppressWarnings("unchecked")
		List<Course> courses = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, code).list();
		if (courses.size() == 1) {
			return true;
		} else {
			return false;
		}
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

	@Override
	public Course getDefaultRole(Object id) {
		// TODO Auto-generated method stub
		return null;
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
	public Course checkRole(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(Role role, String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
