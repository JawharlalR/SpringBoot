package com.example.techsolutions.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="Employees_table")
@Entity
public class EmployeesEntity {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	

private long employeeId;
private String employeeName;
private String role;
private String experience;
private long salary;
private String email;
private long contact;
private String address;

@ManyToOne
@JoinColumn(name = "deptId")
private DepartmentEntity department;



public EmployeesEntity() {
	
}
	
public EmployeesEntity(String employeeId,String employeeName,String role,String experience,long salary,String email,long contact,String address) {
	
	this.employeeName=employeeName;
	this.role=role;
	this.experience=experience;
	this.salary=salary;
	this.email=email;
	this.contact=contact;
	this.address=address;
}


public DepartmentEntity getDepartment() {
	return department;
}

public void setDepartment(DepartmentEntity department) {
	this.department = department;
}


public long getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(long employeeId) {
	this.employeeId = employeeId;
}

public String getEmployeeName() {
	return employeeName;
}

public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getExperience() {
	return experience;
}

public void setExperience(String experience) {
	this.experience = experience;
}

public long getSalary() {
	return salary;
}

public void setSalary(long salary) {
	this.salary = salary;
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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}


	 
}
