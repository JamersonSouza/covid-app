package tech.jamersondev.covidapp.Service.ServiceImpl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import tech.jamersondev.covidapp.Domain.User;
import tech.jamersondev.covidapp.Repository.UserRepository;

@Component
public class UserDetailsSecurityImpl implements UserDetailsService{

    private UserRepository userRepository;

    public UserDetailsSecurityImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> usuario = userRepository.findByEmail(username);
        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário ou senha inválidos. Tente novamente");
        }
        
        return usuario.get();
       
    }
    
}
