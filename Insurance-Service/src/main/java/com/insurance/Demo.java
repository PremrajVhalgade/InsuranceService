package com.insurance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.insurance.entity.Policy;
import com.insurance.entity.User;

public class Demo {

	public static void main(String[] args) throws JsonProcessingException {

		List<User> userList = new ArrayList<User>();
		userList.add(new User("Shubham Vhalgade", LocalDate.of(1999,07,31), "Self"));
		userList.add(new User("Gita Vhalgade", LocalDate.of(1993,01,25), "Wife"));
		userList.add(new User("Ladu Vhalgade", LocalDate.of(2020,03,17), "Daughter"));

//		Policy policy = new Policy();
//	
//		List<User> finalList = new ArrayList<User>();
//		for (User user : userList) {
//			user.setPolicy(policy);
//			finalList.add(user);
//		}
//		
//		policy.setUserList(finalList);

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		String string = mapper.writeValueAsString(userList);
		System.out.println(string);

	}

}
