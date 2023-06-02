package com.doctorapp.client;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialization;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;

public class Admin {

	public static void main(String[] args) {
		
		
		IDoctorService doctorService = new DoctorServiceImpl();
		
		Doctor doctor = new Doctor();
		doctor.setDoctorName("kiran");
		doctor.setSpeciality(Specialization.Orthopaedician.toString());
		doctor.setExperience(5);
		doctor.setFees(500);
		LocalDateTime localDateTime = LocalDateTime.of(2023, 05, 30, 14, 00, 00, 00);	
		doctor.setStartTime(localDateTime);
		localDateTime = LocalDateTime.of(2023, 05, 30, 18, 00, 00, 00);	
		doctor.setEndTime(localDateTime);
		

		doctorService.addDoctor(doctor);
		
		doctor.setDoctorName("kk");
		doctor.setSpeciality(Specialization.Orthopaedician.toString());
		doctor.setExperience(10);
		doctor.setFees(800);
		localDateTime = LocalDateTime.of(2023, 05, 30, 9, 00, 00, 00);	
		doctor.setStartTime(localDateTime);
		localDateTime = LocalDateTime.of(2023, 05, 30, 17, 00, 00, 00);	
		doctor.setEndTime(localDateTime);
		doctorService.addDoctor(doctor);
		
		
		
		System.out.println(doctorService.updateDoctor(2, 900));
		try {
			System.out.println(doctorService.getById(2));
			}catch(DoctorNotFoundException ex) {
				ex.printStackTrace();
			}
		
		doctorService.deleteDoctor(2);
		
		try {
			System.out.println(doctorService.getById(2));
			}catch(DoctorNotFoundException ex) {
				ex.printStackTrace();
			}
	}
}
