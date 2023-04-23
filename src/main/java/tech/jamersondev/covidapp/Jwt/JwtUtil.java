package tech.jamersondev.covidapp.Jwt;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import tech.jamersondev.covidapp.Domain.User;

@Component
public class JwtUtil {

    @Value("${jwtKey}")
    private String jwtSecret;

    @Value("${jwtTimeExpiration}")
    private Integer jwtExpiration;

    public String geradorToken(Authentication auth){

        //pegando o usuário atual
        User user = (User) auth.getPrincipal();

        try {
            //gerando a chave
            Key secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes("UTF-8"));
            //token gerado aqui
            return Jwts.builder()
            .setSubject(user.getEmail())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
            .signWith(secretKey)
            .compact();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }


    }

      // Metodo para descobrir de dentro do token com base 
    //na chave privada qual as permissões do usuário.

    private Claims getClaims(String token){
        try {
            Key secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes("UTF-8"));

            Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build()
            .parseClaimsJws(token).getBody();

            return claims;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }


      //método para pegar o E-mail do Usuário dentro do Token
      public String getUserName(String token){
        Claims claims = getClaims(token);
        if(claims == null){
            return null;
        }else{
            return claims.getSubject();
        }
    }

      //método para validar o token 
      public boolean isValidToken(String token){
        Claims claims = getClaims(token);

        if(claims == null) {
            return false;
        }

        String email = claims.getSubject();
        
        Date dataExpiracao = claims.getExpiration();

        Date agora = new Date(System.currentTimeMillis());

        if(email != null && agora.before(dataExpiracao)){
            return true;
        }
        return false;

    }

    
}
