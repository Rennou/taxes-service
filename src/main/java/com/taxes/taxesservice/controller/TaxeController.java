package com.taxes.taxesservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxes.api.TaxeApi;
import com.taxes.model.Taxe;
import com.taxes.model.User;
import com.taxes.taxesservice.Exception.MapperException;
import com.taxes.taxesservice.service.TaxeService;
import com.taxes.taxesservice.service.UserService;


@RestController
@RequestMapping(value = "/taxes")
public class TaxeController implements TaxeApi {

	@Autowired
	TaxeService service ;

	@Autowired 
	ObjectMapper jsonMapper;

	@Autowired 
	UserService userService;


	
	
	
	@GetMapping(value="/test")
	public ResponseEntity<?>  getTx() {
		
		
		return  new  ResponseEntity<>("hello",HttpStatus.OK);
		
	}
	
	
	
	
	@Override
	public ResponseEntity<Taxe> 
	getTaxetByProvince(String securityHeader ,String province )  {

		Taxe  t = null;
		User u = null;
		try 
		{
			u = jsonMapper.readValue(securityHeader, User.class);
		} catch (Exception  e) {
			;

		}
		
	  userService.getUsre(u.getCode(), u.getPassword());
		t = service.getTaxe(province) ;

		return new  ResponseEntity<Taxe>(t,HttpStatus.OK);
	}


	@Override
	public ResponseEntity<Void> addTaxe(String securityHeader,String province , Taxe tx ) {
		User u  ;

		try 
		{
			u = jsonMapper.readValue(securityHeader, User.class);
		} catch (Exception  e) {
			throw new  MapperException(e.getMessage());

		}
		
		
		userService.getUsre(u.getCode(), u.getPassword());
		service.addTaxe(tx, province);
		return new  ResponseEntity<>(null,HttpStatus.CREATED);
	}
}

