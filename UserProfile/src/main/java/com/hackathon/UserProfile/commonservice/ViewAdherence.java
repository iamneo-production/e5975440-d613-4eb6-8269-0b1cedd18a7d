package com.hackathon.UserProfile.commonservice;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.hackathon.UserProfile.model.Patient;

@FeignClient(name = "adherenceservice")
public interface ViewAdherence {

    @DeleteMapping("/adherence/deleteAdherenceByUserId")
	public String deleteAdherenceByUserId(@RequestParam(value = "id" , required = true) int userId );
    
}
