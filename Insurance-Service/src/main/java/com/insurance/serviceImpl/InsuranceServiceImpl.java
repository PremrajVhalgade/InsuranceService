package com.insurance.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.Insurance;
import com.insurance.model.Policy;
import com.insurance.model.User;
import com.insurance.repo.InsuranceRepo;
import com.insurance.repo.PolicyRepo;
import com.insurance.repo.UserRepo;
import com.insurance.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	private static final Logger log = LoggerFactory.getLogger(InsuranceServiceImpl.class);

	@Autowired
	private InsuranceRepo insuranceRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PolicyRepo policyRepo;

	@Override
	public List<Insurance> getInsuranceList() {
		List<Insurance> allInsurances = insuranceRepo.findAll();
		return allInsurances;
	}

	@Override
	public String saveUsers(List<User> userList, int insuranceId) {
		log.info("Saving policy details in database");
		Policy policy = new Policy();
		policy.setInsuranceId(insuranceId);
		policy.setToDate(LocalDateTime.now());
		System.out.println(userList);
		policy.setUserList(userList);
		Policy savedPolicy = policyRepo.save(policy);
		log.info("Saved policy for {}" ,savedPolicy.getPolicyId());
		
		List<User> finalList = new ArrayList<>();
		for(User user:userList) {
			user.setPolicy(savedPolicy);
			finalList.add(user);
		}
		userRepo.saveAll(finalList);
		return "Details Saved";
	}

	
}
