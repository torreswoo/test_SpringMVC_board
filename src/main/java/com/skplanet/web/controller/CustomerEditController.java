package com.skplanet.web.controller;

import com.skplanet.biz.domain.Customer;
import com.skplanet.biz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by 1002475 on 15. 4. 21..
 */

@Controller
@RequestMapping("/customer/{customerId}")
@SessionAttributes("editCustomer") //세션 스코프로 입력값을 관리
public class CustomerEditController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String redirectToEntryForm(
            @PathVariable int customerId, Model model)throws Exception{
        Customer customer = customerService.findById(customerId);
        model.addAttribute("editCustomer", customer); // 세션관리가된 editCustomer를
        return "redirect:enter";
    }

    @RequestMapping(value = "/enter", method= RequestMethod.GET)
    public String showEntryForm(
            @ModelAttribute("editCustomer") Customer customer) {
        return "customer/edit/enter";
    }



    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String showReview(@ModelAttribute("editCustomer") Customer customer) {
        return "customer/edit/review";
    }
    // _event_proceed 이벤트드리븐방식  (params)
    // _event_revise
    // _event_confirmed

    // 유효성검사(@Valid)
    @RequestMapping(value = "/enter", params = "_event_proceed", method = RequestMethod.POST)
    public String verifiy(
            @Valid @ModelAttribute("editCustomer") Customer customer, Errors errors){

        if(errors.hasErrors()){
            return "customer/edit/enter";
        }
        return "redirect:review";
    }

    @RequestMapping(value = "/review", params = "_event_revise", method = RequestMethod.POST)
    public String revise() {
        return "redirect:enter";
    }

    @RequestMapping(value = "/review", params = "_event_confirmed", method = RequestMethod.POST)
    public String edit(@ModelAttribute("editCustomer") Customer customer,
                       RedirectAttributes redirectAttributes, SessionStatus sessionStatus)
            throws Exception {
        customerService.update(customer);

        // retrun "redirect:edited";

        redirectAttributes.addFlashAttribute("editedCustomer", customer);

        sessionStatus.setComplete();

        return "redirect:/customer";
    }

    @RequestMapping(value = "/edited", method = RequestMethod.GET)
    public String showEdited(
            @ModelAttribute("editCustomer") Customer customer,
            SessionStatus sessionStatus) {

        sessionStatus.setComplete();

        return "customer/edit/edited";
    }

}
