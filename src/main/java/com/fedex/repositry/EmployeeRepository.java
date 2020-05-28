package com.fedex.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedex.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
	// @Query("SELECT e FROM Employee e WHERE LOWER(e.empName) LIKE LOWER(:name%)")
	/*
	 * @Query("SELECT e from Employee e WHERE e.empName like (:name%)") public
	 * List<Employee> searchWithJPQLQuery(@Param("name") String searchName);
	 */

}
