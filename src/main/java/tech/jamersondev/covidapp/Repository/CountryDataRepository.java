package tech.jamersondev.covidapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.jamersondev.covidapp.Domain.DTOs.API.CountryData;

public interface CountryDataRepository extends JpaRepository<CountryData, Integer>{
    
}
