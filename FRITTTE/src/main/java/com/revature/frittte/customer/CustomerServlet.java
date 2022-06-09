package com.revature.frittte.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CustomerServlet {

    private final CustomerService customerServices;

    @Autowired
    public CustomerServlet(CustomerService customerServices) {
        this.customerServices = customerServices;
    }
}
