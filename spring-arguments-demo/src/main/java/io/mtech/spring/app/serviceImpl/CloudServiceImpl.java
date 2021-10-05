package io.mtech.spring.app.serviceImpl;

import java.util.Random;

import io.mtech.spring.app.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	@Override
	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Organization, " + companyName + " offers world class Cloud computing infrastructure."
				+ "\nThe annual income exceeds " + random.nextInt(revenue) + "dollars.";

		return service;
	}

}
