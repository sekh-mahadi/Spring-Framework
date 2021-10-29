package io.mtech.spring_mvc.service;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService implements GenericWelcomeService {

	@Override
	public List<String> getWelcomeMessage(String name) {
		List<String> myWelcomeMessage = new ArrayList<String>();

		myWelcomeMessage.add("Hello");
		myWelcomeMessage.add(name);
		myWelcomeMessage.add(", welcome to the Spring course.");
		return myWelcomeMessage;
	}

}
