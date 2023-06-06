package com.simeio.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:course.properties")
@Scope("prototype")
public class Course {
	
	private String courseName;
	private String courseType;
	
	public String getCourseName() {
		return courseName;
	}
	@Value("${course.name}")
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseType() {
		return courseType;
	}
	@Value("${course.type}")
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseType=" + courseType + "]";
	}
	
	

}
