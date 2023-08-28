package com.virtusa.communicationservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.virtusa.communicationservice.dto.PatientDto;

@FeignClient(name="PATIENT-DATA-SERVICE")
public interface APIClient {
	
	@GetMapping("api/patient-data/{patient_id}")
	PatientDto getPatientId(@PathVariable("patient_id") Long patientId);
	


}
