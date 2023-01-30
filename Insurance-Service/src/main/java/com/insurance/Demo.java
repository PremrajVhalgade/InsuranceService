package com.insurance;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	
	public static void main(String[] args) throws JsonProcessingException {

//		List<User> userList = new ArrayList<User>();
//		Policy policy = new Policy();
//
//		userList.add(new User("Gautam Jabhade", LocalDate.of(1966, 03, 17), "Self"));
//		userList.add(new User("Surekha Jabhade", LocalDate.of(1974, 07, 31), "Mother"));
//		policy.setUserList(userList);
		
		Policy policy = new Policy();
		policy.setFromDate(LocalDateTime.now());
		policy.setToDate(LocalDateTime.now().plusDays(365L));
		policy.setInsuranceId(5);
	

		User user1 = new User();
		user1.setDob(LocalDate.of(1996, 06, 22));
		user1.setFullName("Premraj Vhalgade");
		user1.setRelation("Self");

		User user2 = new User();
		user2.setDob(LocalDate.of(1996, 12, 02));
		user2.setFullName("Prachi Vhalgade");
		user2.setRelation("Wife");
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);

		for (User u : userList) {
			u.setPolicy(policy);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		String string = mapper.writeValueAsString(user1);
		System.out.println(string);
		
	}

}
