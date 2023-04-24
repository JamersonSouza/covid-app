package tech.jamersondev.covidapp.Jwt;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.jamersondev.covidapp.Domain.User;
import tech.jamersondev.covidapp.Service.ServiceImpl.UserDetailsSecurityImpl;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter{

    private JwtUtil jwtUtil;
    
    private UserDetailsSecurityImpl userDetailsSecurityImpl;

 
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
            UserDetailsSecurityImpl userDetailsSecurityImpl) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userDetailsSecurityImpl = userDetailsSecurityImpl;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    
                String header = request.getHeader("Authorization");

                if(header != null && header.startsWith("Bearer ")){
                    UsernamePasswordAuthenticationToken auth = getAuthentication(header.substring(7));

                    if(auth != null && auth.isAuthenticated()){
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }

                chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token){

        if(jwtUtil.isValidToken(token)){
            String email = jwtUtil.getUserName(token);

            User usuario = (User) userDetailsSecurityImpl.loadUserByUsername(email);

            return new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        }

        return null;

    }

    
}
