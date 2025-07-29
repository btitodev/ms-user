package com.ms.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ms.user.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserModel u WHERE u.email = ?1")
    boolean existsByEmail(String email);
}

