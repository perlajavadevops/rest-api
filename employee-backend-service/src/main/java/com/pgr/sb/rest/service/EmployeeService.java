package com.pgr.sb.rest.service;


import java.util.List;

import com.pgr.sb.rest.dto.EmployeeDto;


public interface EmployeeService {
	
	public List<EmployeeDto> getListOfEmployee();

	public EmployeeDto addEmployee(EmployeeDto employee);

	public boolean updateEmployee(EmployeeDto employee);

	public boolean deleteEmployee(String empNo);
	
	public EmployeeDto getEmployeeByEmpNo(String empNo);
}
