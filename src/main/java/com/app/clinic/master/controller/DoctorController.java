package com.app.clinic.master.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.clinic.master.entity.Doctor;
import com.app.clinic.master.service.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/doctor")
@AllArgsConstructor
public class DoctorController {

	private final DoctorService doctorService;
	
	@PostMapping("/register")
	@Operation(summary = "Register Doctor")
	public Doctor register(@RequestBody Doctor doctor) {
		return doctorService.register(doctor);
	}
}
