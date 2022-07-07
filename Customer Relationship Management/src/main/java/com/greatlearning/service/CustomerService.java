package com.greatlearning.service;

import java.util.List;

import com.greatlearning.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomer();

	public Customer getCustomerById(Long id);

	public void addCustomer(Customer customer);

	public void deleteCustomer(Long id);

}
