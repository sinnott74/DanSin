package com.thumbwar.entityDAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.thumbwar.entity.User;

import dansin.util.dao.impl.DaoImpl;

public class UserDAO extends DaoImpl<User> {
	

	public User findByUsername(String username){
		
		Query q = em.createQuery("SELECT u FROM user AS u WHERE u.username = :username", User.class);
		q.setParameter("username", username);
		return (User) q.getResultList().get(0);
	}
}
