package com.insurance.service;

import java.util.List;

import com.insurance.entity.Insurance;
import com.insurance.entity.User;

public interface InsuranceService {

	List<Insurance> getInsuranceList();

	String saveUsers(List<User> userList, int insuranceId);

	List<Object> createReport(int insuranceId);

}
