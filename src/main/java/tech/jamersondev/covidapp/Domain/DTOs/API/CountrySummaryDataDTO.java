package tech.jamersondev.covidapp.Domain.DTOs.API;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountrySummaryDataDTO {

    @JsonProperty("Country")
    private String country;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("Slug")
    private String slug;

    @JsonProperty("NewConfirmed")
    private int newConfirmed;

    @JsonProperty("TotalConfirmed")
    private int totalConfirmed;

    @JsonProperty("NewDeaths")
    private int newDeaths;

    @JsonProperty("TotalDeaths")
    private int totalDeaths;

    @JsonProperty("NewRecovered")
    private int newRecovered;

    @JsonProperty("TotalRecovered")
    private int totalRecovered;
    
    @JsonProperty("Date")
    private Date date;

}
