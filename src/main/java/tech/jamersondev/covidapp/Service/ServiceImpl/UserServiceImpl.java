package tech.jamersondev.covidapp.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tech.jamersondev.covidapp.Domain.User;
import tech.jamersondev.covidapp.Domain.DTOs.User.UserRequestDTO;
import tech.jamersondev.covidapp.Domain.DTOs.User.UserResponseDTO;
import tech.jamersondev.covidapp.Exceptions.ResourceBadRequestException;
import tech.jamersondev.covidapp.Exceptions.ResourceDataIntegrityViolationException;
import tech.jamersondev.covidapp.Repository.UserRepository;
import tech.jamersondev.covidapp.Service.CrudService;

@Service
public class UserServiceImpl implements CrudService<UserRequestDTO, UserResponseDTO>{

    private ModelMapper mapper;
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
       this.validacaoCadastro(dto);
       User usuario = mapper.map(dto, User.class);
       //criptografando senha do usuário
       String password = bCryptPasswordEncoder.encode(usuario.getSenha());
       usuario.setSenha(password);
       usuario.setId(null);
       usuario = this.userRepository.save(usuario);
       return mapper.map(usuario, UserResponseDTO.class);


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

    private void validacaoCadastro(UserRequestDTO dto){
        Optional<User> userEmail = this.userRepository.findByEmail(dto.getEmail());
        //validação de campos para cadastro
        if(dto.getEmail().isEmpty() || dto.getSenha().isEmpty() || dto.getNome().isEmpty()){
            throw new ResourceBadRequestException("Preencha todos os campos corretamente!");
        }
        //validação se tem outro usuário cadastrado com o mesmo e-email
        if(userEmail.isPresent() && userEmail.get().getId() != null){
            throw new ResourceDataIntegrityViolationException("E-mail já cadastrado no sistema. Tente um E-mail Diferente");
        }
    }

    
}
