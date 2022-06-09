package com.revature.frittte.creditcard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditCardServlet {

    private final CreditCardService creditCardService;

    public CreditCardServlet(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }


    @PostMapping("/addCreditCard")
    public ResponseEntity<CreditCard> CreateCreditCard(@RequestBody CreditCard newCreditCard){
        CreditCard creditCard = creditCardService.create(newCreditCard);
        return new ResponseEntity<>(creditCard, HttpStatus.CREATED);
    }

    @GetMapping("/findCard")
    public ResponseEntity<CreditCard> FindCreditCard(@RequestBody int findCreditCard){
        CreditCard creditCard = creditCardService.findById(findCreditCard);
        return new ResponseEntity<>(creditCard, HttpStatus.OK);
    }
    @DeleteMapping
    public void DeleteCreditCard(@RequestBody String deletedCreditCard){
        creditCardService.delete(deletedCreditCard);
    }
}
