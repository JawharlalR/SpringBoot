package com.example.techsolutions.Controller;

import com.example.techsolutions.Entity.DepartmentEntity;
import com.example.techsolutions.Entity.OrganizationEntity;
import com.example.techsolutions.Service.DepartmentService;
import com.example.techsolutions.Service.OrganizationService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/departments")
    public DepartmentEntity createDepartment(@RequestBody DepartmentEntity department, @RequestParam Long organizationId) {
        OrganizationEntity organization = organizationService.getOrganizationById(organizationId).orElseThrow(() -> new EntityNotFoundException("Organization not found"));

        department.setOrganization(organization);

        return departmentService.createDepartment(department);
    }

    @GetMapping("/departments")
    public List<DepartmentEntity> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Optional<DepartmentEntity> getDepartmentById(@PathVariable long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/departments/{id}")
    public DepartmentEntity updateDepartment(@PathVariable long id, @RequestBody DepartmentEntity updatedDepartment) {
        return departmentService.updateDepartment(id, updatedDepartment);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
    }
}
