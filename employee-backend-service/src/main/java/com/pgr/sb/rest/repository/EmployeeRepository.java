package com.pgr.sb.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pgr.sb.rest.entity.EmployeeEntity;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

	@Modifying
	@Query(value = "delete from employee_details where emp_no= :empNo", nativeQuery = true)
	int deleteEmployeeByEmpNo(String empNo);
	
	@Query(value = "select * from employee_details where emp_no= :empNo", nativeQuery = true)
	EmployeeEntity getEmployeeByEmpNo(String empNo);


}
