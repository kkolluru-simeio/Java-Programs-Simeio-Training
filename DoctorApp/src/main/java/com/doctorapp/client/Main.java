package com.doctorapp.client;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialization;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;
import com.doctorapp.util.DbConnection;

public class Main {
	
	public static void main(String[] args) {
		insertData();
		IDoctorService doctorService = new DoctorServiceImpl();
		Doctor doctor = new Doctor();

		doctor.setDoctorName("kk");
		doctor.setSpeciality(Specialization.Orthopaedician.toString());
		doctor.setExperience(10);
		doctor.setFees(800);
		LocalDateTime localDateTime = LocalDateTime.of(2023, 05, 30, 9, 00, 00, 00);	
		doctor.setStartTime(localDateTime);
		localDateTime = LocalDateTime.of(2023, 05, 30, 17, 00, 00, 00);	
		doctor.setEndTime(localDateTime);
		doctorService.addDoctor(doctor);
		
		try {
			List<Doctor> doctorsList = doctorService.getAllDoctors();
			if(doctorsList.size() == 0) throw new DoctorNotFoundException();
			else
				doctorsList.stream().forEach(System.out::println);
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doctor.setDoctorName("katya");
		doctor.setSpeciality(Specialization.cardiologist.toString());
		doctor.setExperience(10);
		doctor.setFees(800);
		localDateTime = LocalDateTime.of(2023, 05, 31, 10, 00, 00, 00);	
		doctor.setStartTime(localDateTime);
		localDateTime = LocalDateTime.of(2023, 05, 31, 18, 00, 00, 00);	
		doctor.setEndTime(localDateTime);
		doctorService.addDoctor(doctor);
		
		try {
			System.out.println("getBySpeciality");
			String speciality = Specialization.cardiologist.toString();
			List<Doctor> doctorsList = doctorService.getBySpeciality(speciality);
			if(doctorsList.size() == 0) throw new DoctorNotFoundException();
			else
				doctorsList.stream().forEach(System.out::println);
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("getBySpeciality");
			String speciality = Specialization.Diabetician.toString();
			List<Doctor> doctorsList = doctorService.getBySpeciality(speciality);
			if(doctorsList.size() == 0) throw new DoctorNotFoundException();
			else
				doctorsList.stream().forEach(System.out::println);
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("getBySpecialityAndExp");
			String speciality = Specialization.Orthopaedician.toString();
			int experience = 7;
			List<Doctor> doctorsList = doctorService.getBySpecialityAndExp(speciality, experience);
			if(doctorsList.size() == 0) throw new DoctorNotFoundException();
			else
				doctorsList.stream().forEach(System.out::println);
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("getBySpecialityAndFees");
			String speciality = Specialization.Orthopaedician.toString();
			int fee = 600;
			List<Doctor> doctorsList = doctorService.getBySpecialityAndFees(speciality, fee);
			if(doctorsList.size() == 0) throw new DoctorNotFoundException();
			else
				doctorsList.stream().forEach(System.out::println);
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("getByAvailability");
			String speciality = Specialization.Orthopaedician.toString();
			localDateTime = LocalDateTime.of(2023, 05, 30, 19, 00, 00, 00);	
			List<Doctor> doctorsList = doctorService.getByAvailability(speciality, localDateTime);
			if(doctorsList.size() == 0) throw new DoctorNotFoundException();
			else
				doctorsList.stream().forEach(System.out::println);
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	static void insertData() {
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
		
	}

}
