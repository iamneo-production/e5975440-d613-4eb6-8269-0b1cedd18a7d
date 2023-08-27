package com.hackathon.team15.medicationservice.exception;

public class NoSuchMedicationExistsException extends RuntimeException{
    
    public NoSuchMedicationExistsException(String msg)
    {
        super(msg);
    }
}
