package com.app.clinic.master.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.clinic.master.entity.Appointment;
import com.app.clinic.master.entity.CancelReason;
import com.app.clinic.master.repository.AppointmentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

	private final AppointmentRepository appointmentRepository;

	@Transactional
	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Transactional
	public List<Appointment> getAppointmentsByDate(Date date) {
		return appointmentRepository.findByAppointmentDate(date);
	}

	@Transactional
	public Appointment cancel(Long id, CancelReason reason) {
		Optional<Appointment> appointmentOp = appointmentRepository.findById(id);
		if (appointmentOp.isPresent()) {
			Appointment appointment = appointmentOp.get();
			appointment.setStatus("CANCELLED");
			appointment.setCancelReason(reason);
			appointmentRepository.save(appointment);
			return appointment;
		} else {
			throw new IllegalStateException("Appointment is already cancelled.");
		}

	}

	@Transactional
	public List<Appointment> searchAppointmentsByPatientName(String patientName) {
		return appointmentRepository.findByPatientNameContainingIgnoreCase(patientName);
	}

	@Transactional
	public List<Appointment> searchAppointmentsByPatientNameAndAppointmentDate(String patientName,
			Date appointmentDate) {
		return appointmentRepository.findByPatientNameContainingIgnoreCaseAndAppointmentDate(patientName,
				appointmentDate);
	}

}
