package com.insurance.entity;

public class ReportWithInsuranceName extends Report {
	private String insuranceName;

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	@Override
	public String toString() {
		return "ReportWithInsuranceName [insuranceName=" + insuranceName + "]";
	}
}
