package com.example.techsolutions.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.techsolutions.Entity.EmployeesEntity;
@Repository
public interface EmployeesRepo extends JpaRepository<EmployeesEntity,Long>{

}