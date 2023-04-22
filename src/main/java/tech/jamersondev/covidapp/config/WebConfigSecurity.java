package tech.jamersondev.covidapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import tech.jamersondev.covidapp.Service.ServiceImpl.UserDetailsSecurityImpl;


@Configuration
@EnableWebSecurity
public class WebConfigSecurity {


    private AuthenticationConfiguration authConfig;

    private UserDetailsSecurityImpl userDetailsSecurityImpl;

    public WebConfigSecurity(AuthenticationConfiguration authConfig, UserDetailsSecurityImpl userDetailsSecurityImpl) {
        this.authConfig = authConfig;
        this.userDetailsSecurityImpl = userDetailsSecurityImpl;
    }

    @Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.headers().frameOptions().disable()
        .and()
        .cors()
        .and()
        .csrf().disable()
        .authorizeHttpRequests( (auth) -> auth
            .requestMatchers(HttpMethod.POST, "/user/cadastro").permitAll()
            .anyRequest().authenticated())
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();

    }

    
    
}
