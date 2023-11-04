package com.example.techsolutions.Controller;

import com.example.techsolutions.Entity.DepartmentEntity;
import com.example.techsolutions.Entity.EmployeesEntity;
import com.example.techsolutions.Entity.OrganizationEntity;
import com.example.techsolutions.Service.DepartmentService;
import com.example.techsolutions.Service.EmployeesService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;
    
    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/employees")
    public EmployeesEntity createEmployee(@RequestBody EmployeesEntity employee, @RequestParam Long departmentId, @RequestParam Long organizationId) {
        
        DepartmentEntity department = departmentService.getDepartmentById(departmentId).orElseThrow(() -> new EntityNotFoundException("Department not found"));

OrganizationEntity organization = department.getOrganization();
        
        if (organization == null) {
            throw new EntityNotFoundException("Organization not found for the specified department.");
        }
        
        department.setOrganization(organization);
        department = departmentService.updateDepartment(departmentId, department); 
        
        employee.setDepartment(department);

        return employeesService.createEmployee(employee);
    }




    @GetMapping("/employees")
    public List<EmployeesEntity> getAllEmployees() {
        return employeesService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<EmployeesEntity> getEmployeeById(@PathVariable long id) {
        return employeesService.getEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public EmployeesEntity updateEmployee(@PathVariable long id, @RequestBody EmployeesEntity updatedEmployee) {
        return employeesService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeesService.deleteEmployee(id);
    }
}
