package com.example.techsolutions.Controller;

import com.example.techsolutions.Entity.OrganizationEntity;
import com.example.techsolutions.Service.OrganizationService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;
    
    
    public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}


    @PostMapping ("/organizations")
    public OrganizationEntity createOrganization(@RequestBody OrganizationEntity organization) {
        return organizationService.createOrganization(organization);
    }  
    

	@GetMapping("/organizations")
    public List<OrganizationEntity> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/organizations/{id}")
    public Optional<OrganizationEntity> getOrganizationById(@PathVariable long id) {
        return organizationService.getOrganizationById(id);
    }

   
    @PutMapping("/organizations/{id}")
    public OrganizationEntity updateOrganization(@PathVariable long id, @RequestBody OrganizationEntity updatedOrganization) {
        return organizationService.updateOrganization(id, updatedOrganization);
    }

    @DeleteMapping("/organizations/{id}")
    public void deleteOrganization(@PathVariable long id) {
        organizationService.deleteOrganization(id);
    }
}

