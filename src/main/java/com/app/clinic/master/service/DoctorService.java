package com.app.clinic.master.service;

import org.springframework.stereotype.Service;

import com.app.clinic.master.entity.Doctor;
import com.app.clinic.master.repository.DoctorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {

	private final DoctorRepository doctorRepository;
	
	@Transactional
	public Doctor register(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	

	
}
