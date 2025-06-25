package com.authService.application.repository;

import com.authService.application.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<UserInfo,Long> {

     Optional<UserInfo> findByName(String name);
}
