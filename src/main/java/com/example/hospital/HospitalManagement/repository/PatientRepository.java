package com.example.hospital.HospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.HospitalManagement.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
