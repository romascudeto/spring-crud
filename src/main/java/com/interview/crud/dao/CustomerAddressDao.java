/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interview.crud.dao;

import com.interview.crud.models.Customer;
import com.interview.crud.models.CustomerAddress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Alvin
 */
public interface CustomerAddressDao extends PagingAndSortingRepository<CustomerAddress, Integer> {
    @Query("SELECT ca FROM CustomerAddress ca")
    public List<CustomerAddress> findAll();

    @Query("SELECT ca FROM CustomerAddress ca WHERE ca.id = :id")
    public CustomerAddress findOne(@Param("id") Integer id);
}
