/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interview.crud.services;

import com.interview.crud.GlobalHelper;
import com.interview.crud.dao.CustomerDao;
import com.interview.crud.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alvin
 */
@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public List<Customer> findAll() {
        List<Customer> customerList = customerDao.findAll();
        return customerList;
    }

    public long count() {
        long countItem = customerDao.count();
        return countItem;
    }

    public List<Customer> findByCustomerName(String customerName) {
        List<Customer> customerList = customerDao.findByName(customerName);
        return customerList;
    }

    public Customer findById(Integer id) {
        Customer customer = customerDao.findOne(id);
        return customer;
    }

    public Customer create(Customer customer) {
        return customerDao.save(customer);
    }

    public Customer update(Customer customer) {
        Customer customerTemp = customerDao.findOne(customer.getId());
        GlobalHelper.copyNonNullProperties(customer, customerTemp);
        return customerDao.save(customerTemp);
    }

    public void delete(Integer id) {
        customerDao.deleteById(id);
    }

}
