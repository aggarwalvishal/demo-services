package com.fedex.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fedex.dto.EmpSkills;
import com.fedex.dto.Employee;
import com.fedex.model.EmpSkillsEntity;
import com.fedex.model.EmployeeEntity;
import com.fedex.repositry.EmployeeRepository;
import com.fedex.repositry.RestTemplateCall;import net.bytebuddy.agent.builder.ResettableClassFileTransformer;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImpTest {
	@Mock
	private EmployeeRepository empRepo;

	@Mock
	private RestTemplateCall restClient;
	

	@InjectMocks
	private EmployeeServiceImpl empService;

	Employee employee1 = new Employee();
	EmpSkills empskill = new EmpSkills();
	EmployeeEntity empEntity = new EmployeeEntity();
	EmpSkillsEntity empSkillEntity = new EmpSkillsEntity();
	List<EmployeeEntity> empEntityList = new ArrayList<>();
	List<EmpSkillsEntity> empSkillEntityList = new ArrayList<>();
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

		empSkillEntity.setSkillId(2);
		empSkillEntity.setSkillName("Java");
		empSkillEntityList.add(empSkillEntity);
		empEntity.setEmpId(1);
		empEntity.setEmpName("Deepak");
		empEntity.setDesignation("Softwrae Engineer");
		empEntity.setEmpSkillsEntity(empSkillEntityList);
		empEntityList.add(empEntity);
	}

	@Test
	public void getAllEmployeeTest() {

		when(empRepo.findAll()).thenReturn(empEntityList);
		assertEquals(empList.size(), empService.getAllEmployee().size());
		verify(empRepo).findAll();
	}

	@Test
	public void createEmployeeTest() throws JsonMappingException, JsonProcessingException {
		when(restClient.getSkillByName(empskill.getSkillName())).thenReturn(empskill);
		empService.createEmployee(employee1);

		verify(restClient).getSkillByName(empskill.getSkillName());
	}
	@Test
	public void getEmployeeByIdTest()
	{
		Optional<EmployeeEntity> optionalEntity = Optional.of(empEntity);
		when(empRepo.findById(empEntity.getEmpId())).thenReturn(optionalEntity);
		assertEquals(employee1.getEmpId(), empService.getEmployeeById(empEntity.getEmpId()).getEmpId());		
		verify(empRepo).findById(empEntity.getEmpId());
	}
}
