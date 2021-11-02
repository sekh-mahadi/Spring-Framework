package io.mtech.spring.app.serviceImpl;

import java.util.Random;

import io.mtech.spring.app.service.BusinessService;

public class EcommerceServiceImpl implements BusinessService {

	@Override
	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Organization, " + companyName + " provides an outstanding a Ecommerce platform."
				+ "\nthe annaual revenue exceeds " + random.nextInt(revenue);
		return service;
	}

}
