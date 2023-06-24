package io.mtech.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.mtech.springmvc.entity.Customer;


public interface CustomerService {

	List<Customer> getCustomers();
}
