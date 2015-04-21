package com.skplanet.biz.domain;

import java.util.List;

/**
 * Created by 1002475 on 15. 4. 21..
 */
public class MockCustomerService implements CustomerService {
    private List<Customer> customers = null;


    @Override
    public List<Customer> findAll() {
        if(customers != null)
            return this.customers;
        else{
            return null;
        }
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void register(Customer customer) {
        this.customers.add(customer);
    }
}
