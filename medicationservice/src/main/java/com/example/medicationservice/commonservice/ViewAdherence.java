package com.example.medicationservice.commonservice;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.medicationservice.model.Adherence;


@FeignClient(name = "adherenceservice")
public interface ViewAdherence {

	@GetMapping("/adherence/getAdherenceByMedicationId")
	public  List<Adherence> getAdherenceByMedicationId(@RequestParam(value="id" , required = true) int medicationId);
}