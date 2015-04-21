package com.skplanet.biz.domain;

import java.util.List;

/**
 * Created by 1002475 on 15. 4. 21..
 */
public interface CustomerService {

    public List<Customer> findAll();
    public Customer findById(int id);
    public void register(Customer customer);



}
