package com.insurance.service;

import java.util.List;

import com.insurance.model.Insurance;
import com.insurance.model.Policy;
import com.insurance.model.User;

public interface InsuranceService {

	List<Insurance> getInsuranceList();
	
	List<User> saveUsers(List<User> userList,Integer insuranceId);
}
