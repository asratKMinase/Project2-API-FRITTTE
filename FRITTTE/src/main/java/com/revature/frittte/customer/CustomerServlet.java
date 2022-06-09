package com.revature.frittte.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerServlet {
    private final CustomerService customerServices;
    @Autowired
    public CustomerServlet(CustomerService customerServices) {
        this.customerServices = customerServices;
    }

    @GetMapping("/findCustomer")
    public ResponseEntity<List> findAllCustomer(){
        return new ResponseEntity<>(customerServices.findAll(), HttpStatus.FOUND);
    }
    @PostMapping("/register")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerServices.create(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerServices.update(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestBody String username) {
        boolean newCustomer = customerServices.delete(username);
    }
}


