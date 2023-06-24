package io.mtech.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.mtech.springmvc.entity.Customer;

@Repository
public interface CustomerDAO {
	
	public List<Customer> getCustomers();
}
