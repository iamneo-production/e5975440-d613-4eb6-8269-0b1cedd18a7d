package com.virtusa.communicationservice.dto;

public class APIDto {
	
	private PatientDto patientDto;
	private String symptom;
	private String history;
	public PatientDto getPatientDto() {
		return patientDto;
	}
	public void setPatientDto(PatientDto patientDto) {
		this.patientDto = patientDto;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public APIDto(PatientDto patientDto, String symptom, String history) {
		super();
		this.patientDto = patientDto;
		this.symptom = symptom;
		this.history = history;
	}
	public APIDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
