package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.insurance.model.Insurance;
import com.insurance.model.User;
import com.insurance.serviceImpl.InsuranceServiceImpl;

@Controller
public class InsuranceController {

	@Autowired
	private InsuranceServiceImpl insuranceServiceImpl;

	@GetMapping("/insurance")
	public ResponseEntity<List<Insurance>> getInsuranceList() {
		List<Insurance> insuranceList = insuranceServiceImpl.getInsuranceList();
		return new ResponseEntity<List<Insurance>>(insuranceList, HttpStatus.OK);
	}

	@PostMapping("/insurance/{insuranceId}")
	public ResponseEntity<List<User>> saveUser(@RequestBody List<User> userList, @PathVariable Integer insuranceId) {
		List<User> savedUsers = insuranceServiceImpl.saveUsers(userList,insuranceId);
		return new ResponseEntity<List<User>>( savedUsers,HttpStatus.CREATED);
	}

}
