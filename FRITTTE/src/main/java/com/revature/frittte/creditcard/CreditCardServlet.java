package com.revature.frittte.creditcard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardServlet {

    private final CreditCardService creditCardService;

    public CreditCardServlet(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }


    @PostMapping
    public ResponseEntity<CreditCard> CreateCreditCard(@RequestBody CreditCard newCreditCard){
        CreditCard creditCard = creditCardService.create(newCreditCard);
        return new ResponseEntity<>(creditCard, HttpStatus.CREATED);
    }

    @DeleteMapping
    public void DeleteCreditCard(@RequestBody String deletedCreditCard){
        creditCardService.delete(deletedCreditCard);
    }
}
