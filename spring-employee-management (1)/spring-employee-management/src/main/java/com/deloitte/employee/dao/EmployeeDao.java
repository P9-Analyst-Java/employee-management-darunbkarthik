package com.deloitte.employee.dao;

import java.util.List;

import com.deloitte.employee.model.Employee;
import com.deloitte.employee.model.EmploymentHistory;

public interface EmployeeDao {
	
	List<Employee> search(Long empId);
	List<Employee> search(String name);
	
	List<EmploymentHistory> getHistory(Long empId);
}
