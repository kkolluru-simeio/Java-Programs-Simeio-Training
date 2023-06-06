package com.simeio.construct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:student.properties")
public class Student {

	private String studentName;
	private Department dept;
	
	public Student( Department dept) {
		super();
		this.dept = dept;
	}

	public String getStudentName() {
		return studentName;
	}

	@Value("${student.studentName}")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Department getDept() {
		return dept;
	}
	
	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", dept=" + dept + "]";
	}
	

}
