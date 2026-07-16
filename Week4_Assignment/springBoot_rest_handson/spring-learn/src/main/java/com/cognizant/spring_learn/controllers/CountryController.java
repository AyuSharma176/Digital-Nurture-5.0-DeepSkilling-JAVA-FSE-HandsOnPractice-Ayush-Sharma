package com.cognizant.spring_learn.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.spring_learn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import com.cognizant.spring_learn.SpringLearnApplication;
import com.cognizant.spring_learn.model.Country;

@RestController
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	@GetMapping
	public Country getCountryIndia() {
		return countryService.getCountryIndia();
	}
	@GetMapping("/all")
	public ArrayList<Country> getAllCountries(){
		return countryService.getAllCountries();
	}
	
	@GetMapping("/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        return countryService.getCountry(code);
    }
	@PostMapping("/{code}/{name}")
	public void addCountry(@PathVariable String code,@PathVariable String name) throws Exception {
		countryService.addCountry(code,name);
	}
	@PostMapping 
	public String addCountry(@RequestBody @Valid Country country) throws Exception {
	    LOGGER.debug("Start");
	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        
        Set<ConstraintViolation<Country>> violations = validator.validate(country);
        List<String> errors = new ArrayList<String>();

        // Accumulate all errors in an ArrayList of type String
        for (ConstraintViolation<Country> violation : violations) {
            errors.add(violation.getMessage());
        }

       
        if (violations.size() > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
        }
	    countryService.addCountry(country.getCode(), country.getName());
	    LOGGER.debug("end");
	    return "Country added successfully! Code: " + country.getCode() + ", Name: " + country.getName();
	}
}
