package com.hackathon.team15.medicationservice.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseDto {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
