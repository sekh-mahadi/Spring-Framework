package io.mtech.spring.app.serviceImpl;

import java.util.Random;

import io.mtech.spring.app.service.RecruitmentService;

public class RefferalRecruitmentServiceImpl implements RecruitmentService {

	@Override
	public String recruitmentEmployees(String companyName, String departmentName, int numberOfRecruitments) {
		Random random = new Random();
		String hiringFacts = "\n" + companyName + "'s " + departmentName + " hired  " +
						random.nextInt(numberOfRecruitments) + " employees " +
						" which were referred to the company by employees.";
		return hiringFacts;
		
	}

}
