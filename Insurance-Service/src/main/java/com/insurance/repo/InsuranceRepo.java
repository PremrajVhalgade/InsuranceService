package com.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurance.entity.Insurance;

@Repository
public interface InsuranceRepo extends JpaRepository<Insurance, Integer> {
	@Query(value = "SELECT company_name FROM insurance WHERE insurance_id=?1", nativeQuery = true)
	String getInsuranceName(int insurance_id);

}
