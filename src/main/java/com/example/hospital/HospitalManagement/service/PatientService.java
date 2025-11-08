package com.example.hospital.HospitalManagement.service;

import com.example.hospital.HospitalManagement.entity.Patient;
import com.example.hospital.HospitalManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public List<Patient> getAllPatients() {
        return repo.findAll();
    }

    public Patient getPatientById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Patient addPatient(Patient p) {
        return repo.save(p);
    }

    public Patient updatePatient(int id, Patient newPatient) {
        Patient old = repo.findById(id).orElse(null);
        if (old != null) {
            old.setName(newPatient.getName());
            old.setAge(newPatient.getAge());
            old.setDisease(newPatient.getDisease());
            return repo.save(old);
        }
        return null;
    }

    public String deletePatient(int id) {
        repo.deleteById(id);
        return "Deleted patient with id: " + id;
    }
}
