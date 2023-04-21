package tech.jamersondev.covidapp.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    
    private String dataHora;
    private Integer status;
    private String titulo;
    private String mensagem;

}
