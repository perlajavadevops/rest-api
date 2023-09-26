package com.pgr.sb.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgr.sb.rest.dto.EmployeeDto;
import com.pgr.sb.rest.entity.EmployeeEntity;
import com.pgr.sb.rest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;

	public List<EmployeeDto> getListOfEmployee() {
		List<EmployeeDto> employeesList = new ArrayList<>();

		employeeRepository.findAll().forEach(entity -> {
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setId(entity.getId());
			employeeDto.setEmpNo(entity.getEmpNo());
			employeeDto.setFirstName(entity.getFirstName());
			employeeDto.setLastName(entity.getLastName());
			employeeDto.setSalary(entity.getSalary());
			employeeDto.setEmployeeType(entity.getEmployeeType());
			employeeDto.setStatus(entity.isStatus());
			employeeDto.setEmailId(entity.getEmailId());
			employeeDto.setPhone(entity.getPhone());

			employeesList.add(employeeDto);
		});
		return employeesList;
	}

	public EmployeeDto addEmployee(EmployeeDto employeeDto) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(employeeDto.getId());
		employeeEntity.setEmpNo(employeeDto.getEmpNo());
		employeeEntity.setFirstName(employeeDto.getFirstName());
		employeeEntity.setLastName(employeeDto.getLastName());
		employeeEntity.setSalary(employeeDto.getSalary());
		employeeEntity.setEmployeeType(employeeDto.getEmployeeType());
		employeeEntity.setStatus(employeeDto.isStatus());
		employeeEntity.setEmailId(employeeDto.getEmailId());
		employeeEntity.setPhone(employeeDto.getPhone());

		EmployeeEntity entity = employeeRepository.save(employeeEntity);
		if (entity != null)
			return employeeDto;
		else
			return employeeDto;
	}

	public boolean updateEmployee(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(employeeDto.getId());
		employeeEntity.setEmpNo(employeeDto.getEmpNo());
		employeeEntity.setFirstName(employeeDto.getFirstName());
		employeeEntity.setLastName(employeeDto.getLastName());
		employeeEntity.setSalary(employeeDto.getSalary());
		employeeEntity.setEmployeeType(employeeDto.getEmployeeType());
		employeeEntity.setStatus(employeeDto.isStatus());
		employeeEntity.setEmailId(employeeDto.getEmailId());
		employeeEntity.setPhone(employeeDto.getPhone());

		EmployeeEntity entity = employeeRepository.save(employeeEntity);
		if (entity != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteEmployee(String empNo) {

		int val = employeeRepository.deleteEmployeeByEmpNo(empNo);

		if (val > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public EmployeeDto getEmployeeByEmpNo(String empNo) {

		EmployeeEntity entity = employeeRepository.getEmployeeByEmpNo(empNo);
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(entity.getId());
		employeeDto.setEmpNo(entity.getEmpNo());
		employeeDto.setFirstName(entity.getFirstName());
		employeeDto.setLastName(entity.getLastName());
		employeeDto.setSalary(entity.getSalary());
		employeeDto.setEmployeeType(entity.getEmployeeType());
		employeeDto.setStatus(entity.isStatus());
		employeeDto.setEmailId(entity.getEmailId());
		employeeDto.setPhone(entity.getPhone());

		return employeeDto;

	}

}