package io.mtech.aop.dao;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println(getClass()
		        + ": DOING MY DB WORK: ADDING AN ACCOUNT.");
	}
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return true;
	}

	// Add a new a method: findsAccounts()
	public List<Account> findAccounts(boolean tripWire) {
		List<Account> myAccounts = new ArrayList<>();

		if (tripWire) {
			throw new RuntimeException("No Soup for you.");
		}

		// create sample Accounts
		Account temp1 = new Account("Sekh", "Platinum");
		Account temp2 = new Account("Madhu", "Gold");
		Account temp3 = new Account("Sohana", "Silver");

		// add to our list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		return myAccounts;
	}

}
