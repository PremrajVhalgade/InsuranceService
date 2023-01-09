package com.insurance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entity.Insurance;
import com.insurance.entity.Report;
import com.insurance.entity.User;
import com.insurance.serviceImpl.InsuranceServiceImpl;
import com.insurance.serviceImpl.ReportPdfExporter;
import com.lowagie.text.DocumentException;

@RestController
public class InsuranceController {

	@Autowired
	private InsuranceServiceImpl insuranceServiceImpl;

	@GetMapping("/insurance")
	public ResponseEntity<List<Insurance>> getInsuranceList() {
		List<Insurance> insuranceList = insuranceServiceImpl.getInsuranceList();
		return new ResponseEntity<List<Insurance>>(insuranceList, HttpStatus.OK);
	}

	@PostMapping("/insurance/{insuranceId}")
	public ResponseEntity<String> saveUser(@RequestBody List<User> userList, @PathVariable Integer insuranceId) {
		String output = insuranceServiceImpl.saveUsers(userList, insuranceId);
		return new ResponseEntity<String>(output, HttpStatus.CREATED);
	}

	@GetMapping("/insurance/{insuranceId}/generatereport")
	public ResponseEntity<String> generateUpdatedReport(HttpServletResponse response, @PathVariable Integer insuranceId)
			throws DocumentException, IOException {
		System.out.println("inside insuranceController " + insuranceId);
		this.insuranceServiceImpl.createReport(insuranceId);
		List<Report> report = insuranceServiceImpl.generateReport();

		ReportPdfExporter exporter = new ReportPdfExporter(report);
		exporter.export(response);
		return new ResponseEntity<String>("Generated Report successfully", HttpStatus.OK);
	}

}
