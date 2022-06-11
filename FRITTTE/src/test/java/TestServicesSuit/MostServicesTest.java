package TestServicesSuit;


import com.revature.frittte.creditcard.CreditCard;
import com.revature.frittte.creditcard.CreditCardDao;
import com.revature.frittte.creditcard.CreditCardService;
import com.revature.frittte.customer.Customer;
import com.revature.frittte.customer.CustomerDao;
import com.revature.frittte.customer.CustomerService;
import com.revature.frittte.exception.AuthenticationException;
import com.revature.frittte.exception.InvalidRequestException;
import com.revature.frittte.food.Food;
import com.revature.frittte.food.FoodDao;
import com.revature.frittte.food.FoodService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MostServicesTest {

    Customer stu;
    CreditCardService sut;
    CustomerService sut2;

    FoodService sut3;

    FoodDao mockFoodDao;

    CreditCardDao mockCreditCardDao;
    CustomerDao mockCustomerDao;

    @BeforeEach
    public void testPrep(){
        mockCreditCardDao = mock(CreditCardDao.class);
        mockCustomerDao = mock(CustomerDao.class);
        mockFoodDao = mock(FoodDao.class);
        stu = new Customer("Geoff", "1234", "Geoffy", "Blois", "10-9-1900", false,false);
        sut = new CreditCardService(mockCreditCardDao);
        sut2 = new CustomerService(mockCustomerDao);
        sut3 = new FoodService(mockFoodDao);

    }


    // Credit Card Input
    @Test
    public void test_validInput_givenCreditCard_returnTrue(){

        CreditCard creditCard = new CreditCard(5555555,"Geoffrey", 999,"9-23", 20, stu );

        boolean actualResult = sut.validateInput(creditCard);

        Assertions.assertTrue(actualResult);
    }

    // Customer
    @Test
    public void test_validInput_givenCustomer_returnTrue(){

        Customer customer = new Customer("GeoffreyB", "password", "Geoff", "Blois", "12-9-2021", true, false);

        boolean actualResult = sut2.validateInput(customer);

        Assertions.assertTrue(actualResult);
    }


    @Test
    public void test_ValidInput_createCustomer_ReturnCustomer(){
        Customer customer = new Customer("Movie", "pass", "Move","ie","12-9-2052", false, false);

        when(mockCustomerDao.save(customer)).thenReturn(customer);

        Customer actualCustomer = sut2.create(customer);

        Assertions.assertEquals("Movie", actualCustomer.getUsername());
        Assertions.assertEquals("pass", actualCustomer.getPassword());
        Assertions.assertEquals("Move", actualCustomer.getFname());
        Assertions.assertEquals("ie", actualCustomer.getLname());
        Assertions.assertEquals("12-9-2052", actualCustomer.getDob());
        Assertions.assertEquals(false, actualCustomer.isEmployee());
        Assertions.assertEquals(false, actualCustomer.isAdmin());

        verify(mockCustomerDao, times(1)).save(customer);
    }

    @Test
    public void test_create_givenRepeatedUserInformation_throwsInvalidRequestException(){
        Customer customer = new Customer("Movie", "", "Move","ie","12-9-2052" ,false , false);
        when(mockCustomerDao.existsById(customer.getUsername())).thenReturn(true);

        Assertions.assertThrows(InvalidRequestException.class, () -> { sut2.create(customer);});
        verify(mockCustomerDao, times(0)).save(customer);
    }

    //Food
    @Test
    public void test_validInput_givenItem_returnTrue(){

        Food food = new Food(1,"water", 12, 10, 12, false );

        boolean actualResult = sut3.validateInput(food);

        Assertions.assertTrue(actualResult);
    }

    @Test
    public void test_ValidInput_createFood_ReturnFood(){
        Food food = new Food(1,"water", 12, 10, 12, false);

        when(mockFoodDao.save(food)).thenReturn(food);

        Food actualCustomer = sut3.create(food);

        Assertions.assertEquals(1, actualCustomer.getId());
        Assertions.assertEquals("water", actualCustomer.getItemName());
        Assertions.assertEquals(12, actualCustomer.getCost());
        Assertions.assertEquals(10, actualCustomer.getWeight());
        Assertions.assertEquals(12, actualCustomer.getVolume());
        Assertions.assertEquals(false, actualCustomer.isFrozen());

        verify(mockFoodDao, times(1)).save(food);
    }

    @Test
    public void test_create_givenRepeatedFoodInformation_throwsInvalidRequestException(){
        Food food = new Food(1,"", 12, 10, 12, false);
        when(mockFoodDao.existsById(food.getId())).thenReturn(true);

        Assertions.assertThrows(InvalidRequestException.class, () -> { sut3.create(food);});
        verify(mockFoodDao, times(0)).save(food);
    }

}
