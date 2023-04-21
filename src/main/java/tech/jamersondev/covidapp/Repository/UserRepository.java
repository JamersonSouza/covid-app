package tech.jamersondev.covidapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.jamersondev.covidapp.Domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    
}
