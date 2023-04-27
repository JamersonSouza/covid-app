package tech.jamersondev.covidapp.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.jamersondev.covidapp.Domain.DTOs.API.CountryData;
import tech.jamersondev.covidapp.Domain.DTOs.API.SummaryDataDTO;
import tech.jamersondev.covidapp.Repository.CountryDataRepository;
import tech.jamersondev.covidapp.Service.ServiceImpl.CountryDataService;

@RestController
@RequestMapping("/api-covid")
public class CovidDataController {

    private CountryDataService countryDataService;

    private CountryDataRepository countryDataRepository;

    public CovidDataController(CountryDataService countryDataService, CountryDataRepository countryDataRepository) {
        this.countryDataService = countryDataService;
        this.countryDataRepository = countryDataRepository;
    }


    @GetMapping("/resumo")
    public SummaryDataDTO getResumo(){
        return countryDataService.getResumo();
    }
    
    @GetMapping("/countries/{country}")
    public String getDataCountry(@PathVariable String country){
        return countryDataService.getCountryData(country);
    }

    @PostMapping("/salvar")
    public ResponseEntity<CountryData> salvarDados(@RequestBody CountryData countryData){

        CountryData dadosCovid = this.countryDataRepository.save(countryData);
        return ResponseEntity.ok().body(dadosCovid);

    }
}
