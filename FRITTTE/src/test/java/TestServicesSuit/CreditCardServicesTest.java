package TestServicesSuit;

import com.revature.frittte.creditcard.CreditCard;
import com.revature.frittte.creditcard.CreditCardDao;
import com.revature.frittte.creditcard.CreditCardService;
import com.revature.frittte.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CreditCardServicesTest {

    CreditCard creditCard;
    CreditCardService sut;
    CreditCardDao mockCreditCardDao;

    @BeforeEach
    public void testPrep(){
        mockCreditCardDao = mock(CreditCardDao.class);
        sut = new CreditCardService(mockCreditCardDao);
    }



    @Test
    public void test_validInput_givenCreditCard_returnTrue(){

        CreditCard creditCard = new CreditCard(5555555,"Geoffrey", 999,"9-23", 20, null);

        boolean actualResult = sut.validateInput(creditCard);

        Assertions.assertTrue(actualResult);
    }


}
