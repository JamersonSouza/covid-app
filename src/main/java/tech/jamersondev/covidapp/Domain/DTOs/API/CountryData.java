package tech.jamersondev.covidapp.Domain.DTOs.API;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.jamersondev.covidapp.Domain.User;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String country;
    private int totalCasosConfirmado;
    private int totalMortesConfirmado;
    private int qtdCasosAtivos;

    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private User usuario;
    
}
