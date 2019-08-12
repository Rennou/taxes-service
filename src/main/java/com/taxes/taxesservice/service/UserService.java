package com.taxes.taxesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxes.taxesservice.Exception.DataNotFoundException;
import com.taxes.taxesservice.model.User;
import com.taxes.taxesservice.repo.UserRepo;

@Service
public class UserService {


	@Autowired
	UserRepo rep ;


	public User getUsre(String code , String password) throws DataNotFoundException {
		System.out.println("---");
		try {
			
			System.out.println("---"+rep.getUser(code, password));
			return rep.getUser(code, password) ;
			
		} catch (Exception  e) {
			throw new  DataNotFoundException("Enable to fetch data from User  "+e.getMessage());
		}

	}


}
