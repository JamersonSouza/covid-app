package tech.jamersondev.covidapp.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.jamersondev.covidapp.Domain.DTOs.User.UserRequestDTO;
import tech.jamersondev.covidapp.Domain.DTOs.User.UserResponseDTO;
import tech.jamersondev.covidapp.Service.ServiceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    
    private UserServiceImpl userService;

    
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping("/cadastro")
    public ResponseEntity<UserResponseDTO> cadastro(@RequestBody UserRequestDTO userDTO){
        UserResponseDTO usuarioDTO = this.userService.cadastro(userDTO);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
    }


}
