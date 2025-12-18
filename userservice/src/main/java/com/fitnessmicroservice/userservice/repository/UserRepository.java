package com.fitnessmicroservice.userservice.repository;

import com.fitnessmicroservice.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByEmail(String email);
}
