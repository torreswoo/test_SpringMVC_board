package com.skplanet.web.controller;

import com.skplanet.biz.domain.Customer;
import com.skplanet.biz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by 1002475 on 15. 4. 21..
 *  이벤트드리븐방식  (params)
 *  유효성검사(@Valid)
 */

@Controller
@RequestMapping("/customer/{customerId}")
@SessionAttributes("editCustomer") //세션 스코프로 입력값을 관리
public class CustomerEditController {

    @Autowired
    private CustomerService customerService;


    // 1단계 : edit
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String redirectToEntryForm(
            @PathVariable int customerId, Model model) throws Exception{

        Customer customer = customerService.findById(customerId);
        model.addAttribute("editCustomer", customer); // 세션관리가된 editCustomer를
        return "redirect:enter";
    }

    // 2단계 : enter
    @RequestMapping(value = "/enter", method= RequestMethod.GET)
    public String showEntryForm(
            @ModelAttribute("editCustomer") Customer customer) {

        return "customer/edit/enter";
    }
                                    // _event_proceed 이벤트드리븐방식
    @RequestMapping(value = "/enter", params = "_event_proceed", method = RequestMethod.POST)
    public String verifiy(
            @Valid @ModelAttribute("editCustomer") Customer customer, Errors errors){

        if(errors.hasErrors()){
            return "customer/edit/enter";
        }
        return "redirect:review";
    }


    // 3단계 : review
    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String showReview(
            @ModelAttribute("editCustomer") Customer customer) {

        return "customer/edit/review";
    }
                                    // _event_revise
    @RequestMapping(value = "/review", params = "_event_revise", method = RequestMethod.POST)
    public String revise() {
        return "redirect:enter";
    }
                                    // _event_confirmed
    @RequestMapping(value = "/review", params = "_event_confirmed", method = RequestMethod.POST)
    public String edit(
            @ModelAttribute("editCustomer") Customer customer, RedirectAttributes redirectAttributes, SessionStatus sessionStatus)
            throws Exception {

        customerService.update(customer);

        // retrun "redirect:edited";

        redirectAttributes.addFlashAttribute("editedCustomer", customer);

        sessionStatus.setComplete();

        return "redirect:/customer";
    }

    // 4단계 : edited
    @RequestMapping(value = "/edited", method = RequestMethod.GET)
    public String showEdited(
            @ModelAttribute("editCustomer") Customer customer, SessionStatus sessionStatus) {

        sessionStatus.setComplete();

        return "customer/edit/edited";
    }

    // Spring MVC에서의 예외처리!  @ExceptionHandler
    @ExceptionHandler
    public String handleException(HttpSessionRequiredException e) {
        return "redirect:/customer/{customerId}/edit";
    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "customer/notfound";
    }

}