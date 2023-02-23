package com.deloitte.employee.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.employee.model.Employee;
import com.deloitte.employee.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public Employee findById(Long empId) {
		if(employeeRepository.findById(empId).isPresent()) {
			return employeeRepository.findById(empId).get();
		}
		return null;
	}

	@Override
	public void delete(Long empId) {
		Employee employee = findById(empId);
		employeeRepository.delete(employee);
		
	}

}
