package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.dao.DoctorDaoImpl;
import com.doctorapp.dao.IDoctorDao;
import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public class DoctorServiceImpl implements IDoctorService{
	
	IDoctorDao doctorDao = new DoctorDaoImpl();

	@Override
	public void addDoctor(Doctor doctor) {

		doctorDao.addDoctor(doctor);
		
	}
	
	@Override
	public int updateDoctor(int doctorId, double fee) {

		return doctorDao.updateDoctor(doctorId, fee);
		
	}

	@Override
	public Doctor getById(int doctorId) throws DoctorNotFoundException{
		Doctor doctor = doctorDao.findById(doctorId);
		if(doctor == null)
			throw new DoctorNotFoundException();
		return doctor;
			
	}

	@Override
	public void deleteDoctor(int doctorId) {
		doctorDao.deleteDoctor(doctorId);
		
	}

	@Override
	public List<Doctor> getAllDoctors() throws DoctorNotFoundException{
		List<Doctor> doctorsList = doctorDao.findAllDoctors();
		if(doctorsList == null)
			throw new DoctorNotFoundException();
		return doctorsList;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
		List<Doctor> doctorsList = doctorDao.findBySpeciality(speciality);
		if(doctorsList == null)
			throw new DoctorNotFoundException();
		return doctorsList;
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
		List<Doctor> doctorsList = doctorDao.findBySpecialityAndExp(speciality, experience);
		if(doctorsList == null)
			throw new DoctorNotFoundException();
		return doctorsList;
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException {
		List<Doctor> doctorsList = doctorDao.findBySpecialityAndFees(speciality, fees);
		if(doctorsList == null)
			throw new DoctorNotFoundException();
		return doctorsList;
	}

	@Override
	public List<Doctor> getByAvailability(String speciality, LocalDateTime appointmentTime)
			throws DoctorNotFoundException {
		List<Doctor> doctorsList = doctorDao.findByAvailability(speciality, appointmentTime);
		if(doctorsList == null)
			throw new DoctorNotFoundException();
		return doctorsList;
	}
	
	
	
	

}
