package tech.jamersondev.covidapp.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.jamersondev.covidapp.Domain.DTOs.API.CountryDataDTO;
import tech.jamersondev.covidapp.Domain.DTOs.API.SummaryDataDTO;
import tech.jamersondev.covidapp.Service.ServiceImpl.CountryDataService;

@RestController
@RequestMapping("/api-covid")
public class CovidDataController {

    private CountryDataService countryDataService;

    public CovidDataController(CountryDataService countryDataService) {
        this.countryDataService = countryDataService;
    }


    @GetMapping("/resumo")
    public SummaryDataDTO getResumo(){
        return countryDataService.getResumo();
    }
    
    @GetMapping("/countries/{country}")
    public String getDataCountry(@PathVariable String country){
        return countryDataService.getCountryData(country);
    }
}
