package com.taxes.taxesservice.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.taxes.taxesservice.model.Taxe;





@Repository
public class TaxeRepo {

	@PersistenceContext
	private EntityManager em;


	@Transactional
	public Taxe getTaxe(String  province)
	{		
		Taxe tx = (Taxe)em.createQuery("from Taxe  t  where t.province.code =:province AND t.dateTx =("
				+ "select max(t.dateTx) from  t where t.province.code =:province)")
				.setParameter("province",province).getSingleResult();
		return tx ;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public void saveTaxe(Taxe t)
	{		
		em.merge(t) ;
	}
}
