package com.demo.project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.project.dto.CustomerDTO;
import com.demo.project.service.CustomerService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CustomerController {
    
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String greet(){
        return "Hello World!"; 
    }

    @GetMapping("/getallcustomers")
    public String getAllCustomers(@RequestParam Long leadId) {
        return customerService.getAllCustomers(leadId);
    }
    
    
}
