package com.reminder.reminderservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicationId;
    private int patientId;
    private String medicationName;
    private String dosage;
    private String frequency;
    private LocalDateTime startDate;
    private LocalTime reminderTime;
    private LocalDateTime endDate;

}