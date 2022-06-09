package com.revature.frittte.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin //Resource Sharing, by default it allows all "*"
public class OrderServlet {
    private final OrderServices orderServices;

    @Autowired
    public OrderServlet(OrderServices trainerServices) {
        this.orderServices = trainerServices;
    }

    // TODO: Implement ME

    // Create
    @PostMapping("/order")
    public ResponseEntity<OrderData> saveOrder(@RequestBody OrderData order){
        OrderData newOrder = orderServices.create(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }
}
