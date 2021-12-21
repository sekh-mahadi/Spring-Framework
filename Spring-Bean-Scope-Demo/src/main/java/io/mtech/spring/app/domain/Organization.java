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
		//System.out.println(" constructor called");

	}

	public Organization() {
		System.out.println("Default constructor called");
	}

	/*
	 * public void initialize() {
	 * System.out.println("organization: initialize method called"); }
	 * 
	 * public void destroy() {
	 * System.out.println("organization: Destroy method  called"); }
	 */
	
	public void postConstruct() {
		System.out.println("Organization: PostConstruct called.......");
	}
	public void preDestroy() {
		System.out.println("Organization: preDestroy called........ ");
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
		System.out.println("SetCompanyName called");

	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("SetEmployeeCount called");

	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("setPostalCode called");

	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("setSlogan called");

	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("setBusinessService called");

	}

	public String corporateSlogan() {
		return slogan;
	}

	public String corporateService() {
		return businessService.offerService(companyName);

	}
	
	public static Organization createInstance(String companyName, int yearOfIncorporation) {
		System.out.println("Invoking the static factory method.....");
		return new Organization(companyName, yearOfIncorporation);
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", slogan=" + slogan + ", employeeCount=" + employeeCount + "]";
	}

}
