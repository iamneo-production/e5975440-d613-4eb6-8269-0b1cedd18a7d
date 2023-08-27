package com.hackathon.team15.medicationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.team15.medicationservice.entity.Adherence;

public interface AdherenceRepository extends JpaRepository<Adherence,Integer>{
    
    List<Adherence> findAllByPatientId(int patientId);
}
