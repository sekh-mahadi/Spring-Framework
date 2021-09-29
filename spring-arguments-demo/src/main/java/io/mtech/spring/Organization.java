package io.mtech.spring;

public class Organization {
	private String companyName;
	private int yearOfIncorporation;

	public Organization(String companyName, int yearOfIncorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
	}

	public Organization() {
		// TODO Auto-generated constructor stub
	}

	public void corporateMtech() {
		String slogan = "We develop the secure software.";
		System.out.println(slogan);
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation + "]";
	}

}
