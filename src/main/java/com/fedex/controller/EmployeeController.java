package com.fedex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.dto.Employee;
import com.fedex.exception.ResourceNotFoundException;
import com.fedex.service.EmployeeServiceImpl;

/**
 * @author Vishal1.Aggarwal
 *
 */
@RestController
@RequestMapping("/v1")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empService;

	/**
	 * This method return all the employee present in employee table
	 * 
	 * @return
	 */

	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployee() {
		return empService.getAllEmployee();
	}

	/**
	 * This method return the employee based on id
	 * 
	 * @return
	 */

	@GetMapping("getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer empId) throws ResourceNotFoundException {
		Employee emp = empService.getEmployeeById(empId);

		if (emp == null) {
			throw new ResourceNotFoundException("User Not Found by Given id ==>" + empId);
		}
		return emp;
	}

	/**
	 * Create employee in database
	 * 
	 * @param emp
	 */
	@PostMapping("/createEmployee")
	public void createEmployee(@Valid @RequestBody Employee employee) {
		empService.createEmployee(employee);
	}

	/*
	 * @GetMapping("emp/{name}") public List<Employee>
	 * getByName(@PathVariable("name") String name) { return
	 * empService.findByName(name); }
	 */
}
