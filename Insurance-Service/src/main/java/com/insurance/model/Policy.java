package com.insurance.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyId;
	@CreationTimestamp
	private LocalDateTime fromDate;
	
	private LocalDateTime toDate; 
	
	@OneToMany(mappedBy = "policy")
	private List<User> userList=new ArrayList<User>();
	
	@OneToOne
	private Insurance insurance;

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

	public void setToDate(LocalDateTime fromDate) {
		LocalDateTime toDate2 = fromDate.plusDays(365);
		this.toDate=toDate2;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", fromDate=" + fromDate + ", toDate=" + toDate + ", userList="
				+ userList + ", insurance=" + insurance + "]";
	}
	
	

	
	
	

}
