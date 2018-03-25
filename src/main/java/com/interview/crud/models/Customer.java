/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interview.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.criteria.Order;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Alvin
 */
@Entity
@DynamicUpdate
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String remarks;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private List<CustomerAddress> customerAddressList;

    public Customer(String name, String remarks, List<CustomerAddress> customerAddressList) {
        this.name = name;
        this.remarks = remarks;
        this.customerAddressList = customerAddressList;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<CustomerAddress> getCustomerAddressList() {
        return customerAddressList;
    }

    public void setCustomerAddressList(List<CustomerAddress> customerAddressList) {
        this.customerAddressList = customerAddressList;
    }
}
