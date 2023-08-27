package com.hackathon.team15.medicationservice.service;

import java.util.List;

import com.hackathon.team15.medicationservice.entity.Medication;

public interface MedicationService {

    //Medication Operations

    //add medication
    Medication addMedication(Medication medication);

    //get medication by medication id
    Medication getMedication(int medicationId);

    //update medication by medication id
    Medication upadateMedication(Medication medication, int medicationId);

    //delete medication by medication id
    void deleteMedication(int medicationId);
    
    //get all medicines for a patient
    List<Medication> getAllMedicationByPatientId(int patientId);
}
