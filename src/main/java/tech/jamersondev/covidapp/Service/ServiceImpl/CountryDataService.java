package tech.jamersondev.covidapp.Service.ServiceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tech.jamersondev.covidapp.Domain.DTOs.API.CountryDataDTO;
import tech.jamersondev.covidapp.Domain.DTOs.API.SummaryDataDTO;


@Service
public class CountryDataService {

    private static final String REQUESTS_API = "https://api.covid19api.com/";

    private RestTemplate restTemplate;

    public CountryDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CountryDataDTO> getPaises(){
        String urlRequest = REQUESTS_API + "countries";
        ResponseEntity<CountryDataDTO[]> paisesResponse = restTemplate.getForEntity(urlRequest, CountryDataDTO[].class);
        return Arrays.asList(paisesResponse.getBody());
        
    }

    //método que busca um resumo do Mundo e dos Paises
    public SummaryDataDTO getResumo(){
        String urlRequest = REQUESTS_API + "summary";
        SummaryDataDTO response = restTemplate.getForObject(urlRequest, SummaryDataDTO.class);
        return response;
    }
}
