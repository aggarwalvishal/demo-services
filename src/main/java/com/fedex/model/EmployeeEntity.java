package com.fedex.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author Vishal1.Aggarwal
 *
 */
@Entity
@Table(name = "emp")
public class EmployeeEntity implements Serializable {

	@Id
	private int empId;

	@Size(min = 2, message = "Name atleast contains 2 letter")
	@Column(name = "ename")
	private String empName;

	@Column
	private String designation;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "empId_fk")
	private List<EmpSkillsEntity> empSkillsEntity;

	/**
	 * @return the empSkillsEntity
	 */
	public List<EmpSkillsEntity> getEmpSkillsEntity() {
		return empSkillsEntity;
	}

	/**
	 * @param list the empSkillsEntity to set
	 */
	public void setEmpSkillsEntity(List<EmpSkillsEntity> list) {
		this.empSkillsEntity = list;
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

	public EmployeeEntity(int empId, String empName, String designation) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
	}

	public EmployeeEntity() {
		// TODO Auto-generated constructor stub
	}
}
