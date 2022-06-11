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

    Customer stu;
    CreditCardService sut;
    CreditCardDao mockCreditCardDao;

    @BeforeEach
    public void testPrep(){
        mockCreditCardDao = mock(CreditCardDao.class);
        stu = new Customer("Geoff", "1234", "Geoffy", "Blois", "10-9-1900", false,false);
        sut = new CreditCardService(mockCreditCardDao);

    }



    @Test
    public void test_validInput_givenCreditCard_returnTrue(){

        CreditCard creditCard = new CreditCard(5555555,"Geoffrey", 999,"9-23", 20, stu);

        boolean actualResult = sut.validateInput(creditCard);

        Assertions.assertTrue(actualResult);
    }

//    @Test
//    public void test_Create_givenCreditCard_returnCreditCard(){
//
//        CreditCard creditCard = new CreditCard(55555556,"Geoffrey", 989,"9-23", 10, "");
//
//        System.out.println(creditCard);
//
//        CreditCard actualResult = sut.create(creditCard);
//
//        System.out.println(actualResult);
//
//        Assertions.assertEquals(55555556, actualResult.getCreditCardNumber());
//        Assertions.assertEquals("Geoffrey", actualResult.getCreditCardName());
//        Assertions.assertEquals(989, actualResult.getCvv());
//        Assertions.assertEquals("9-23", actualResult.getExpDate());
//        Assertions.assertEquals(10, actualResult.getLimit());
//        Assertions.assertEquals(stu.getUsername(), stu.getUsername());
//
//        verify(mockCreditCardDao, times(1)).save(creditCard);
//    }

}
