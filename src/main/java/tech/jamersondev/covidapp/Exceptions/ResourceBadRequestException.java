package tech.jamersondev.covidapp.Exceptions;

public class ResourceBadRequestException extends RuntimeException{

    public ResourceBadRequestException(String msg){
        super(msg);
    }
    
}
