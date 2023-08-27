package com.hackathon.team15.medicationservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.team15.medicationservice.entity.Medication;
import com.hackathon.team15.medicationservice.exception.NoSuchMedicationExistsException;
import com.hackathon.team15.medicationservice.repository.MedicationRepository;

@Service
public class MedicationServiceImpl implements MedicationService{

    @Autowired
    MedicationRepository medicationRepository;

    @Override
    public Medication addMedication(Medication medication) {
        medication.setCreatedOn(LocalDateTime.now());
        return medicationRepository.save(medication);
    }

	@Override
	public Medication getMedication(int medicationId) {
		Optional<Medication> medication= medicationRepository.findById(medicationId);
        if(medication.isEmpty())
            throw new NoSuchMedicationExistsException("Medication does not EXIST with ID "+medicationId);

        return medication.get();
	}

	@Override
	public Medication upadateMedication(Medication medication, int medicationId) {
		Optional<Medication> medication1= medicationRepository.findById(medicationId);
        
        if(medication1.isEmpty())
           throw new NoSuchMedicationExistsException("Medication does not EXIST!!!!!!");
            	
        else
        {
            Medication medication2=medication1.get();

            if(medication.getPatientId()!= 0)
            {
                medication2.setPatientId(medication.getPatientId());
            }

            if(medication.getMedicationName()!= null && !medication.getMedicationName().isEmpty())
            {
                medication2.setMedicationName(medication.getMedicationName());
            }  
            
            if(medication.getDosage() != null && !medication.getDosage().isEmpty())
            {
                medication2.setDosage(medication.getDosage());
            }   

            if(medication.getFrequency() != null && !medication.getFrequency().isEmpty())
            {
                medication2.setFrequency(medication.getFrequency());
            }   

            if(medication.getStartDate()!= null)
            {
                medication2.setStartDate(medication.getStartDate());
            } 

            if(medication.getEndDate()!= null)
            {
                medication2.setEndDate(medication.getEndDate());
            }

            return medicationRepository.save(medication2);
        }
	}

	@Override
	public void deleteMedication(int medicationId) {
		medicationRepository.deleteById(medicationId);
	}

	@Override
	public List<Medication> getAllMedicationByPatientId(int patientId) 
    {
        return medicationRepository.findAllByPatientId(patientId);
	}
    
}
