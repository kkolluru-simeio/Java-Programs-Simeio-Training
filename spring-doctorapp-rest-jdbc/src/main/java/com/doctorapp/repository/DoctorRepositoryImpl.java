package com.doctorapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.util.Queries;

@Component
public class DoctorRepositoryImpl implements IDoctorRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addDoctor(Doctor doctor) {
		
		String sql = Queries.INSERTQUERY;
		Object[] doctorArray = {doctor.getDoctorName(), doctor.getExperience(), doctor.getFees(), doctor.getStartTime(), doctor.getEndTime()};
		jdbcTemplate.update(sql, doctorArray);

	}

	@Override
	public int updateDoctor(int doctorId, double fee) {
		return jdbcTemplate.update(Queries.UPDATEQUERY, fee, doctorId);
		
	}

	@Override
	public Doctor findById(int doctorId) {
		return jdbcTemplate.queryForObject(Queries.QUERYBYID, new DoctorMapper(), doctorId);
		
	}

	@Override
	public void deleteDoctor(int doctorId) {
		jdbcTemplate.update(Queries.DELETEQUERY, doctorId);
	}
	@Override
	public List<Doctor> findAllDoctors() {
		return jdbcTemplate.query(Queries.QUERYALL, new DoctorMapper());
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		return jdbcTemplate.query(Queries.QUERYBYSPECIALITY, new DoctorMapper(), speciality);
		
	}
	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
		return jdbcTemplate.query(Queries.QUERYBYSPECIALITYEXP, new DoctorMapper(), speciality, experience);
	}

	@Override
	public List<Doctor> findBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException {
		return jdbcTemplate.query(Queries.QUERYBYSPECIALITYFEES, new DoctorMapper(), speciality, fees);
	}

	@Override
	public List<Doctor> findByAvailability(String speciality, LocalDateTime appointmentTime)
			throws DoctorNotFoundException {
		return jdbcTemplate.query(Queries.QUERYBYAVAILABILITY, new DoctorMapper(), speciality, appointmentTime);
	}

}
