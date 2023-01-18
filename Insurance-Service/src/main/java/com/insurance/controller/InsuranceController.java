package com.insurance.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entity.Insurance;
import com.insurance.entity.User;
import com.insurance.serviceImpl.InsuranceServiceImpl;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping(value = "/insurance")
public class InsuranceController {

	@Autowired
	private InsuranceServiceImpl insuranceServiceImpl;

	@GetMapping("/")
	public ResponseEntity<List<Insurance>> getInsuranceList() {
		List<Insurance> insuranceList = insuranceServiceImpl.getInsuranceList();
		return new ResponseEntity<List<Insurance>>(insuranceList, HttpStatus.OK);
	}

	@PostMapping("/{insuranceId}")
	public ResponseEntity<String> saveUser(@RequestBody List<User> userList, @PathVariable Integer insuranceId) {
		String output = insuranceServiceImpl.saveUsers(userList, insuranceId);
		
			return new ResponseEntity<String>(output, HttpStatus.CREATED);
	}

	@GetMapping("/generatereport/{policyId}")
	public ResponseEntity<String> generateReport(@PathVariable int policyId)
			throws DocumentException, URISyntaxException, IOException {
		 List<Object> createdReport = insuranceServiceImpl.createReport(policyId);
		 insuranceServiceImpl.generatePdf(createdReport);
		// insuranceServiceImpl.generatePdf(policyId);
		

		return new ResponseEntity<String>("Generated Report successfully", HttpStatus.OK);
	}

}
