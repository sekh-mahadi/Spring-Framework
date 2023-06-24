package io.mtech.springmvc.service;

import java.util.List;

import io.mtech.springmvc.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);
}
