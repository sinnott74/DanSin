package com.thumbwar.entityDAO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.thumbwar.entity.User;

import dansin.util.dao.impl.DaoImpl;

public class UserDAO extends DaoImpl<User> {
	
	public UserDAO(){
		super();
	}
	

	public User findByUsername(String username){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> q = cb.createQuery(User.class);
		Root<User> user = q.from(User.class);
		Predicate condition1 = cb.equal(user.get("username"), username);
		q.where(condition1);
		q.select(user);
		return em.createQuery(q).getSingleResult();
		
//		Query q = em.createQuery("SELECT u FROM User u WHERE u.username =:username");
//		q.setParameter("username", username);
//		return (User) q.getResultList().get(0);
	}
}
