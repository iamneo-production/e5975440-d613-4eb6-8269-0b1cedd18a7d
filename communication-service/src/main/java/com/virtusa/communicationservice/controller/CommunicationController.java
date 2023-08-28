package com.virtusa.communicationservice.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.communicationservice.dto.CommunicationDto;
import com.virtusa.communicationservice.dto.HealthCareDto;
import com.virtusa.communicationservice.dto.PatientDto;
import com.virtusa.communicationservice.serviceImpl.CommunicationServiceImpl;

@RestController
@RequestMapping("api/communication")
public class CommunicationController {
	
	@Autowired
	private CommunicationServiceImpl communicationServiceImpl;
	
	
	@GetMapping("{pId}")
	public PatientDto getPatientData(@PathVariable("pId") Long id){
		PatientDto patientDto = communicationServiceImpl.getPatientData(id);
	        //return new ResponseEntity<>(list, HttpStatus.OK)
            return patientDto;
    }
	@GetMapping("{hId}/health")
	 public HealthCareDto getHealthCareData(@PathVariable("hId") Long id){
		HealthCareDto healthCareDto = communicationServiceImpl.getHealthCareData(id);
	        //return new ResponseEntity<>(list, HttpStatus.OK)
           return healthCareDto;
   }
	
	@GetMapping("{pId}")
	public List<CommunicationDto> getFromPatientID(@PathVariable("pId") Long id){
		List<CommunicationDto> list = communicationServiceImpl.getFromPatientID(id);
	        //return new ResponseEntity<>(list, HttpStatus.OK)
            return list;
    }
	@GetMapping("{hId}/health")
	 public List<CommunicationDto> getFromHealthCareId(@PathVariable("hId") Long id){
		List<CommunicationDto> list = communicationServiceImpl.getFromHealthCareId(id);
	        //return new ResponseEntity<>(list, HttpStatus.OK)
           return list;
   }
	@PostMapping
	public ResponseEntity<CommunicationDto> create(@RequestBody CommunicationDto communicationDto){
		CommunicationDto saved = communicationServiceImpl.create(communicationDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long cId){
		communicationServiceImpl.delete(cId);
        return ResponseEntity.ok("Message deleted successfully!");
    }
	
	@PutMapping("{id}/update")
    public ResponseEntity<CommunicationDto> updateStudent(@RequestBody CommunicationDto communicationDto, @PathVariable("id") Long cId){
		CommunicationDto updated = communicationServiceImpl.update(communicationDto);
		return ResponseEntity.ok(updated);
    }
	
	
	}
