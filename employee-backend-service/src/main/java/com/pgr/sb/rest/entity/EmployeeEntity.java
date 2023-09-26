package com.pgr.sb.rest.entity;

import java.io.Serializable;

import com.pgr.sb.rest.dto.EmployeeDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "employee_details")
public class EmployeeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5750609611126568015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "empNo", unique = true, nullable = false )
	private String empNo;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "salary")
	private Double salary;

	@Column(name = "employee_type")
	private String employeeType;

	@Column(name = "status")
	private boolean status;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "phone")
	private String phone;

}