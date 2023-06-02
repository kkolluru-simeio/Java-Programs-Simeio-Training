package com.doctorapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.util.DbConnection;
import com.doctorapp.util.Queries;

public class DoctorDaoImpl implements IDoctorDao {

	

	@Override
	public void addDoctor(Doctor doctor) {
		
		// create a prepared statement
		try {
			// get the connection
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);

			statement.setString(1, doctor.getDoctorName());
			statement.setString(2, doctor.getSpeciality());
			statement.setInt(3, doctor.getExperience());
			statement.setDouble(4, doctor.getFees());
			statement.setTimestamp(5, Timestamp.valueOf(doctor.getStartTime()));
			statement.setTimestamp(6, Timestamp.valueOf(doctor.getEndTime()));
			System.out.println("add doctor" + statement.execute());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		

	}

	@Override
	public int updateDoctor(int doctorId, double fee) {
		try {
			// get the connection
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);

			statement.setDouble(1, fee);
			statement.setInt(2, doctorId);
			if(!statement.execute())
				return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return 0;
		
	}

	@Override
	public Doctor findById(int doctorId) {
		try {
			// get the connection
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYID);

			statement.setInt(1, doctorId);

			ResultSet rs = statement.executeQuery();
			if(rs.next())
			 if(rs.getRow() != 0) {
				 Doctor doctor = new Doctor();
				 doctor.setDoctorName(rs.getString("doctorName"));
				 doctor.setDoctorId(rs.getInt("doctorId"));
				 doctor.setExperience(rs.getInt("experience"));
				 doctor.setFees(rs.getDouble("fees"));
				 doctor.setSpeciality(rs.getString("speciality"));
				 doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				 doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				 return doctor;
			 }
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return null;
		
	}

	@Override
	public void deleteDoctor(int doctorId) {
		// create a prepared statement
				try {
					// get the connection
					Connection connection = DbConnection.openConnection();
					PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);
					statement.setInt(1, doctorId);
					System.out.println("deleted doctor" + statement.execute());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					DbConnection.closeConnection();
				}

	}

	@Override
	public List<Doctor> findAllDoctors() {
		try {
			// get the connection
			Connection connection = DbConnection.openConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(Queries.QUERYALL);
			List<Doctor> doctorsList = new ArrayList<Doctor>();
			while(rs.next())
			{
				 Doctor doctor = new Doctor();
				 doctor.setDoctorName(rs.getString("doctorName"));
				 doctor.setDoctorId(rs.getInt("doctorId"));
				 doctor.setExperience(rs.getInt("experience"));
				 doctor.setFees(rs.getDouble("fees"));
				 doctor.setSpeciality(rs.getString("speciality"));
				 doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				 doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				 doctorsList.add(doctor);
			 }
			return doctorsList;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return null;
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		try {
			// get the connection
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYSPECIALITY);
			statement.setString(1, speciality);
			ResultSet rs = statement.executeQuery();
			List<Doctor> doctorsList = new ArrayList<Doctor>();
			while(rs.next())
			{
				 Doctor doctor = new Doctor();
				 doctor.setDoctorName(rs.getString("doctorName"));
				 doctor.setDoctorId(rs.getInt("doctorId"));
				 doctor.setExperience(rs.getInt("experience"));
				 doctor.setFees(rs.getDouble("fees"));
				 doctor.setSpeciality(rs.getString("speciality"));
				 doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				 doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				 doctorsList.add(doctor);
			 }
			return doctorsList;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return null;
	}
	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
		try {
			// get the connection
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYSPECIALITYEXP);
			statement.setString(1, speciality);
			statement.setInt(2, experience);
			ResultSet rs = statement.executeQuery();
			List<Doctor> doctorsList = new ArrayList<Doctor>();
			while(rs.next())
			{
				 Doctor doctor = new Doctor();
				 doctor.setDoctorName(rs.getString("doctorName"));
				 doctor.setDoctorId(rs.getInt("doctorId"));
				 doctor.setExperience(rs.getInt("experience"));
				 doctor.setFees(rs.getDouble("fees"));
				 doctor.setSpeciality(rs.getString("speciality"));
				 doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				 doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				 doctorsList.add(doctor);
			 }
			return doctorsList;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return null;
	}

	@Override
	public List<Doctor> findBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException {
		try {
			// get the connection
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYSPECIALITYFEES);
			statement.setString(1, speciality);
			statement.setDouble(2, fees);
			ResultSet rs = statement.executeQuery();
			List<Doctor> doctorsList = new ArrayList<Doctor>();
			while(rs.next())
			{
				 Doctor doctor = new Doctor();
				 doctor.setDoctorName(rs.getString("doctorName"));
				 doctor.setDoctorId(rs.getInt("doctorId"));
				 doctor.setExperience(rs.getInt("experience"));
				 doctor.setFees(rs.getDouble("fees"));
				 doctor.setSpeciality(rs.getString("speciality"));
				 doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				 doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				 doctorsList.add(doctor);
			 }
			return doctorsList;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return null;
	}

	@Override
	public List<Doctor> findByAvailability(String speciality, LocalDateTime appointmentTime)
			throws DoctorNotFoundException {
		try {
			// get the connection
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYAVAILABILITY);
			statement.setString(1, speciality);
			statement.setTimestamp(2,  Timestamp.valueOf(appointmentTime));
			ResultSet rs = statement.executeQuery();
			List<Doctor> doctorsList = new ArrayList<Doctor>();
			while(rs.next())
			{
				 Doctor doctor = new Doctor();
				 doctor.setDoctorName(rs.getString("doctorName"));
				 doctor.setDoctorId(rs.getInt("doctorId"));
				 doctor.setExperience(rs.getInt("experience"));
				 doctor.setFees(rs.getDouble("fees"));
				 doctor.setSpeciality(rs.getString("speciality"));
				 doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				 doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				 doctorsList.add(doctor);
			 }
			return doctorsList;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return null;
	}

}
