package com.fedex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fedex.dto.EmpSkills;
import com.fedex.dto.Employee;
import com.fedex.model.EmpSkillsEntity;
import com.fedex.model.EmployeeEntity;
import com.fedex.repositry.EmployeeRepository;
import com.fedex.repositry.RestTemplateCall;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepositery;

	@Autowired
	private RestTemplateCall restClient;

	ModelMapper mapper = new ModelMapper();

	@Override
	public List<Employee> getAllEmployee() {

		List<EmployeeEntity> employeeEntityList = empRepositery.findAll();
		List<Employee> employeeDtoList = new ArrayList<Employee>();
		employeeEntityList.forEach(e1 -> {
			Employee e = new Employee();
			mapper.map(e1, e); // shallow copy
			employeeDtoList.add(e);
		});
		/*
		 * for (EmployeeEntity empEntity : employeeEntityList) { Employee e = new
		 * Employee(); mapper.map(empEntity, e); // shallow copy employeeDtoList.add(e);
		 * }
		 */

		System.out.println(employeeDtoList);
		return employeeDtoList;

	}

	@Override
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try {
			String name = null;
			EmployeeEntity empEntity = new EmployeeEntity();
			List<EmpSkills> skillName = emp.getEmpSkills();
			List<EmpSkills> skillList = new ArrayList<EmpSkills>();
			for (EmpSkills empSkill : skillName) {
				name = empSkill.getSkillName();
				EmpSkills skillByName = restClient.getSkillByName(name);
				skillList.add(skillByName);

			}
			List<EmpSkillsEntity> empSkillsEntity = new ArrayList<EmpSkillsEntity>();
			// List<EmpSkills> skillList = restClient.getAllSkill();
			emp.setEmpSkills(skillList);
			EmpSkillsEntity entity = new EmpSkillsEntity();
			for (EmpSkills skill : emp.getEmpSkills()) {
				mapper.map(skill, entity);
				empSkillsEntity.add(entity);
			}

			mapper.map(emp, empEntity);
			empEntity.setEmpSkillsEntity(empSkillsEntity);
			empRepositery.save(empEntity);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
		}

	}

	@Override
	public Employee getEmployeeById(int empId) {
		Optional<EmployeeEntity> employeeEntity = empRepositery.findById(empId);
		Employee employee = new Employee();
		ModelMapper mapper1 = new ModelMapper();
		mapper1.map(employeeEntity.get(), employee);
		return employee;
	}

	/*
	 * @Override public Employee updateSkills(Employee emp) { // TODO Auto-generated
	 * method stub Employee emp1 = new Employee(); Optional<Employee> getEmployee =
	 * empRepositery.findById(emp.getEmpId()); if (getEmployee.isPresent()) { emp1 =
	 * getEmployee.get(); emp1.setEmpName(emp.getEmpName());
	 * emp1.setDesignation(emp.getDesignation()); empRepositery.save(emp1);
	 * 
	 * } return emp1; }
	 */
	/*
	 * @Override public List<Employee> findByName(String name) { // TODO
	 * Auto-generated method stub return empRepositery.searchWithJPQLQuery(name); }
	 */

}
