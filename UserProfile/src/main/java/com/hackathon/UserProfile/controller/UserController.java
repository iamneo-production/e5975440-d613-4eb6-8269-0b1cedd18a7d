package com.hackathon.UserProfile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.UserProfile.model.Patient;
import com.hackathon.UserProfile.model.User;
import com.hackathon.UserProfile.modeldto.SignUpResponse;
import com.hackathon.UserProfile.modeldto.UserModelDto;
import com.hackathon.UserProfile.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public SignUpResponse saveUser(@RequestBody UserModelDto user) {
		System.out.println("Name of User"+user.getFirstName() + "   "+user.getLastName());
		return userService.saveUser(user);
	}
	
	@CircuitBreaker(name="${spring.application.name}" , fallbackMethod= "getUserInfoByFallBackMethod")
	@GetMapping("/getUser")
	public User getUser(@RequestParam(value="id" , required = true) int userId){
		return userService.getUser(userId);
	}
	
	//creating fallback method  for circuit Breker
	public User getUserInfoByFallBackMethod(@RequestParam(value="id" , required = true) int userId, Exception ex){
		User user=new User("12345", "Dummy Role", "Dummy First Name", "Dummy Last Name", "9876543210", "*******");
		return user;
	}
	
	

	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}

	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam(value = "id" , required = true) int  userId) {
		return userService.deleteUser(userId);
	}

	@PutMapping("/editUser")
	public String editUser(@RequestBody UserModelDto userModel, @RequestParam(value = "id") int userId) {
		return userService.editUser(userModel,userId);
	}
}
