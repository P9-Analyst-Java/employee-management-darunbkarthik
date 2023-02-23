package com.deloitte.employee.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employment_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentHistory {
	@Id
	private Long id;
	
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "organization_name")
	private String organization_name;
	
	@Column(name = "from_date", nullable = false)
	private Date from_date;
	
	@Column(name = "until_date", nullable = false)
	private Date until_date;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "post", nullable = false)
	private String post;
	
	@Column(name = "skill_used")
	private String skill_used;
	
	@ManyToOne()
	private Employee employee;
}
