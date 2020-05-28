package com.fedex.service;

import java.util.List;

import com.fedex.dto.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployee();

	public void createEmployee(Employee emp);

	public Employee getEmployeeById(int empId);
	// public void deleteEmployee(int empId);
	// public Employee updateSkills(Employee emp);
	// List<Employee> findByName(String name);

}
