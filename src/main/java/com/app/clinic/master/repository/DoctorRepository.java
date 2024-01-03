package com.app.clinic.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.clinic.master.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
