package com.example.techsolutions.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.techsolutions.Entity.OrganizationEntity;

@Repository
public interface OrganizationRepo extends JpaRepository<OrganizationEntity, Long>{
  
	
}