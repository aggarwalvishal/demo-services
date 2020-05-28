package com.fedex.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fedex.dto.EmpSkills;
import com.fedex.dto.Employee;
import com.fedex.exception.ResourceNotFoundException;
import com.fedex.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@Mock
	EmployeeServiceImpl empServiceImpl;

	@InjectMocks
	EmployeeController empController;

	Employee employee1 = new Employee();
	EmpSkills empskill = new EmpSkills();
	List<Employee> empList = new ArrayList<>();
	List<EmpSkills> empSkillList = new ArrayList<>();

	@Before
	public void createDummyEmployee() {
		empskill.setSkillId(2);
		empskill.setSkillName("Java");
		empSkillList.add(empskill);
		employee1.setEmpId(1);
		employee1.setEmpName("Deepak");
		employee1.setDesignation("Softwrae Engineer");
		employee1.setEmpSkills(empSkillList);
		empList.add(employee1);
	}

	@Test
	public void getEmployeeTest() {
		// EmployeeServiceImpl empService = mock(EmployeeServiceImpl.class);
		when(empServiceImpl.getAllEmployee()).thenReturn(empList);
		assertEquals(empList.size(), empController.getAllEmployee().size());
		verify(empServiceImpl).getAllEmployee();
	}

	@Test
	public void createEmployeeTest() {
		// EmployeeServiceImpl empService = mock(EmployeeServiceImpl.class);
		empController.createEmployee(employee1);
		verify(empServiceImpl).createEmployee(employee1);

	}
	@Test
	public void getEmployeeByIdTest() throws ResourceNotFoundException
	{
		when(empServiceImpl.getEmployeeById(employee1.getEmpId())).thenReturn(employee1);
		assertEquals(employee1, empController.getEmployeeById(employee1.getEmpId()));
		verify(empServiceImpl).getEmployeeById(employee1.getEmpId());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void getEmployeeByIdIfEmployeeIsNull() throws ResourceNotFoundException {
		when(empServiceImpl.getEmployeeById(employee1.getEmpId())).thenReturn(null);
		empController.getEmployeeById(1);
		//assertEquals(employee1, empController.getEmployeeById(employee1.getEmpId()));		
		//verify(empServiceImpl).getEmployeeById(employee1.getEmpId());
	}
	
}