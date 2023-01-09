package com.insurance.repo;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.insurance.entity.Report;

@Repository
public interface ReportRepo extends JpaRepository<Report, Integer> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE report SET from_date=?1 ,to_date=?2 ,insurance_id=?3, policy_id=?4, policy_name=?5, policy_type=?6, user_name=?7, no_of_policies=?8", nativeQuery = true)
	void generateUpdatedReport(LocalDateTime from_date, LocalDateTime to_date, Integer insurance_id, Integer policy_id,
			String policy_name, String policy_type, String user_name, Integer no_of_policies);

	@Query(value = "SELECT insurance_id COUNT(*) FROM report GROUP BY insurance_id", nativeQuery = true)
	Integer fetchNoOfPolicies(Integer insuranceId);
	// SELECT productVendor, COUNT(*)FROM products GROUP BY productVendor ORDER BY
	// COUNT(*) DESC;

	@Modifying
	@Transactional
	@Query(value = "TRUNCATE TABLE report", nativeQuery = true)
	void truncateReportTable();

}
