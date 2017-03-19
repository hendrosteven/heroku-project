/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdam.mataram.repo;

import com.pdam.mataram.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Hendro Steven
 */
public interface CustomerRepo extends PagingAndSortingRepository<Customer, String> {

    @Query("SELECT c FROM Customer c")
    public List<Customer> findAllCustomer();
}
