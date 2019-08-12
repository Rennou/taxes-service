package com.taxes.taxesservice.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.taxes.taxesservice.model.User;

@Repository
public class UserRepo {

	@PersistenceContext
	private EntityManager em;
	
	
	public User getUser(String code ,String password) {
		
		return  (User)em.createQuery("select u from User u where u.code = :code and u.password =:password")
				.setParameter("code", code).
				setParameter("password", password).getSingleResult();
		
	}
	
}
