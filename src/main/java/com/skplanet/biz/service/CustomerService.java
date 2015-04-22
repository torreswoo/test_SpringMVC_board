package com.skplanet.biz.service;

import com.skplanet.biz.domain.Customer;

import java.util.List;

/**
 * Created by 1002475 on 15. 4. 21..
 */
public interface CustomerService {

    public List<Customer> findAll();
    public Customer findById(int id) throws Exception;
    public void register(Customer customer);
    public void update(Customer customer)throws Exception;



}
