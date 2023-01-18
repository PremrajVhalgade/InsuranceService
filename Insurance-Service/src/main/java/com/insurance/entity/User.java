package com.insurance.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int memberId;
	private String fullName;
	private LocalDate dob;
	private String relation;

	@ManyToOne
	private Policy policy;
	
	public User( String fullName, LocalDate dob, String relation) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.relation = relation;
	
	}
	public User() {
		
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
		
	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "User [memberId=" + memberId + ", fullName=" + fullName + ", dob=" + dob + ", relation=" + relation
				+ ", policy=" + policy + "]";
	}
	
}
