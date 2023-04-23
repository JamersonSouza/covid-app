package tech.jamersondev.covidapp.Domain.DTOs.User;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String senha;
}
