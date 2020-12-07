package com.medical.MedicalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.medical.MedicalApp.model.doctor;

@Repository
public interface DoctorRepository extends JpaRepository<doctor, Long> {
}
