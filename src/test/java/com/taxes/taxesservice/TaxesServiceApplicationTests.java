package com.taxes.taxesservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxes.taxesservice.controller.TaxeController;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.taxes.taxesservice.model.User;
import com.taxes.taxesservice.service.TaxeService;
import com.taxes.taxesservice.service.UserService;

@RunWith(SpringRunner.class)
public class TaxesServiceApplicationTests {

	private MockMvc mvc;

	@Mock
	TaxeService serviceM;

	@Mock
	UserService serviceU;

	@Mock
	private ObjectMapper jsonMapper;

	@InjectMocks
	TaxeController txController;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(txController).build();
	}

	@Test
	public void getTaxetByProvinceAPI() throws Exception

	{

		com.taxes.model.Taxe t = new com.taxes.model.Taxe();
		t.setTaxFed(8.0);
		t.setTaxProv(5.0);
		when(serviceM.getTaxe("ON")).thenReturn(t);

		User u = new User();
		u.setCode("txprojet");
		u.setPassword("tanis123");

		 when( jsonMapper.readValue(new ObjectMapper().writeValueAsString(u), User.class)).thenReturn(u);
		when(serviceU.getUsre("txprojet", "tanis123")).thenReturn(u);
		mvc.perform(MockMvcRequestBuilders.get("/taxes/taxe/ON")
				.header("securityHeader", new ObjectMapper().writeValueAsString(u))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.taxFed").value(8.0))
				.andExpect(MockMvcResultMatchers.jsonPath("$.taxProv").value(5.0));

	}

	/*
	 * @Test public void getTaxetByProvinceAPI() throws Exception
	 * 
	 * {
	 * 
	 * 
	 * User u = new User(); u.setCode("txprojet"); u.setPassword("tanis123");
	 * mvc.perform( MockMvcRequestBuilders .get("/taxes/test")
	 * .header("securityHeader", new ObjectMapper().writeValueAsString(u))
	 * .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
	 * .andDo(print()) .andExpect(status().isOk()) ;
	 * 
	 * }
	 * 
	 */

}
