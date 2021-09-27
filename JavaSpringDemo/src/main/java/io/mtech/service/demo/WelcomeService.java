package io.mtech.service.demo;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService {
	
public List<String> getMyWelcomeMessage(String name) {
	List<String> myWelcomeMessage = new ArrayList<String>();

	myWelcomeMessage.add("Hello");
	myWelcomeMessage.add(name);
	myWelcomeMessage.add(", welcome to the Spring course.");
	return myWelcomeMessage;
}

}
