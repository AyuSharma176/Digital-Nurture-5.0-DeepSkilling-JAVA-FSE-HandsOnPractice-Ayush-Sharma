package com.cognizant.spring_learn.controllers;


import java.util.ArrayList;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;
import com.cognizant.spring_learn.model.Country;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	@GetMapping
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		Country india = context.getBean("countryIN", Country.class);
		
		return india;
	}
	@GetMapping("/all")
	public ArrayList<Country> getAllCountries(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		Map<String,Country> map = context.getBeansOfType(Country.class);
		
		return new ArrayList<>(map.values());
	}
	
	@GetMapping("/{code}")
	public Country getCountry(String code) throws CountryNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Map<String, Country> countryMap = context.getBeansOfType(Country.class);
        ArrayList<Country> countries = new ArrayList<>(countryMap.values());

        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        throw new CountryNotFoundException();
    }
}
