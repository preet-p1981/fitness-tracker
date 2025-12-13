package com.fitnesstracker.userservice.repository;

import com.fitnesstracker.userservice.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userrepo extends JpaRepository<User,String> {
    Boolean existsByemail( String email);
}
