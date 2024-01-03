package com.app.clinic.master.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.clinic.dto.CancelRequest;
import com.app.clinic.master.entity.Appointment;
import com.app.clinic.master.entity.CancelReason;
import com.app.clinic.master.service.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/appointment")
@AllArgsConstructor
public class AppointmentController {
	
	private final AppointmentService appointmentService;

	@PostMapping
	@Operation(summary = "Add Appointment")
	public Appointment save(@RequestBody Appointment appointment) {
		return appointmentService.save(appointment);
	}
	
	@Operation(summary = "Cancel Appointment")
	@PutMapping("/{id}/cancel")
    public Appointment cancel(@PathVariable Long id, @RequestBody CancelRequest cancelRequest) {
        return appointmentService.cancel(id, cancelRequest);
    }
	
	@GetMapping("/getTodayAppointments")
	@Operation(summary = "List Today Appointments")
	public List<Appointment> getTodayAppointments() {
		return appointmentService.getAppointmentsByDate(new Date());
	}
		
	@GetMapping("/getAppointmentsByDate")
	@Operation(summary = "List Appointments By Date")
	public List<Appointment> getAppointmentsByDate(@RequestParam Date date) {
		return appointmentService.getAppointmentsByDate(date);
	}
	
	@GetMapping("/search")
	@Operation(summary = "filter Appointments by Patient Name and Date")
    public List<Appointment> searchAppointmentsByPatientNameAndAppointmentDate(
            @RequestParam("patientName") String patientName,
            @RequestParam(value = "appointmentDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date appointmentDate
    ) {
        return appointmentService.searchAppointmentsByPatientNameAndAppointmentDate(patientName, appointmentDate);
    }
}
