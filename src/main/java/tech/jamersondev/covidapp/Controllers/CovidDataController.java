package tech.jamersondev.covidapp.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

    
    @GetMapping("/countries")
    public List<CountryDataDTO> getCountries(){
        return countryDataService.getPaises();
    }

    @GetMapping("/resumo")
    public SummaryDataDTO getResumo(){
        return countryDataService.getResumo();
    }
    
}
