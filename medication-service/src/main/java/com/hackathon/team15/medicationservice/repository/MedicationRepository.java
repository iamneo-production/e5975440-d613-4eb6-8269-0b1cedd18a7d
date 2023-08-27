package com.hackathon.team15.medicationservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.team15.medicationservice.entity.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Integer>{
    List<Medication> findAllByPatientId(int patientId);
    List<Medication> findAllByPatientIdAndCreatedOnBetween(int patientId,LocalDateTime startDate,LocalDateTime endDate);
}
