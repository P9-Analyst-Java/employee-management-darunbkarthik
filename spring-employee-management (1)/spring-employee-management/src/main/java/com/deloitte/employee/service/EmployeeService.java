package com.deloitte.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deloitte.employee.model.Employee;
import com.deloitte.employee.model.EmploymentHistory;

@Service
public interface EmployeeService {
	List<Employee> findAll();
	
	void save(Employee employee);
	
	Employee findById(Long empId);
	
	void delete(Long empId);
	
}
