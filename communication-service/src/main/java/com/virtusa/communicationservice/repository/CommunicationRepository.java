package com.virtusa.communicationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.communicationservice.dto.CommunicationDto;

@Repository
public interface CommunicationRepository extends JpaRepository<CommunicationDto, Long> {

	List<CommunicationDto> findByPatientId(Long pId);
	List<CommunicationDto> findByHealthCareId(Long pId);
}
