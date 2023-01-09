package com.insurance.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurance.entity.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Integer> {

	@Query(value = "select policy_id from policy where insurance_id=?", nativeQuery = true)
	List<Integer> fetchPolicyNo(Integer insuranceId);

	@Query(value = "select from_date from policy where policy_id=?", nativeQuery = true)
	LocalDateTime fetchFromDate(Integer policyNo);
	
	@Query(value = "select to_date from policy where policy_id=?", nativeQuery = true)
	LocalDateTime fetchToDate(Integer policyNo);

	
}
