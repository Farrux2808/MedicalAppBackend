package com.medical.MedicalApp.controller;


import com.medical.MedicalApp.exception.ResourceNotFoundException;
import com.medical.MedicalApp.model.doctor;
import com.medical.MedicalApp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;
    
    @CrossOrigin
    @GetMapping("doctors")
    public List<doctor> getAllDoctors(){
        return this.doctorRepository.findAll();
    }

    @GetMapping("doctor/{id}")
    public ResponseEntity<doctor> getDoctorById(@PathVariable(value = "id") Long doctorId)
        throws ResourceNotFoundException {
        doctor doctor1 = doctorRepository.findById(doctorId)
        .orElseThrow(() -> new ResourceNotFoundException("Doctor not fount this id ::" + doctorId));
                return ResponseEntity.ok().body(doctor1);
    }

    @PostMapping(path = "adddoctor", consumes = "application/json", produces = "application/json")
    public doctor createDoctor(@RequestBody doctor doctor1) {
        return this.doctorRepository.save(doctor1);
    }

    @PutMapping("doctor/{id}")
    public ResponseEntity<doctor> updateDoctor(@PathVariable(value = "id") Long doctorId,
        @Validated @RequestBody doctor doctorDetails) throws ResourceNotFoundException {
        doctor doctor1 = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not fount this id ::" + doctorId));

        doctor1.setFullName(doctorDetails.getFullName());
        doctor1.setSection(doctorDetails.getSection());
        doctor1.setPhone(doctorDetails.getPhone());
        doctor1.setLogin(doctorDetails.getLogin());
        doctor1.setPassword(doctorDetails.getPassword());

        final doctor updatedEmployee = doctorRepository.save(doctor1);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("doctor/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long doctorid)
            throws ResourceNotFoundException {
        doctor doctor1 = doctorRepository.findById(doctorid)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + doctorid));

        doctorRepository.delete(doctor1);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
