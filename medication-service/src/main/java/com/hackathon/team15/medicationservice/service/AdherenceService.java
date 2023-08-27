package com.hackathon.team15.medicationservice.service;

import java.util.List;

import com.hackathon.team15.medicationservice.entity.Adherence;

public interface AdherenceService {
    
    //adherence Operations

    //add adherence
    Adherence addAdherence(Adherence adherence);

    //get all adherence for a patient
    List<Adherence> getAllAdherenceByPatientId(int patientId);
    
}
