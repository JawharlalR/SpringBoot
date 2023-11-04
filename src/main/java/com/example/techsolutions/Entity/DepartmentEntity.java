package com.example.techsolutions.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="Departments_table")
@Entity
public class DepartmentEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
private long deptId;
private String deptName;
private long employeesCount;
private String email;
private long contact;


@ManyToOne
@JoinColumn(name = "organizationId")
private OrganizationEntity organization;

@OneToMany(mappedBy = "department")
private List<EmployeesEntity> employees;



public  DepartmentEntity(){
	
}

public  DepartmentEntity (String deptName,long employeesCount,String email,long contact){
	
          this.deptName=deptName;
          this.employeesCount=employeesCount;
          this.email=email;
          this.contact=contact;
          
}

public OrganizationEntity getOrganization() {
	return organization;
}

public void setOrganization(OrganizationEntity organization) {
	this.organization = organization;
}

public long getDeptId() {
	return deptId;
}

public void setDeptId(long deptId) {
	this.deptId = deptId;
}

public String getDeptName() {
	return deptName;
}

public void setDeptName(String deptName) {
	this.deptName = deptName;
}

public long getEmployeesCount() {
	return employeesCount;
}

public void setEmployeesCount(long employeesCount) {
	this.employeesCount = employeesCount;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public long getContact() {
	return contact;
}

public void setContact(long contact) {
	this.contact = contact;
}

public void setOrganization(String string) {
	
}



}