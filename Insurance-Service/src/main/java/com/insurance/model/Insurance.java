package com.insurance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Insurance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int insuranceId;
	private String companyName;
	private String insuranceType;
	private String planName;
	private String sumAssured;
	private String annualPremium;
	private String monthlyPremium;
	
	@OneToOne(targetEntity = Policy.class)
	private Policy policy;

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(String sumAssured) {
		this.sumAssured = sumAssured;
	}

	public String getAnnualPremium() {
		return annualPremium;
	}

	public void setAnnualPremium(String annualPremium) {
		this.annualPremium = annualPremium;
	}

	public String getMonthlyPremium() {
		return monthlyPremium;
	}

	public void setMonthlyPremium(String monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}
		
	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", companyName=" + companyName + ", insuranceType="
				+ insuranceType + ", planName=" + planName + ", sumAssured=" + sumAssured + ", annualPremium="
				+ annualPremium + ", monthlyPremium=" + monthlyPremium + ", policy=" + policy + "]";
	}

	

	
	

}
