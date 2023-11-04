package com.example.techsolutions.Service;

import com.example.techsolutions.Entity.OrganizationEntity;
import com.example.techsolutions.Repository.OrganizationRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrganizationService {

    
	@Autowired
    private OrganizationRepo organizationRepo;

  
    
    public OrganizationRepo getOrganizationRepo() {
		return organizationRepo;
	}

	public void setOrganizationRepo(OrganizationRepo organizationRepo) {
		this.organizationRepo = organizationRepo;
	}

	public OrganizationEntity createOrganization(OrganizationEntity organization) {
        return organizationRepo.save(organization);
    }
 
    public List<OrganizationEntity> getAllOrganizations() {
        return organizationRepo.findAll();
    }

    public Optional<OrganizationEntity> getOrganizationById(long id) {
        return organizationRepo.findById(id);
    }


    public OrganizationEntity updateOrganization(long id, OrganizationEntity updatedOrganization) {
        if (organizationRepo.existsById(id)) {
            updatedOrganization.setorganizationId(id);
            return organizationRepo.save(updatedOrganization);
        } else {
            
            return null;
        }
    }

    public void deleteOrganization(long id) {
        organizationRepo.deleteById(id);
    }

	
}