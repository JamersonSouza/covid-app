package tech.jamersondev.covidapp.Jwt;

import java.io.IOException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.jamersondev.covidapp.Domain.User;
import tech.jamersondev.covidapp.Domain.DTOs.User.LoginRequestDTO;
import tech.jamersondev.covidapp.Domain.DTOs.User.LoginResponseDTO;
import tech.jamersondev.covidapp.Domain.DTOs.User.UserResponseDTO;
import tech.jamersondev.covidapp.Exceptions.ErrorResponse;
import tech.jamersondev.covidapp.Exceptions.ResourceBadRequestException;
import tech.jamersondev.covidapp.Util.ConversorDate;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

        setFilterProcessesUrl("/user/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
       try {
        LoginRequestDTO login = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDTO.class);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha());
        Authentication auth = authenticationManager.authenticate(authToken);
        return auth;
       }
        catch(ResourceBadRequestException e){
            throw new ResourceBadRequestException("Usuário ou senha inválidos");
        }  catch (Exception e) {
            throw new InternalAuthenticationServiceException(e.getMessage());
       }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
     
                User usuario = (User) authResult.getPrincipal();
                String token = jwtUtil.geradorToken(authResult);

                UserResponseDTO userResponseDTO = new UserResponseDTO();

                userResponseDTO.setId(usuario.getId());
                userResponseDTO.setNome(usuario.getNome());
                usuario.setEmail(usuario.getEmail());

                LoginResponseDTO loginResponse = new LoginResponseDTO();
                loginResponse.setToken("Bearer " + token);

                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                response.getWriter().write(new Gson().toJson(loginResponse));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {

                String dataHora = ConversorDate.converterDateParaDataHora(new Date());
                
                ErrorResponse error = new ErrorResponse(dataHora, HttpStatus.UNAUTHORIZED.value(), 
                "Unauthorized", failed.getMessage());

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                response.getWriter().println(new Gson().toJson(error));

                
      }


    
    
    
}
