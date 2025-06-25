package com.authService.application.NjRepo;

import com.authService.application.njdto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Reposetory extends JpaRepository<Employee,Long> {

    Optional<Employee> findById(Long id);

}
