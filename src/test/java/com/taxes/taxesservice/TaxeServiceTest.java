package com.taxes.taxesservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.taxes.taxesservice.mapper.TaxeMapper;
import com.taxes.taxesservice.repo.TaxeRepo;
import com.taxes.taxesservice.service.TaxeService;

public class TaxeServiceTest {

	@InjectMocks
	TaxeService  txService ;

	@Mock 
	TaxeRepo rep ;
	@Mock 
	TaxeMapper txMapper ;
	@Before
	public void setUp()
			throws Exception
	{
		MockitoAnnotations.initMocks( this );}

	@Test
	public void testGetTaxe()
	{
		com.taxes.model.Taxe taxeTarget = new com.taxes.model.Taxe();
		taxeTarget.setTaxFed(8.0);
		taxeTarget.setTaxProv(5.0);
		com.taxes.taxesservice.model.Taxe taxeSource = new com.taxes.taxesservice.model.Taxe();
		taxeSource.setTaxFed(new BigDecimal(8.0));
		taxeSource.setTaxProv(new BigDecimal(5.0));
		when(rep.getTaxe("ON")).thenReturn(taxeSource );
		when(txMapper.toTaxe(taxeSource)).thenReturn(taxeTarget);			
		assertEquals(taxeTarget,txService.getTaxe("ON"));
	}



}
