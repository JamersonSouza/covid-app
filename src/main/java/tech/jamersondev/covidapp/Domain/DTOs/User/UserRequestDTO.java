package tech.jamersondev.covidapp.Domain.DTOs.User;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String nome;
    private String email;
    private String senha;
}
