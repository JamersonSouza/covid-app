package tech.jamersondev.covidapp.Service;

import java.util.List;

public interface CrudService<Request, Response>{

    List<Response> getAll();
    Response getById(Integer id);
    Response cadastro(Request dto);
    Response atualizar(Integer id, Request dto);
    void delete(Integer id);
    
}
