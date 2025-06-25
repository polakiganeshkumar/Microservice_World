package com.authService.application.NjStateContoller;

import com.authService.application.njService.NjService;
import com.authService.application.njdto.Employee;
import jakarta.persistence.Embeddable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baseUrlMapping")
public class NjController {

    @Autowired
    NjService service;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return service.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getByEmployeeId(@PathVariable String id){
        return service.getEmployeeId(Long.valueOf(id));
    }

    @PostMapping
    public Employee saveEmployee(Employee emp){
        return service.saveNewEmployee(emp);
    }

    @PutMapping
    public void UpdateTheEmployee(@RequestBody Employee employee){
         service.updateTheEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteTheEmployee(@PathVariable String id){
        service.deleteEmployee(id);
    }
}
