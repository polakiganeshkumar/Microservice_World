package com.authService.application.njService;

import com.authService.application.NjRepo.Reposetory;
import com.authService.application.njdto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NjService {

    @Autowired
     private Reposetory repo;




    public Employee getEmployeeId(long id){
       return repo.findById(id).get();
    }

    public List<Employee> findAllEmployee(){
        return repo.findAll();
    }

    public Employee saveNewEmployee(Employee emp){
        return repo.save(emp);
    }

    public Employee updateTheEmployee(Employee emp){
       Employee em= getEmployeeId(emp.getId());
        Employee empUpdate=new Employee();
        empUpdate.setId(em.getId());
        empUpdate.setName(em.getName());
        empUpdate.setEmail(em.getEmail());
        empUpdate.setDesignation(em.getDesignation());
        empUpdate.setRequirements(em.getRequirements());
        empUpdate.setSalary(em.getSalary());

        return repo.save(empUpdate);

    }


    public void deleteEmployee(String id) {
         repo.deleteById(Long.valueOf(id));
    }
}
