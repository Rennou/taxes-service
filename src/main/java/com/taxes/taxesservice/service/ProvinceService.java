package com.taxes.taxesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxes.taxesservice.Exception.DataNotFoundException;
import com.taxes.taxesservice.model.Province;
import com.taxes.taxesservice.repo.ProvinceRepo;

@Service
public class ProvinceService {
	
	@Autowired
	ProvinceRepo rep ;

	public  Province getProvince(String province) {
		try {
			return rep.getProvince(province);
			
		} catch (Exception  e) {
			throw new  DataNotFoundException("Enable to fetch data from Province  "+e.getMessage());
		}
	}

	
}
