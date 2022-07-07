package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.CustomerDaoImpl;
import com.greatlearning.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDaoImpl customerDaoImpl;

	@Override
	public List<Customer> getAllCustomer() {

		return customerDaoImpl.getAllCustomer();

	}

	@Override
	public Customer getCustomerById(Long id) {

		return customerDaoImpl.getCustomerById(id);

	}

	@Override
	public void addCustomer(Customer customer) {

		customerDaoImpl.addCustomer(customer);

	}

	@Override
	public void deleteCustomer(Long id) {

		customerDaoImpl.deleteCustomer(id);

	}

}
