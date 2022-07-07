package com.greatlearning.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory sessionFactory;
	private Session session;

	public CustomerDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

		try {
			session = sessionFactory.getCurrentSession();

		} catch (HibernateException e) {

			session = sessionFactory.openSession();

		}

	}

	@Override
	public List<Customer> getAllCustomer() {

		Transaction transaction = session.beginTransaction();

		List<Customer> customers = session.createQuery("from Customer").list();

		transaction.commit();

		return customers;
	}

	@Override
	public Customer getCustomerById(Long id) {

		Transaction transaction = session.beginTransaction();

		Customer customer = session.get(Customer.class, id);

		transaction.commit();

		return customer;

	}

	@Override
	public void addCustomer(Customer customer) {

		Transaction transaction = session.beginTransaction();

		session.save(customer);

		transaction.commit();

	}

	@Override
	public void deleteCustomer(Long id) {

		Transaction transaction = session.beginTransaction();

		Customer customer = session.get(Customer.class, id);

		session.delete(customer);

		transaction.commit();

	}

}
