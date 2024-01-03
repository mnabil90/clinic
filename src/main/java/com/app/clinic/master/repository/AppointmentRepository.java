package com.app.clinic.master.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.clinic.master.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	List<Appointment> findByAppointmentDate(Date appointmentDate);

	List<Appointment> findByPatientNameContainingIgnoreCase(String patientName);
	
	List<Appointment> findByPatientNameContainingIgnoreCaseAndAppointmentDate(String patientName, Date appointmentDate);

}
