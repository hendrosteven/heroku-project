/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdam.mataram.controller;

import com.pdam.mataram.entity.Customer;
import com.pdam.mataram.repo.CustomerRepo;
import java.util.List;
import java.util.concurrent.Callable;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hendro Steven
 */
@RestController
@RequestMapping("/api/customer")
@Transactional
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Callable<Customer> save(@RequestBody Customer customer) {
        return new Callable<Customer>() {
            @Override
            public Customer call() throws Exception {
                Customer cust = customerRepo.save(customer);
                return cust;
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET)
    public Callable<List<Customer>> findAll() {
        return new Callable<List<Customer>>() {
            @Override
            public List<Customer> call() throws Exception {
                return customerRepo.findAllCustomer();
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Callable<Customer> findOne(@PathVariable("id") String id) {
        return new Callable<Customer>() {
            @Override
            public Customer call() throws Exception {
                return customerRepo.findOne(id);
            }
        };
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public Callable<String[]> delete(@PathVariable("id") String id) {
        return new Callable<String[]>() {
            @Override
            public String[] call() throws Exception {
                customerRepo.delete(customerRepo.findOne(id));
                String[] status = {"true"};
                return status;
            }
        };
    }
}
