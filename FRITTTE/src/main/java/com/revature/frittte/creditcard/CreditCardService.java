package com.revature.frittte.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CreditCardService {

    private CreditCardDao creditCardDao;

    @Autowired
    public CreditCardService(CreditCardDao creditCardDao) {
        this.creditCardDao = creditCardDao;
    }

    public boolean delete(String creditCardNumber){
        creditCardDao.deleteById(Integer.valueOf(creditCardNumber));
        return true;
    }

    public CreditCard create(CreditCard newCreditCard){

        if(!validateInput(newCreditCard)){
            //TODO: uncomment
            //throw new InvalidRequestException("User input was not validated, either empty String or null values");
        }


        CreditCard persistedCreditCard = creditCardDao.save(newCreditCard);

        if(persistedCreditCard == null){
            //TODO: uncomment
            //throw new ResourcePersistanceException("Credit Card was not persisted to the database upon registration");
        }
        return persistedCreditCard;
    }

    public boolean validateInput(CreditCard newCreditCard){
        if(newCreditCard == null ) return false;
        if(newCreditCard.getCreditCardName() == null || newCreditCard.getCreditCardName().trim().equals("")) return false;
        if(newCreditCard.getCreditCardNumber() == 0 ) return false;
        if(newCreditCard.getCvv() == 0 ) return false;
        if(newCreditCard.getExpDate() == null || newCreditCard.getExpDate().trim().equals("")) return false;
        if(newCreditCard.getLimit() == 0 ) return false;
        return (newCreditCard.getCustomerUsername() != null || !newCreditCard.getCustomerUsername().trim().equals("")) ;
    }
}
