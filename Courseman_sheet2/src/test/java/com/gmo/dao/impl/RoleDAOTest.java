package com.gmo.dao.impl;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.gmo.dao.GenericDAO;
import com.gmo.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-servlet-test.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
public class RoleDAOTest {

	@Autowired
	RoleDAO roleDAO;
	Role role;

	@Before
	public void init() {
		role = new Role();
		role.setRole_name("gg");
	}

	@Test
	public void loadByIdTest() {
		Assert.assertEquals(1, roleDAO.get(1).getId());
	}

}
