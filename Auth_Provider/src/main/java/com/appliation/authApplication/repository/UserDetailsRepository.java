package com.appliation.authApplication.repository;

import com.appliation.authApplication.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetail,Long> {

    public Optional<UserDetail> findAllByUserName(String userName);

}
