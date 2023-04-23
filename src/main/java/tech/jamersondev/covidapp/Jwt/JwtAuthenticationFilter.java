package tech.jamersondev.covidapp.Jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    
    
    
}
