package com.insurance.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int srNo;
	private int insuranceId;
	private Integer policyId;
	private String policyName;
	private String policyType;
	private String userName;// self only
	private LocalDateTime fromDate;
	private LocalDateTime toDate;
	private Integer noOfPolicies;

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDateTime getToDate() {
		return toDate;
	}

	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}

	public Integer getNoOfPolicies() {
		return noOfPolicies;
	}

	public void setNoOfPolicies(Integer noOfPolicies) {
		this.noOfPolicies = noOfPolicies;
	}

	@Override
	public String toString() {
		return "Report [srNo=" + srNo + ", insuranceId=" + insuranceId + ", policyId=" + policyId + ", policyName="
				+ policyName + ", policyType=" + policyType + ", userName=" + userName + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", noOfPolicies=" + noOfPolicies + "]";
	}

	

}
