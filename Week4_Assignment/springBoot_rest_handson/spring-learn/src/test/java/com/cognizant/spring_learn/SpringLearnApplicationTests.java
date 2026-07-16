package com.cognizant.spring_learn;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.spring_learn.controllers.CountryController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


@SpringBootTest
@AutoConfiguration 
class SpringLearnApplicationTests {
	private CountryController countryController;
	@Autowired
    private MockMvc mvc;

	@Test
	void contextLoads() {
		assertNull(countryController);	
	}
	 @Test
	 public void testGetCountry() throws Exception {
	      ResultActions actions = mvc.perform(get("/country"));
	      actions.andExpect(status().isOk());
	      actions.andExpect(jsonPath("$.code").exists());
	 }
	 
	  @Test
	  public void getCountry() throws Exception {
	      ResultActions actions = mvc.perform(get("/country"));
	      actions.andExpect(status().isOk());
	      actions.andExpect(jsonPath("$.code").exists());
	      actions.andExpect(jsonPath("$.code").value("IN"));
	  }




}
