package com.insurance.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.insurance.entity.Insurance;
import com.insurance.entity.Policy;
import com.insurance.entity.Report;
import com.insurance.entity.User;
import com.insurance.repo.InsuranceRepo;
import com.insurance.repo.PolicyRepo;
import com.insurance.repo.ReportRepo;
import com.insurance.repo.UserRepo;
import com.insurance.service.InsuranceService;

@Service
@Transactional
public class InsuranceServiceImpl implements InsuranceService {
	private static final Logger log = LoggerFactory.getLogger(InsuranceServiceImpl.class);

	@Autowired
	private InsuranceRepo insuranceRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PolicyRepo policyRepo;
	@Autowired
	private ReportRepo reportRepo;

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
		log.info("Saved policy for {}", savedPolicy.getPolicyId());

		List<User> finalList = new ArrayList<>();
		for (User user : userList) {
			user.setPolicy(savedPolicy);
			finalList.add(user);
		}
		userRepo.saveAll(finalList);
		return "Details Saved";
	}

	@Override
	public void createReport(Integer insuranceId) {
		List<Integer> fetchedPolicyId = this.policyRepo.fetchPolicyNo(insuranceId);// here fetchedPolicyId= no. of
																					// policies corresponding to
																					// insuranceId
	//	Integer noOfPolicies = fetchedPolicyId.size();
		this.reportRepo.truncateReportTable();
		System.out.println("@@@@ Truncated table successfully @@@@");
		for (Integer i : fetchedPolicyId) {
			LocalDateTime fetchedFromDate = this.policyRepo.fetchFromDate(i);
			LocalDateTime fetchedToDate = this.policyRepo.fetchToDate(i);
			String fetchedPolicyName = this.userRepo.fetchPolicyName(insuranceId);
			String fetchedPolicyType = this.userRepo.fetchPolicyType(insuranceId);
			String fetchedUserName = this.userRepo.fetchUserName(i);

			Report report = new Report();
			report.setPolicyId(i);
			report.setPolicyName(fetchedPolicyName);
			report.setPolicyType(fetchedPolicyType);
			report.setInsuranceId(insuranceId);
			report.setUserName(fetchedUserName);
			report.setFromDate(fetchedFromDate);
			report.setToDate(fetchedToDate);
			report.setNoOfPolicies(fetchedPolicyId.size());

			System.out.println(report);		
			System.out.println("report updated to db");
			this.reportRepo.save(report);
		}
		}

	public List<Report> generateReport() {
		return reportRepo.findAll(Sort.by("srNo").ascending());
	}

}
