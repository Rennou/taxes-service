
package com.taxes.taxesservice.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.taxes.taxesservice.model.Province;

@Repository
public class ProvinceRepo {


	@PersistenceContext
	private EntityManager em;


	@Transactional
	public Province getProvince(String id)
	{		
		Province p = (Province)em.createQuery("select p from Province p where p.code =:id").setParameter("id", id).getSingleResult();
		return p ;
	}


	@SuppressWarnings("unchecked")
	@Transactional
	public List<Province> getAllProvince()
	{		
		return em.createQuery("select p from Province p").getResultList() ;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public void saveProvince(Province p)
	{		
		em.merge(p) ;
	}
}
