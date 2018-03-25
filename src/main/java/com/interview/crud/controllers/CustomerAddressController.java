/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interview.crud.controllers;

import com.interview.crud.models.CustomerAddress;
import com.interview.crud.services.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alvin
 */
@RestController
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    @RequestMapping(value = "/customerAddress", method = RequestMethod.GET)
    public List<CustomerAddress> findAll() {
        return customerAddressService.findAll();
    }

    @RequestMapping(value = "/customerAddress/count", method = RequestMethod.GET)
    public long count() {
        return customerAddressService.count();
    }

    @RequestMapping(value = "/customerAddress/{id}", method = RequestMethod.GET)
    public CustomerAdhttps://alvinlesmana88@bitbucket.org/alvinlesmana88/brainmatics.gitdress findById(@PathVariable Integer id) {
        return customerAddressService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customerAddress")
    public CustomerAddress create(@RequestBody CustomerAddress customerAddress) {
        return customerAddressService.create(customerAddress);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customerAddress")
    public CustomerAddress update(@RequestBody CustomerAddress customerAddress) {
        return customerAddressService.update(customerAddress);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customerAddress")
    public void delete(@RequestBody CustomerAddress customerAddress) {
        customerAddressService.delete(customerAddress.getId());
    }

}
