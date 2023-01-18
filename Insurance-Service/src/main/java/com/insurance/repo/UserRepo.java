package com.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurance.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value = "select user from policy where insurance_id=?", nativeQuery = true)
	Integer fetchPolicyNo(Integer insuranceId);

	@Query(value = "select plan_name from insurance where insurance_id=?", nativeQuery = true)
	String fetchPolicyName(Integer insuranceId);

	@Query(value = "select insurance_type from insurance where insurance_id=?", nativeQuery = true)
	String fetchPolicyType(Integer insuranceId);

	@Query(value = "select full_name from user where policy_policy_id=? and relation='Self'", nativeQuery = true)
	String fetchUserName(Integer policyId);

	

}
