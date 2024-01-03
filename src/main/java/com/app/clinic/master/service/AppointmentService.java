package com.app.clinic.master.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.clinic.dto.CancelRequest;
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
	public Appointment cancel(Long id, CancelRequest cancelRequest) {
		Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        existingAppointment.setStatus(cancelRequest.getStatus());
        existingAppointment.setCancelReason(cancelRequest.getCancelReason());
        return appointmentRepository.save(existingAppointment);

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
