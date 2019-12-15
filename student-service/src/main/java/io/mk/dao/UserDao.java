package io.mk.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.mk.model.LoginUser;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public LoginUser findByUserName(String username) {
		List<LoginUser> users = new ArrayList<>();
		users = getSessionFactory().getCurrentSession().createQuery("from LoginUser where username=?")
				.setParameter(0, username).list();
		return users.size() > 0 ? users.get(0) : null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}