package com.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Insurance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int insuranceId;
	private String companyName;
	private String insuranceType;
	private String planName;
	private int sumAssured;
	private int annualPremium;
	private int monthlyPremium;
	
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
	public int getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(int sumAssured) {
		this.sumAssured = sumAssured;
	}
	public int getAnnualPremium() {
		return annualPremium;
	}
	public void setAnnualPremium(int annualPremium) {
		this.annualPremium = annualPremium;
	}
	public int getMonthlyPremium() {
		return monthlyPremium;
	}
	public void setMonthlyPremium(int monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}
	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", companyName=" + companyName + ", insuranceType="
				+ insuranceType + ", planName=" + planName + ", sumAssured=" + sumAssured + ", annualPremium="
				+ annualPremium + ", monthlyPremium=" + monthlyPremium + "]";
	}

	

	
	

}
