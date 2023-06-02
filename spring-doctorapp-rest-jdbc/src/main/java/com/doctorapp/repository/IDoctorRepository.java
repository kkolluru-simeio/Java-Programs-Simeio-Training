package com.doctorapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorRepository {

	void addDoctor(Doctor doctor);
	int updateDoctor(int doctorId, double fee);
	
	
	Doctor findById(int doctorId)  ;
	void deleteDoctor(int doctorId);
	List<Doctor> findAllDoctors();
	
	
	List<Doctor> findBySpeciality(String speciality);
	List<Doctor> findBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException;
	List<Doctor> findBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException;	
	List<Doctor> findByAvailability(String speciality, LocalDateTime appointmentTime) throws DoctorNotFoundException;
	
}
