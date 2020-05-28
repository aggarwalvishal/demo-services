package com.fedex.dto;

import java.io.Serializable;
import java.util.List;

import com.fedex.model.EmpSkillsEntity;

/**
 * @author Vishal1.Aggarwal
 *
 */
public class Employee implements Serializable {

	private int empId;

	private String empName;

	private String designation;

	private List<EmpSkills> empSkills;

	/**
	 * @return the empSkills
	 */
	public List<EmpSkills> getEmpSkills() {
		return empSkills;
	}

	/**
	 * @param empSkills the empSkills to set
	 */
	public void setEmpSkills(List<EmpSkills> empSkills) {
		this.empSkills = empSkills;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Employee(int empId, String empName, String designation) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", designation=" + designation
				+ ", empSkillsEntity=" + empSkills + "]";
	}

}
