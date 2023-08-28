package com.virtusa.communicationservice.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.communicationservice.dto.CommunicationDto;
import com.virtusa.communicationservice.dto.HealthCareDto;
import com.virtusa.communicationservice.dto.PatientDto;
import com.virtusa.communicationservice.repository.CommunicationRepository;
import com.virtusa.communicationservice.service.APIClient;
import com.virtusa.communicationservice.service.APIClient2;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommunicationServiceImpl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommunicationServiceImpl.class);
	
	@Autowired
	private APIClient apiClient;
	@Autowired
	private APIClient2 apiClient2;
	
	@Autowired
	CommunicationRepository communicationRepository;
	
	public CommunicationDto create(CommunicationDto communicationDto) {
		CommunicationDto saved = communicationRepository.save(communicationDto);
		System.out.println(saved);
		return saved;
	}
	
	
	public String delete(Long cId) {
	    communicationRepository.deleteById(cId);
		return "Deleted";
	}
	
	public CommunicationDto update(CommunicationDto communicationDto) {
		CommunicationDto updated = communicationRepository.save(communicationDto);
		return updated;
	}
	
	public List<CommunicationDto> getFromPatientID(Long pId) {
		return communicationRepository.findByPatientId(pId);
	} 
     	
	public List<CommunicationDto> getFromHealthCareId(Long hId) {
		
		return communicationRepository.findByHealthCareId(hId);
	} 

	 @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultData")
	public PatientDto getPatientData(Long id) {
		 
		PatientDto patientDto=apiClient.getPatientId(id);
		return patientDto;
	}
	 
	 @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultData")
		public HealthCareDto getHealthCareData(Long id) {
			 
		 HealthCareDto healthCareDto=apiClient2.getHealthId(id);
			return healthCareDto;
		}
	 
	 
	 public String getDefaultData(Long id, Exception exception) {
		 return "Error";
	 }
	 
	 
	/*
	 * public APIDto getDefaultData(Long id, Exception exception) {
	 * 
	 * LOGGER.info("ENTERED INTO DEFAULT DATA"); APIDto apiDto= new APIDto();
	 * apiDto.setPatientDto(null); apiDto.setHistory("5 days");
	 * apiDto.setSymptom("fever"); return apiDto;
	 * 
	 * }
	 */

}
