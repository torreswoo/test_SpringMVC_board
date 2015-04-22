package com.skplanet.web.controller;

import com.skplanet.biz.domain.Customer;
import com.skplanet.biz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "forward:/customer";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String showAllCustomers(Model model) {

        System.out.println("...start showAllCustomers()");
        List<Customer> customers = customerService.findAll();
     //   model.addAllAttributes(customers);
        model.addAttribute( "customers", customers);
        return "customer/list";
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public String showCustomerDetail(@PathVariable int customerId, Model model)
            throws Exception{
        Customer customer = customerService.findById(customerId);
        model.addAttribute("customer", customer);
        return "customer/detail";
    }




}
