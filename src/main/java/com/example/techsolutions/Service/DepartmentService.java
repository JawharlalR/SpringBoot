package com.example.techsolutions.Service;

import com.example.techsolutions.Entity.DepartmentEntity;
import com.example.techsolutions.Repository.DepartmentRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public DepartmentEntity createDepartment(DepartmentEntity department) {
        return departmentRepo.save(department);
    }
    
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Optional<DepartmentEntity> getDepartmentById(long id) {
        return departmentRepo.findById(id);
    }

    public DepartmentEntity updateDepartment(long id, DepartmentEntity updatedDepartment) {
        if (departmentRepo.existsById(id)) {
            updatedDepartment.setDeptId(id);
            return departmentRepo.save(updatedDepartment);
        } else {
            return null;
        }
    }

    public void deleteDepartment(long id) {
        departmentRepo.deleteById(id);
    }
}
