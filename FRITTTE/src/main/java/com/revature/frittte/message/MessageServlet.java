package com.revature.frittte.message;

import com.revature.frittte.creditcard.CreditCard;
import com.revature.frittte.customer.Customer;
import com.revature.frittte.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MessageServlet {
    private final MessageService messageServices;
    @Autowired
    public MessageServlet(MessageService messageServices) {
        this.messageServices = messageServices;
    }

    @GetMapping("/findAllMessage")
    public ResponseEntity<List> findAllMessage(){
        return new ResponseEntity<>(messageServices.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/findMessage")
    public ResponseEntity<Message> findMessage(@RequestBody int id){
        return new ResponseEntity<>(messageServices.readById(id), HttpStatus.FOUND);
    }

    @PutMapping("/updateMessage")
    public ResponseEntity<Message> updateMessage(@RequestBody Message message) {
        Message newMessage = messageServices.update(message);
        return new ResponseEntity<>(newMessage, HttpStatus.OK);
    }
    @DeleteMapping("/deleteMessage")
    public void deleteMessage(@RequestBody int id) {
        boolean newMessage = messageServices.deleteById(id);
    }

    @PostMapping("/addMessage")
    public ResponseEntity<Message> CreateMessage(@RequestBody Message newMessage){
        Message message = messageServices.create(newMessage);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}

