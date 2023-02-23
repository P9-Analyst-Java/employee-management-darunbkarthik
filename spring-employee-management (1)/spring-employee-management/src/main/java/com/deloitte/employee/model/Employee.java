package com.deloitte.employee.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_employees")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	private Long empId;
	
	@Column(name="first_name",nullable=false)
	@Pattern(regexp="^[A-Za-z]*$", message ="Please input alphabet only !! ")
	@Size(min = 1, message  = "Input between 1 to 50 characters !!" )
	@Size(max = 50, message  = "Input between 1 to 50 characters !!" )
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	@Pattern(regexp="^[A-Za-z]*$", message ="Please input alphabet only !! ")
	@Size(min = 1, message  = "Input between 1 to 50 characters !!" )
	@Size(max = 50, message  = "Input between 1 to 50 characters !!" )
	private String lastName;
	
	@Column(name="gender", nullable = false)
	private String gender;
		
	@Column(name="dob",nullable = false)
	private Date dob;
	
	@Column(name="pan_num")
	@Pattern(regexp="^[A-Z0-9]*$", message = "Please input alphanumeric only!")
	@Size(min = 10, message = "Please input 10 characters only")
	@Size(max = 10, message = "Please input 10 characters only")
	private String panCardNo;
	
	@Column(name="aadhaar_num")
	@Size(min = 12, message = "Please input 12 numbers only")
	@Size(max = 12, message = "Please input 12 numbers only")
	private String aadhaarCardNo;
	
	@Column(name="mobile_num", nullable = false)
	@Pattern(regexp="^[0-9]*$", message = "Please input numeric only")
	@Size(min = 10, message = "Please input 10 numbers only")
	@Size(max = 10, message = "Please input 10 numbers only")
	private String mobileNum;
	
	@Column(name="email_id", nullable = false,unique = true)
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$", message = "Please input a valid email !!")
	private String personalEmail;
	
	@Column(name="office_mail", nullable = false, unique = true)
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$", message = "Please input a valid email !!")
	private String officeMail;
	
	@Column(name="permanent_address")
	@Size(max = 200, message = "Text should not exceed 200 characters!")
	
	private String permanentAddress;
	
	@Column(name="present_address")
	@Size(max = 200, message = "Text should not exceed 200 characters!")
	private String presentAddress;
	
	@Column(name="blood_group")
	//message = "Please select valid blood group!"
	private String bloodGroup;
	
	@Column(name="profile_pict")
	private String profiePic;
	
	@Column(name="doj",nullable = false)
	private Date doj;
	
	@Column(name="emp_level", nullable = false)
	@Min(value = 7, message = "Please select a value between 7 to 13!")
	@Max(value = 13,message = "Please select a value between 7 to 13!")
	private String empLevel;
	
	@Column(name="post_name", nullable = false)
	@Pattern(regexp="^[A-Za-z ]*$", message = "Please input only alphabet and space")
	@Size(max = 30, message = "Please input within 30 characters") 
	private String postName;
	
	@Column(name="basic_pay", nullable = false)
	private long basicPay;
	
	@Column(name="house_allowance", nullable = false)
	private long houseAllowance;
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dob=" + dob + ", panCardNo=" + panCardNo + ", aadhaarCardNo=" + aadhaarCardNo + ", mobileNum="
				+ mobileNum + ", personalEmail=" + personalEmail + ", officeMail=" + officeMail + ", permanentAddress="
				+ permanentAddress + ", presentAddress=" + presentAddress + ", bloodGroup=" + bloodGroup
				+ ", profiePic=" + profiePic + ", doj=" + doj + ", empLevel=" + empLevel + ", postName=" + postName
				+ ", basicPay=" + basicPay + ", houseAllowance=" + houseAllowance + "]";
	}
	
	

}
