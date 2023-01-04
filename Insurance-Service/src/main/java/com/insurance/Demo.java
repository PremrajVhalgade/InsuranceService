package com.insurance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.insurance.model.User;

//public class Demo {
//
//	public static void main(String[] args) throws JsonProcessingException {
//
//		List<User> userlist = new ArrayList<User>();
//		userlist.add(new User("Laxman Mule", LocalDate.of(1991, 3, 27), "Self"));
//		userlist.add(new User("Vinita mule", LocalDate.of(1995, 5, 15), "Wife"));
//		userlist.add(new User("Shruti mule", LocalDate.of(2020, 4, 12), "Daughter"));
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.registerModule(new JavaTimeModule());
//		String string = mapper.writeValueAsString(userlist);
//		System.out.println(string);
//
//	}
//
//}
