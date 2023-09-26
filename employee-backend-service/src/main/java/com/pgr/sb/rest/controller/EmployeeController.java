package com.pgr.sb.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgr.sb.rest.dto.EmployeeDto;
import com.pgr.sb.rest.exception.ResourceNotFoundException;
import com.pgr.sb.rest.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	// get all employees
	@GetMapping("/employees")
	public List<EmployeeDto> getAllEmployees() {
		return employeeService.getListOfEmployee();
	}

	// create employee rest api
	@PostMapping("/employees")
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employee) {
		return employeeService.addEmployee(employee);
	}

	// get employee by id rest api
	@GetMapping("/employees/{empNo}")
	public ResponseEntity<EmployeeDto> getEmployeeByEmpNo(@PathVariable String empNo) {

		EmployeeDto employee = employeeService.getEmployeeByEmpNo(empNo);

		if (Optional.of(employee).isEmpty()) {
			throw new ResourceNotFoundException("Employee not exist with id :" + empNo);
		}

		return ResponseEntity.ok(employee);
	}

	// update employee rest api
	@PutMapping("/employees/{empNo}")
	public ResponseEntity<Map<String, Boolean>> updateEmployee(@PathVariable String empNo,
			@RequestBody EmployeeDto employeeDto) {
		EmployeeDto employee = employeeService.getEmployeeByEmpNo(empNo);

		if (Optional.of(employee).isEmpty()) {
			throw new ResourceNotFoundException("Employee not exist with id :" + empNo);
		}

		employeeDto.setEmpNo(empNo);
		employeeDto.setId(employee.getId());
		boolean updatedFlag = employeeService.updateEmployee(employeeDto);

		Map<String, Boolean> response = new HashMap<>();

		if (updatedFlag) {
			response.put("updated", Boolean.TRUE);
		} else {
			response.put("updated ", Boolean.FALSE);
		}
		return ResponseEntity.ok(response);
	}

	// delete employee rest api
	@DeleteMapping("/employees/{empNo}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable String empNo) {
		EmployeeDto employee = employeeService.getEmployeeByEmpNo(empNo);

		if (Optional.of(employee).isEmpty()) {
			throw new ResourceNotFoundException("Employee not exist with id :" + empNo);
		}

		boolean deleteFlag = employeeService.deleteEmployee(empNo);
		Map<String, Boolean> response = new HashMap<>();

		if (deleteFlag) {
			response.put("deleted", Boolean.TRUE);
		} else {
			response.put("deleted", Boolean.FALSE);
		}
		return ResponseEntity.ok(response);
	}

}
