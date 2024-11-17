package com.ecom.domain.repositories;

import com.ecom.domain.entity.Role;
import com.ecom.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);


    User findByEmail(String email);
}
