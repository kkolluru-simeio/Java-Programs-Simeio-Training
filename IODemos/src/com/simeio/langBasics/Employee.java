package com.simeio.langBasics;

import java.util.Objects;

public class Employee {
	
	private String empName;
	private String city;
	private int employeeId;
	private String department;
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee(String empName, String city, int employeeId, String department) {
		super();
		this.empName = empName;
		this.city = city;
		this.employeeId = employeeId;
		this.department = department;
	}

	public Employee() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, department, empName, employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department)
				&& Objects.equals(empName, other.empName) && employeeId == other.employeeId;
	}

	
	

}
