package com.hackathon.team15.medicationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.team15.medicationservice.entity.Adherence;
import com.hackathon.team15.medicationservice.repository.AdherenceRepository;

@Service
public class AdherenceServiceImpl implements AdherenceService{

    @Autowired
    AdherenceRepository adherenceRepository;

	@Override
	public Adherence addAdherence(Adherence adherence) {
		return adherenceRepository.save(adherence);
	}

	@Override
	public List<Adherence> getAllAdherenceByPatientId(int patientId) {
		return adherenceRepository.findAllByPatientId(patientId);
	}
}
