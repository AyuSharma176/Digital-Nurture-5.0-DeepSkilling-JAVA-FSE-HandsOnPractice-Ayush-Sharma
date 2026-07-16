package com.cognizant.spring_learn.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.w3c.dom.Element;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


@Service
public class CountryService {
	
	public void addCountry(String code, String name) throws Exception {
	    File file = new File("src/main/resources/country.xml");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

	    DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory1.newDocumentBuilder();
	    Document doc = builder.parse(file);  // reads the XML file

	    Element root = doc.getDocumentElement();

	    Element beanEl = doc.createElement("bean");
	    beanEl.setAttribute("id", "country" + code);
	    beanEl.setAttribute("class", "com.cognizant.spring_learn.model.Country");

	    Element codeProperty = doc.createElement("property");
	    codeProperty.setAttribute("name", "code");
	    codeProperty.setAttribute("value", code);

	    Element nameProperty = doc.createElement("property");
	    nameProperty.setAttribute("name", "name");
	    nameProperty.setAttribute("value", name);

	    beanEl.appendChild(codeProperty);
	    beanEl.appendChild(nameProperty);
	    root.appendChild(beanEl);

	    Transformer transformer = TransformerFactory.newInstance().newTransformer();
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    transformer.transform(new DOMSource(doc), new StreamResult(file));

	    System.out.println("Country added: " + code + " - " + name);
	}
	
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
	
	public ArrayList<Country> getAllCountries(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		Map<String,Country> map = context.getBeansOfType(Country.class);
		
		return new ArrayList<>(map.values());
	}
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		Country india = context.getBean("countryIN", Country.class);
		
		return india;
	}
	
}
