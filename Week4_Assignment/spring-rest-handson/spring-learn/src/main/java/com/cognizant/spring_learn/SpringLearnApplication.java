package com.cognizant.spring_learn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring_learn.model.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		
		displayDate();
		
		displayCountry();
	}
	public static void displayDate() {
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		
		Date currDate = new Date();
		String formattedDate = format.format(currDate);
	    LOGGER.debug(formattedDate);
		System.out.println("Todays Date is: "+formattedDate);
		
		try {
			Date parsedDate = format.parse("31/12/2026");
			System.out.println("Parsed Date: "+parsedDate);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		LOGGER.info("End");
	}
	public static void displayCountry() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		Country country = context.getBean("countryUS", Country.class);
		Country anotherCountry = context.getBean("countryIN", Country.class);
		System.out.println("Country : " + country.toString());
		System.out.println("Country : " + anotherCountry.toString());
		LOGGER.debug("Country : {}", country.toString());

	}
}
