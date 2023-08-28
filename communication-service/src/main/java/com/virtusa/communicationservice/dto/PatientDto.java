package com.virtusa.communicationservice.dto;


public class PatientDto {
	


	    private Long id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String mobileno;
	    private String gender;
	    private String symptom;
	    private String history;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobileno() {
			return mobileno;
		}
		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
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
		public PatientDto(Long id, String firstName, String lastName, String email, String mobileno, String gender,
				String symptom, String history) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.mobileno = mobileno;
			this.gender = gender;
			this.symptom = symptom;
			this.history = history;
		}
		public PatientDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    
	    
}

