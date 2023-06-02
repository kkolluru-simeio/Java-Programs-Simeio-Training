package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.IDoctorRepository;

@Component
public class DoctorServiceImpl implements IDoctorService{
	
IDoctorRepository doctorRepository;
	
	public DoctorServiceImpl(IDoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}


	@Override
	public void addDoctor(Doctor doctor) {

		doctorRepository.addDoctor(doctor);
		
	}
	
	@Override
	public int updateDoctor(int doctorId, double fee) {

		return doctorRepository.updateDoctor(doctorId, fee);
		
	}

	@Override
	public Doctor getById(int doctorId) {
		Optional<Doctor> doctor = Optional.of(doctorRepository.findById(doctorId));
		return doctor.orElseThrow(() -> new DoctorNotFoundException());
			
	}

	@Override
	public void deleteDoctor(int doctorId) {
		doctorRepository.deleteDoctor(doctorId);
		
	}

	@Override
	public List<Doctor> getAllDoctors() {

		List<Doctor> doctors = doctorRepository.findAllDoctors().stream().sorted(Comparator.comparing(Doctor::getDoctorName)).collect(Collectors.toList());
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("No doctor found in repo");
		return doctors;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		List<Doctor> doctors =  doctorRepository.findBySpeciality(speciality).stream().sorted(Comparator.comparing(Doctor::getDoctorName)).collect(Collectors.toList());
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("No doctor found with speciality " + speciality);
		return doctors;
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) {
		List<Doctor> doctors =  doctorRepository.findBySpecialityAndExp(speciality, experience).stream().sorted(Comparator.comparing(Doctor::getExperience).reversed()).collect(Collectors.toList());
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("No doctor found with speciality " + speciality + " and experience " + experience);
		return doctors;
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees)  {
		List<Doctor> doctors =  doctorRepository.findBySpecialityAndFees(speciality, fees).stream().sorted(Comparator.comparing(Doctor::getFees)).collect(Collectors.toList());
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("No doctor found with speciality " + speciality + " and fess less than " + fees);
		return doctors;
	}

	@Override
	public List<Doctor> getByAvailability(String speciality, LocalDateTime appointmentTime)
			 {
		List<Doctor> doctors =  doctorRepository.findByAvailability(speciality, appointmentTime).stream().sorted(Comparator.comparing(Doctor::getDoctorName)).collect(Collectors.toList());
		if (doctors.isEmpty())
			throw new DoctorNotFoundException("No doctor found with speciality " + speciality + " and available at  " + appointmentTime);
		return doctors;
	}
	
	
	
	

}
