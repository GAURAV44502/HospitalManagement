package com.example.hospital.HospitalManagement.controller;

import com.example.hospital.HospitalManagement.entity.Patient;
import com.example.hospital.HospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // allows frontend HTML to access API
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping
    public List<Patient> getAll() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable int id) {
        return service.getPatientById(id);
    }

    @PostMapping
    public Patient add(@RequestBody Patient patient) {
        return service.addPatient(patient);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable int id, @RequestBody Patient patient) {
        return service.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.deletePatient(id);
    }
}
