package com.example.reminderservice.commonservice;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.reminderservice.modeldto.User;

@FeignClient(name = "userprofile")
public interface ViewUser {
	
	@GetMapping("/user/getUser")
	public User getUser(@RequestParam(value="id" , required = true) int userId);

}
