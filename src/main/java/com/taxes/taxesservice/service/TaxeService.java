package com.taxes.taxesservice.service;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxes.taxesservice.Exception.DataNotFoundException;
import com.taxes.taxesservice.Exception.PersistentDataException;
import com.taxes.taxesservice.mapper.TaxeMapper;
import com.taxes.taxesservice.model.Taxe;
import com.taxes.taxesservice.repo.TaxeRepo;



@Service
public class TaxeService {

	@Autowired
	TaxeRepo rep ;
	@Autowired
	ProvinceService ProvinceService ;
	@Autowired 
	TaxeMapper mapper ;


	public com.taxes.model.Taxe getTaxe(String province) throws DataNotFoundException
	{
		try {

			return  mapper.toTaxe(rep.getTaxe(province));

		} catch (Exception  e) {
			throw new  DataNotFoundException("Enable to fetch Taxe from  province  =  "+province +"\n Error message :"+e.getMessage());
		}
	}



	public void addTaxe(com.taxes.model.Taxe t, String province)
	{		
		Taxe tx = new Taxe();
		tx.setDateTx(new Date());
		tx.setTaxFed(new BigDecimal(t.getTaxFed()));
		tx.setTaxProv(new BigDecimal(t.getTaxProv()));
		tx.setProvince(ProvinceService.getProvince(province));
		try {
		rep.saveTaxe(tx); 

		} catch (Exception  e) {
			throw new  PersistentDataException("Enable to persist data :"+e.getMessage());
		}
	}
}
