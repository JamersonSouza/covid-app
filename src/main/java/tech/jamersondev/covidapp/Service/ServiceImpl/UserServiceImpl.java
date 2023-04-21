package tech.jamersondev.covidapp.Service.ServiceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;

import tech.jamersondev.covidapp.Domain.DTOs.User.UserRequestDTO;
import tech.jamersondev.covidapp.Domain.DTOs.User.UserResponseDTO;
import tech.jamersondev.covidapp.Repository.UserRepository;
import tech.jamersondev.covidapp.Service.CrudService;

public class UserServiceImpl implements CrudService<UserRequestDTO, UserResponseDTO>{

    private ModelMapper mapper;
    private UserRepository userRepository;

    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDTO> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public UserResponseDTO getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public UserResponseDTO cadastro(UserRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastro'");
    }

    @Override
    public UserResponseDTO atualizar(Integer id, UserRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    
}
