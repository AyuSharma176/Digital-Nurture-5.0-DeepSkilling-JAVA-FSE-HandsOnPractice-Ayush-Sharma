package com.cognizant.service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.service.exception.CountryNotFoundException;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    @Transactional
    public Country findByCode(String code) throws CountryNotFoundException {
        return countryRepository.findById(code)
                .orElseThrow(() -> new CountryNotFoundException("Country not found: " + code));
    }

    public Country addCountry(String code, String name) {
        if (countryRepository.existsById(code)) {
            throw new RuntimeException("Country already exists: " + code);
        }
        Country data = new Country();
        data.setCode(code);
        data.setName(name);
        return countryRepository.save(data);
    }


    public Country updateCountry(String code, String name) {
        Country country = countryRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Country not found: " + code));
        country.setName(name);
        return countryRepository.save(country);
    }

    public void deleteCountry(String code) {
        if (!countryRepository.existsById(code)) {
            throw new RuntimeException("Country not found: " + code);
        }
        countryRepository.deleteById(code);
    }

    public List<Country> findByPartialName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }
}

