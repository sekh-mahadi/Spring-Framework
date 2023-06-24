package io.mtech.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.mtech.springmvc.dao.CustomerDAO;
import io.mtech.springmvc.entity.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> getCustomers() {

		return customerDAO.getCustomers();
	}

}
