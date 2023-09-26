package com.pgr.sb.rest.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5733194512264840345L;

	private Integer id;

	private String empNo;

	private String firstName;

	private String lastName;

	private Double salary;

	private String employeeType;

	private boolean status;

	private String emailId;

	private String phone;

}
