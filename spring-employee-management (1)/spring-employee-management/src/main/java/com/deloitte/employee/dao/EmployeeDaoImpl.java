package com.deloitte.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deloitte.employee.model.Employee;
import com.deloitte.employee.model.EmploymentHistory;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> search(Long empId) {
		return jdbcTemplate.query("select * from tbl_employees where emp_id = ?",
				new BeanPropertyRowMapper<Employee>(Employee.class), empId);
	}

	@Override
	public List<Employee> search(String name) {
		return jdbcTemplate.query(
				"select * from tbl_employees where first_name like '%" + name + "%' OR last_name LIKE '%" + name + "%'",
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public List<EmploymentHistory> getHistory(Long empId) {
		return jdbcTemplate.query("select * from employment_history where emp_id = ?", 
				new BeanPropertyRowMapper<EmploymentHistory>(EmploymentHistory.class),empId);
	}

}
