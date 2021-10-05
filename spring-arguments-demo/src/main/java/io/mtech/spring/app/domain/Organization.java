package io.mtech.spring.app.domain;

import io.mtech.spring.app.service.BusinessService;

public class Organization {
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private String slogan;
	private int employeeCount;

	private BusinessService businessService;

	public Organization(String companyName, int yearOfIncorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
	}

	public Organization() {
		// TODO Auto-generated constructor stub
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public String corporateSlogan() {
		return slogan;
	}

	public String corporateService() {
		return businessService.offerService(companyName);

	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", slogan=" + slogan + ", employeeCount=" + employeeCount + "]";
	}


}
