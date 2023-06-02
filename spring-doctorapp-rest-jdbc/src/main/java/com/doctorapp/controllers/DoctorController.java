package com.doctorapp.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@RestController
@RequestMapping("/doctor-api")
public class DoctorController {

	@Autowired
	IDoctorService doctorService;

	void addDoctor(Doctor doctor) {

	}

	int updateDoctor(int doctorId, double fee) {
		return 0;
	}

	@GetMapping("/doctors/{id}")
	Doctor getById(@PathVariable("id") int doctorId) {
		return doctorService.getById(doctorId);
	}

	void deleteDoctor(int doctorId) {

	}
	@GetMapping("/doctors")
	List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}

	@GetMapping("/doctors/speciality/{speciality}")
	List<Doctor> getBySpeciality(@PathVariable("speciality") String speciality) {
		return doctorService.getBySpeciality(speciality);
	}

	@GetMapping("/doctors/speciality/{speciality}/experience/{experience}")
	List<Doctor> getBySpecialityAndExp(@PathVariable("speciality") String speciality, @PathVariable("experience") int experience) {
		return doctorService.getBySpecialityAndExp(speciality, experience);
	}
	@GetMapping("/doctors/speciality/{speciality}/fees/{fees}")
	List<Doctor> getBySpecialityAndFees(@PathVariable("speciality") String speciality, @PathVariable("fees") double fees) {
		return doctorService.getBySpecialityAndFees(speciality, fees);
	}

	@GetMapping("/doctors/speciality/{speciality}/appointment-time/{appointmentTime}")
	List<Doctor> getByAvailability(@PathVariable("speciality") String speciality, @PathVariable("appointmentTime") String appointmentTime) {
		return doctorService.getByAvailability(speciality, LocalDateTime.parse(appointmentTime));
	}


}
