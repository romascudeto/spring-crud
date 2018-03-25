/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interview.crud.services;

import com.interview.crud.GlobalHelper;
import com.interview.crud.dao.CustomerAddressDao;
import com.interview.crud.models.CustomerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alvin
 */
@Service
public class CustomerAddressService {
    @Autowired
    CustomerAddressDao customerAddressDao;

    public List<CustomerAddress> findAll() {
        List<CustomerAddress> customerAddressList = customerAddressDao.findAll();
        return customerAddressList;
    }

    public long count() {
        long countItem = customerAddressDao.count();
        return countItem;
    }


    public CustomerAddress findById(Integer id) {
        CustomerAddress customerAddress = customerAddressDao.findOne(id);
        return customerAddress;
    }

    public CustomerAddress create(CustomerAddress customerAddress) {
        return customerAddressDao.save(customerAddress);
    }

    public CustomerAddress update(CustomerAddress customerAddress) {
        CustomerAddress customerAddressTemp = customerAddressDao.findOne(customerAddress.getId());
        GlobalHelper.copyNonNullProperties(customerAddress, customerAddressTemp);
        return customerAddressDao.save(customerAddressTemp);
    }

    public void delete(Integer id) {
        customerAddressDao.deleteById(id);
    }

}
