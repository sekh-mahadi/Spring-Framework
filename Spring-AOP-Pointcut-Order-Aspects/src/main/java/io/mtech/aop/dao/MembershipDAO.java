package io.mtech.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass()
		        + ": DOING STUFF :ADDING A MEMBERSHIP ACCOUNT.");
	}

	public boolean addSillyMember() {
		System.out.println(getClass()
		        + ": DOING STUFF :ADDING A MEMBERSHIP SILLY.");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass()+": I am going to Sleep.");
	}
}
