package tech.jamersondev.covidapp.Handlers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import tech.jamersondev.covidapp.Exceptions.ErrorResponse;
import tech.jamersondev.covidapp.Exceptions.ResourceBadRequestException;
import tech.jamersondev.covidapp.Util.ConversorDate;

@ControllerAdvice
public class RestApiExceptionHandler {
    

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorResponse> handlerResourceBadRequestException(ResourceBadRequestException excep){
        
        String dataHora = ConversorDate.converterDateParaDataHora(new Date());
        ErrorResponse error = new ErrorResponse(dataHora, 
        HttpStatus.BAD_REQUEST.value(), "Bad Request", excep.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
