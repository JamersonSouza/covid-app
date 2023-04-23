package tech.jamersondev.covidapp.Domain.DTOs.User;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String token;
    private UserResponseDTO usuario;

}
