package com.insurance.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyId;
	
	@CreationTimestamp
	private LocalDateTime fromDate;
	
	private LocalDateTime toDate; 
	
	private int InsuranceId;
	
	@OneToMany(mappedBy = "policy")
	private List<User> userList=new ArrayList<User>();

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
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

	public void setToDate(LocalDateTime Date) {
		this.toDate = Date.plusDays(365);
	}

	public int getInsuranceId() {
		return InsuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		InsuranceId = insuranceId;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", fromDate=" + fromDate + ", toDate=" + toDate + ", InsuranceId="
				+ InsuranceId + ", userList=" + userList + "]";
	}
	
}
