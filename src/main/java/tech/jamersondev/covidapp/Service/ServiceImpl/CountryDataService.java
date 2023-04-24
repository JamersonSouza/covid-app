package tech.jamersondev.covidapp.Service.ServiceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tech.jamersondev.covidapp.Domain.DTOs.API.CountryDataDTO;


@Service
public class CountryDataService {

    private static final String REQUEST_PAISES = "https://api.covid19api.com/";

    private RestTemplate restTemplate;

    public CountryDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CountryDataDTO> getPaises(){
        String urlRequest = REQUEST_PAISES + "countries";
        ResponseEntity<CountryDataDTO[]> paisesResponse = restTemplate.getForEntity(urlRequest, CountryDataDTO[].class);
        return Arrays.asList(paisesResponse.getBody());
        
    }
    


    
}
