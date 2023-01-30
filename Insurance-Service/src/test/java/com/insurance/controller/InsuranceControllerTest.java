package com.insurance.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import com.insurance.entity.Insurance;
import com.insurance.repo.InsuranceRepo;
import com.insurance.test.utils.Datagenerator;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:/application-junit.properties")
public class InsuranceControllerTest {
	@Autowired
	private InsuranceRepo insuranceRepo;
	private RequestSpecification requestSpecification;

	@LocalServerPort
	private int port;

	@PostConstruct
	public void initRequestSpecification() {
		final RequestSpecBuilder tempSpec = new RequestSpecBuilder();
		tempSpec.setBaseUri("http://localhost:" + port + "/insurance").build();
	}

	@Test
	public void testGetInsuranceList_withValidData_OK() {
		// Given
		List<Insurance> insuranceList = Datagenerator.saveInsurance();
		insuranceRepo.saveAll(insuranceList);
		// When
		ValidatableResponse response = RestAssured.when().get("/").then();
		// Then
		int statusCode = response.extract().statusCode();
		assertEquals(200, statusCode);

	}

	//@Test
//	public void testSaveUser_withValidData_OK() {
//		// Given
//
//		// When
//		ValidatableResponse response = RestAssured.when().get("/").then();
//		// Then
//		int statusCode = response.extract().statusCode();
//		assertEquals(200, statusCode);
//
//	}

}
