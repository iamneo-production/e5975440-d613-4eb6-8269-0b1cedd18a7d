package com.virtusa.communicationservice.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="communication")
public class CommunicationDto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Long patientId;
	private String relavantMedicalKnowledge;
	private Long healthCareId;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getRelavantMedicalKnowledge() {
		return relavantMedicalKnowledge;
	}
	public void setRelavantMedicalKnowledge(String relavantMedicalKnowledge) {
		this.relavantMedicalKnowledge = relavantMedicalKnowledge;
	}

	public Long getHealthCareId() {
		return healthCareId;
	}
	public void setHealthCareId(Long healthCareId) {
		this.healthCareId = healthCareId;
	}
	public CommunicationDto(Long id, Long patientId, String relavantMedicalKnowledge, String possibleDiagnoses, Long healthCareId) {
		super();
		Id = id;
		this.patientId = patientId;
		this.relavantMedicalKnowledge = relavantMedicalKnowledge;
		this.healthCareId = healthCareId;
	}
	public CommunicationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
