package com.revature.frittte.order;

import com.revature.frittte.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDao extends CrudRepository<OrderData, Integer> {

    @Query(value = "FROM customer WHERE username= :username AND password = :password")
    Optional<Customer> authenticateTrainer(String username, String password);
}
