package com.hackathon.team15.medicationservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Adherence")
public class Adherence {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int adherenceId;

    private LocalDateTime adherenceDate;
    private boolean medicineTaken;

    private int medicationId;

    private int patientId;
}