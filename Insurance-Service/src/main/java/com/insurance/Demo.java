package com.insurance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.insurance.entity.Policy;
import com.insurance.entity.User;
import com.insurance.repo.PolicyRepo;

public class Demo {
	@Autowired
	private PolicyRepo policyRepo;

	public void test(int policyId) {

		Policy policyDetails = policyRepo.getPolicyDetails(policyId);
		int insuranceId = policyDetails.getInsuranceId();
		policyDetails.getFromDate();
		policyDetails.getToDate();
		System.out.println(policyDetails);
	}

	public static void main(String[] args) throws JsonProcessingException {

//		List<User> userList = new ArrayList<User>();
//		Policy policy = new Policy();
//
//		userList.add(new User("Gautam Jabhade", LocalDate.of(1966, 03, 17), "Self"));
//		userList.add(new User("Surekha Jabhade", LocalDate.of(1974, 07, 31), "Mother"));
//		policy.setUserList(userList);
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.registerModule(new JavaTimeModule());
//		String string = mapper.writeValueAsString(userList);

		Demo demo=new Demo();
		demo.test(1);
	}

}
