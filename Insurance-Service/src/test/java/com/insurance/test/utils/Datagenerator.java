package com.insurance.test.utils;

import java.util.ArrayList;
import java.util.List;

import com.insurance.entity.Insurance;
import com.insurance.repo.InsuranceRepo;

public class Datagenerator {

	public static List<Insurance> saveInsurance() {

		List<Insurance> insuranceList = new ArrayList<Insurance>();
		insuranceList.add(new Insurance("Religare", "Health Insurance", "Star Plan", 500000, 1067, 12800));
//		insuranceList.add(new Insurance("Digit", "Health Insurance", "Master Plan", 500000, 1267, 15200));
	//	insuranceList.add(null);
		return insuranceList;
	}
}
