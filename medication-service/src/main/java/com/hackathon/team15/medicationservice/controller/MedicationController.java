package com.hackathon.team15.medicationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.team15.medicationservice.entity.Medication;
import com.hackathon.team15.medicationservice.entity.ResponseDto;
import com.hackathon.team15.medicationservice.repository.MedicationRepository;
import com.hackathon.team15.medicationservice.service.MedicationServiceImpl;

@RestController
@RequestMapping(value = "/medications")
public class MedicationController {

    @Autowired
    MedicationServiceImpl medicationServiceImpl;

    @Autowired
    MedicationRepository medicationRepository;

    @PostMapping
    public ResponseEntity<Medication> addMedication(@RequestBody Medication medication)
    {
        return new ResponseEntity<Medication>(medicationServiceImpl.addMedication(medication),HttpStatus.CREATED);
    }

    @GetMapping("/{medicationId}")
    public ResponseEntity<Medication> getMedication(@PathVariable int medicationId)
    {
        return new ResponseEntity<Medication>(medicationServiceImpl.getMedication(medicationId),HttpStatus.FOUND);
    }

    @PutMapping("/{medicationId}")
    public ResponseEntity<Medication> updateMedication(@RequestBody Medication medication ,@PathVariable int medicationId)
    {
        return new ResponseEntity<Medication>(medicationServiceImpl.upadateMedication(medication,medicationId),HttpStatus.OK);
    }

    @DeleteMapping("/{medicationId}")
    public ResponseEntity<String> deleteMedication(@PathVariable int medicationId)
    {
        medicationServiceImpl.deleteMedication(medicationId);
        return new ResponseEntity<String>("Medication details with meidication id "+medicationId+" deleted Successfully.",HttpStatus.OK);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Medication>> getAllMedicationsByPatientID(@PathVariable int patientId)
    {
        return new ResponseEntity<List<Medication>> (medicationServiceImpl.getAllMedicationByPatientId(patientId), HttpStatus.OK);
    }

    @GetMapping("/hey")
    public List<Medication> getReport(@RequestBody ResponseDto responseDto,@RequestParam(value="id", required = true) int patientId)
    {
        return medicationRepository.findAllByPatientIdAndCreatedOnBetween(patientId,responseDto.getStartDate(),responseDto.getEndDate());
    }
    
}
