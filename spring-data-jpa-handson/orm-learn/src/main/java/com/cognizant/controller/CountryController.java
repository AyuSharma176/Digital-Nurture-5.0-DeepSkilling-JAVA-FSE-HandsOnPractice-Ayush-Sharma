package com.cognizant.controller;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;
import com.cognizant.service.CountryService;
import com.cognizant.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public Country findByCode(@PathVariable String code) throws CountryNotFoundException {
        Country data = countryService.findByCode(code);
        if(data==null){
            throw new CountryNotFoundException("Country Not Found");
        }
        else{
            return data;
        }
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country.getCode(), country.getName());
    }

    @PutMapping("/{code}")
    public Country updateCountry(@PathVariable String code, @RequestBody Country country) {
        return countryService.updateCountry(code, country.getName());
    }

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
    }

    @GetMapping("/search")
    public List<Country> findByPartialName(@RequestParam String name) {
        return countryService.findByPartialName(name);
    }
}


