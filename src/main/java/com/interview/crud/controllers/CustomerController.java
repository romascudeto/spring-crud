/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interview.crud.controllers;

import com.interview.crud.models.Customer;
import com.interview.crud.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Alvin
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/customer/count", method = RequestMethod.GET)
    public long count() {
        return customerService.count();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customer")
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customer")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customer")
    public void delete(@RequestBody Customer customer) {
        customerService.delete(customer.getId());
    }

}
