package tech.jamersondev.covidapp.Domain.DTOs.User;

import java.util.Date;

import lombok.Data;

@Data
public class UserResponseDTO {

    private Integer id;
    private String nome;
    private String email;
    private Date dataCadastro;    
}
