package com.example.techsolutions.Service;

import com.example.techsolutions.Entity.EmployeesEntity;
import com.example.techsolutions.Repository.EmployeesRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepo employeesRepo;


       public EmployeesEntity createEmployee(EmployeesEntity employee) {
        return employeesRepo.save(employee);
    }
  
       public EmployeesRepo getEmployeesRepo() {
		return employeesRepo;
	}

	public void setEmployeesRepo(EmployeesRepo employeesRepo) {
		this.employeesRepo = employeesRepo;
	}

	public List<EmployeesEntity> getAllEmployees() {
           return employeesRepo.findAll();
       }

       public Optional<EmployeesEntity> getEmployeeById(long id) {
           return employeesRepo.findById(id);
       }

    

       public EmployeesEntity updateEmployee(long id, EmployeesEntity updatedEmployee) {
           if (employeesRepo.existsById(id)) {
               updatedEmployee.setEmployeeId(id);
               return employeesRepo.save(updatedEmployee);
           } else {
               
               return null;
           }
       }

       public void deleteEmployee(long id) {
           employeesRepo.deleteById(id);
       }
   }

