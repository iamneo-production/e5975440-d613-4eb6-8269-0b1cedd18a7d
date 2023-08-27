package com.hackathon.team15.medicationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.team15.medicationservice.entity.Adherence;
import com.hackathon.team15.medicationservice.entity.Medication;
import com.hackathon.team15.medicationservice.entity.ResponseDto;
import com.hackathon.team15.medicationservice.repository.AdherenceRepository;
import com.hackathon.team15.medicationservice.service.AdherenceServiceImpl;

@RestController
@RequestMapping(value = "/adherence")
public class AdherenceController {

    @Autowired
    AdherenceServiceImpl adherenceServiceImpl;

    @PostMapping
    public ResponseEntity<Adherence> addAdherence(@RequestBody Adherence adherence)
    {
        return new ResponseEntity<Adherence>(adherenceServiceImpl.addAdherence(adherence),HttpStatus.CREATED);
    }
   
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Adherence>> getAllAdherencesByPatientID(@PathVariable int patientId)
    {
        return new ResponseEntity<List<Adherence>> (adherenceServiceImpl.getAllAdherenceByPatientId(patientId), HttpStatus.OK);
    }
    
    @GetMapping("/hi")
    public String demo()
    {
        return "hey rushi";
    }


    
}
