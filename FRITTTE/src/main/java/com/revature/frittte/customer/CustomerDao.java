package com.revature.frittte.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository <Customer, String>{
    @Query(value = "FROM Customer WHERE username= :username AND password = :password")
    Customer authenticateCustomer(String username, String password);

}

