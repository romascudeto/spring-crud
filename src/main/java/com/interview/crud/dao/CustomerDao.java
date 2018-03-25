/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interview.crud.dao;

import com.interview.crud.models.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Alvin
 */
public interface CustomerDao extends PagingAndSortingRepository<Customer, Integer> {
    public List<Customer> findByName(String customerName);

    @Query("SELECT c FROM Customer c")
    public List<Customer> findAll();

    @Query("SELECT c FROM Customer c WHERE c.id = :id")
    public Customer findOne(@Param("id") Integer id);
}
