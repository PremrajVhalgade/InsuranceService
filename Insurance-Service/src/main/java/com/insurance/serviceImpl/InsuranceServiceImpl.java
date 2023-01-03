package com.insurance.serviceImpl;

import java.util.List;

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

	@Autowired
	private InsuranceRepo insuranceRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PolicyRepo policyRepo;

	@Override
	public List<Insurance> getInsuranceList() {
		List<Insurance> allInsurances = this.insuranceRepo.findAll();
		return allInsurances;
	}

	@Override
	public List<User> saveUsers(List<User> userList, Integer insuranceId) {
		Policy policy = new Policy();
		policy.setUserList(userList);
		Insurance insurance = this.insuranceRepo.findById(insuranceId)
				.orElseThrow(() -> new ResourceNotFoundException("Insurance", "insuranceId", insuranceId));
		insurance.setPolicy(policy);
		Policy savedPolicy = this.policyRepo.save(policy);
		List<User> savedUsers = this.userRepo.saveAll(userList);
		return savedUsers;
	}

	
}
