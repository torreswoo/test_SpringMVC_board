package com.skplanet.web.controller;

import com.skplanet.biz.domain.Customer;
import com.skplanet.biz.domain.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by 1002475 on 15. 4. 21..
 */

@Controller
public class CustomerListController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customer", method = RequestMethod.GET)
    public String showAllCustomer(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAllAttributes(customers);
        return "/customer/list";
    }



}
