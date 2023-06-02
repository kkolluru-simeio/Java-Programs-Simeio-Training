package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService {
	
	void addDoctor(Doctor doctor);
	int updateDoctor(int doctorId, double fee);
	Doctor getById(int doctorId) throws DoctorNotFoundException;
	void deleteDoctor(int doctorId);
	List<Doctor> getAllDoctors() throws DoctorNotFoundException;
	
	
	List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException;
	List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException;
	List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException;	
	
	List<Doctor> getByAvailability(String speciality, LocalDateTime appointmentTime) throws DoctorNotFoundException;	
	 

}
