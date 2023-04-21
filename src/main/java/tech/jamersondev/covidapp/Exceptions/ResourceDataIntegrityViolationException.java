package tech.jamersondev.covidapp.Exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class ResourceDataIntegrityViolationException extends DataIntegrityViolationException{

    public ResourceDataIntegrityViolationException(String msg) {
        super(msg);
    }

}
