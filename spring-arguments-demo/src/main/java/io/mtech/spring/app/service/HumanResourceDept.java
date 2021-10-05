package io.mtech.spring.app.service;

import io.mtech.spring.app.domain.Organization;

public class HumanResourceDept implements Department {

	private String deptName;
	private RecruitmentService recruitmentService;
	private Organization organization;

	public HumanResourceDept(RecruitmentService recruitmentService, Organization organization) {
		this.recruitmentService = recruitmentService;
		this.organization = organization;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String hiringStatus(int numberOfRecruitments) {
		String hiringFacts = recruitmentService.recruitmentEmployees(organization.getCompanyName(), 
				deptName, numberOfRecruitments);
		return hiringFacts;
	}

	@Override
	public String toString() {
		return "HumanResourceDept [organization=" + organization + "]";
	}
	
	

}
