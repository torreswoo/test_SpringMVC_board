package com.skplanet.web.controller;

import com.skplanet.biz.domain.Customer;
import com.skplanet.biz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * Created by 1002475 on 15. 4. 21..
 */

@Controller
@RequestMapping("/customer/{customerId}")
@SessionAttributes("editCustomer")
public class CustomerEditController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String redirectToEntryForm( @PathVariable int customerId, Model model)throws Exception{
        Customer customer = customerService.findById(customerId);
        model.addAttribute("editCustomer", customer); // 세션관리가된 editCustomer를
        return "redirect:enter";
    }

    @RequestMapping(value = "/enter", method= RequestMethod.GET)
    public String showEntryForm(){
        return "customer/edit/enter";
    }


    // _event_proceed 이벤트드리븐방식  (params), 유효성검사(@Valid)
    @RequestMapping(value = "/enter", params = "_event_proceed", method = RequestMethod.POST)
    public String verifiy(@Valid @ModelAttribute("editCustomer") Customer customer, Errors errors){

        if(errors.hasErrors()){
            return "customer/edit/enter";
        }
        return "redirect:review";
    }

    @RequestMapping(value = "/review", method= RequestMethod.GET)
    public String showReview(){
        return "customer/edit/review";
    }


    // _event_confirmed 이벤트드리븐방식  (params), 유효성검사(@Valid)
    @RequestMapping(value = "/review", params = "_event_confirmed", method = RequestMethod.POST)
    public String verifiy(@Valid @ModelAttribute("editCustomer") Customer customer)throws Exception{
        customerService.update(customer);
        return "redirect:edited";
    }

    @RequestMapping(value = "/edited", method = RequestMethod.GET)
    public String showEdited(SessionStatus sessionStatus){
        sessionStatus.setComplete();  // 세션의 만료
        return "customer/edit/edited";
    }

}
