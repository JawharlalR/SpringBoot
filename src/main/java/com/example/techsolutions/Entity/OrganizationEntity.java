package com.example.techsolutions.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="Organizations_table")
@Entity
public class OrganizationEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private long organizationId;
private String organizationName;
private String email;
private String website;
private long contact;


@OneToMany(mappedBy = "organization")
private List<DepartmentEntity> departments;



public OrganizationEntity() {
    
}

public OrganizationEntity(String organizationName,String email,String website,long contact) {
    
	this.organizationName=organizationName;
	this.email=email;
	this.website=website;
	this.contact=contact;
		
}



public long getorganizationId() {
	return organizationId;
}

public void setorganizationId(long organizationId) {
	this.organizationId = organizationId;
}

public String getOrganizationName() {
	return organizationName;
}

public void setOrganizationName(String organizationName) {
	this.organizationName = organizationName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getWebsite() {
	return website;
}

public void setWebsite(String website) {
	this.website = website;
}

public long getContact() {
	return contact;
}

public void setContact(long contact) {
	this.contact = contact;
}
}

