package io.mtech.aop.dao;

import org.springframework.stereotype.Component;

import io.mtech.aop.entity.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public String getName() {
		System.out.println(getClass() + ": In getName()");

		return this.name;
	}
	public void setName(String name) {
		System.out.println(getClass() + ": In setName()");

		this.name = name;
	}
	public String getServiceCode() {
		System.out.println(getClass() + ": InGetServiceCode()");
		return this.serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": InSetServiceCode()");

		this.serviceCode = serviceCode;
	}
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT.");
	}
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return true;
	}

}
