package com.taxes.taxesservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxes.taxesservice.model.User;
import com.taxes.taxesservice.repo.UserRepo;
import com.taxes.taxesservice.service.UserService;


public class UserServiceTest {
	
	

	@InjectMocks
	UserService  u ;
	
	@Mock 
	UserRepo rep ;
	
	  @Before
	    public void setUp()
	        throws Exception
	    {
	        MockitoAnnotations.initMocks( this );
	    }
	  
	  
	 
	    @Test
	    public void validateTestgetTaxe()
	    {
	    	User u = new User();
			u.setCode("txprojet");
			u.setPassword("tanis123");
			 when(rep.getUser("txprojet", "tanis123")).thenReturn(u);
			 
	    }
	  
	  
	  
	  
	    
}
