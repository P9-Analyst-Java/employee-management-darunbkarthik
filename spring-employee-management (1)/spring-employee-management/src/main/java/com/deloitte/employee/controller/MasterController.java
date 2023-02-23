package com.deloitte.employee.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.deloitte.employee.dao.EmployeeDao;
import com.deloitte.employee.model.Employee;
import com.deloitte.employee.model.EmploymentHistory;
import com.deloitte.employee.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class MasterController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		List<Employee> employees = employeeService.findAll();
		System.out.println(employees + "\n");
		mav.addObject("employees", employees);
		return mav;
	}

	@RequestMapping("/employee")
	public ModelAndView addEmployee() {

		ModelAndView mav = new ModelAndView("employee");
		mav.addObject("employee", new Employee());
		return mav;

	}

//	@RequestMapping(value = "/employee", method = RequestMethod.POST)
//	public String save(@ModelAttribute("employee") Employee employee) {
//		employeeService.add(employee);
//		return "redirect:/";
//	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult br) {
		if (br.hasErrors()) {
			return "employee";
		} else {
			employeeService.save(employee);
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/employee/{empId}")
	public ModelAndView edit(@PathVariable("empId") Long empId) {

		ModelAndView mav = new ModelAndView("employee");
		Employee employee = employeeService.findById(empId);
		mav.addObject("employee", employee);
		return mav;

	}

	@RequestMapping(value = "/{empId}")
	public String delete(@PathVariable("empId") Long empId) {
		employeeService.delete(empId);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@Param("empId") Long empId, @Param("firstname") String firstname) {

		ModelAndView mav = new ModelAndView("home"); 
		List<Employee> employees = new ArrayList<>();

		if (empId != null) {
			employees = employeeDao.search(empId);
		} else if (firstname != null) {
			employees = employeeDao.search(firstname);
		}
		mav.addObject("employees", employees);
		System.out.println(employees + "\n");
		return mav;
	}

	@RequestMapping(value = "/employments/{empId}")
	public ModelAndView findHistory(@PathVariable("empId") Long empId) {

		ModelAndView mav = new ModelAndView("employments");
		List<EmploymentHistory> history = new ArrayList<>();

		history = employeeDao.getHistory(empId);

		Employee employee = employeeService.findById(empId);

		mav.addObject("employeehistory", history);
		mav.addObject("name", employee);

		return mav;

	}
	
	@RequestMapping(value = "/export")
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Employee_" + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);

		List<Employee> empList = employeeService.findAll();

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "User ID", "E-mail", "First Name", "Last Name", "Gender", "Salary", "Dob", "Pan Card Number",
				"Aadhaar Card Number", "Mobile", "Permanant Addresss", "Present Addresss", "Blood Group", "Post name" };
		String[] nameMapping = { "empId", "personalEmail", "firstName", "lastName", "gender", "basicPay", "dob", "panCardNo",
				"aadhaarCardNo", "mobileNum", "permanentAddress", "presentAddress", "bloodGroup", "postName" };

		csvWriter.writeHeader(csvHeader);

		for (Employee emp : empList) {
			csvWriter.write(emp, nameMapping);
		}

		csvWriter.close();

	}


}
