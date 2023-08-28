package com.virtusa.communicationservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.virtusa.communicationservice.dto.HealthCareDto;
import com.virtusa.communicationservice.dto.PatientDto;

@FeignClient(name="HEALTH-CARE-SERVICE")
public interface APIClient2 {
	
	@GetMapping("api/health-care-service/{healt_id}")
	HealthCareDto getHealthId(@PathVariable("healt_id") Long patientId);
	
//	@GetMapping("DRUG-INTERACTION-SERVICE/api/drug-interaction")
//     String getMessage();

}
