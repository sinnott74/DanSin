package com.thumbwar.entityDAO;

import javax.persistence.Query;

import com.thumbwar.entity.User;

import dansin.util.dao.impl.DaoImpl;

public class UserDAO extends DaoImpl<User> {
	
	public UserDAO(){
		super();
	}
	

	public User findByUsername(String username){
		
		
		Query q = em.createQuery("SELECT u FROM User u WHERE u.username =:username");
		q.setParameter("username", username);
		return (User) q.getResultList().get(0);
	}
}
