package com.revature.frittte.creditcard;


import com.revature.frittte.customer.Customer;

import javax.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @Column(name = "cc_number", nullable = false)
    private int creditCardNumber;
    @Column(name = "cc_name" ,nullable = false)
    private String creditCardName;
    private int cvv;
    @Column(name = "exp_date" ,nullable = false)
    private String expDate;
    @Column(name = "limit_l" ,nullable = false)
    private int limit;
    @ManyToOne(optional = false)
    @JoinColumn(name = "Customer", referencedColumnName = "username")
    //@Column(name = "customer_username" ,nullable = false)
    private Customer customerUsername;

    public CreditCard(int creditCardNumber, String creditCardName, int cvv, String expDate, int limit, Customer customerUsername) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardName = creditCardName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.limit = limit;
        this.customerUsername = customerUsername;
    }

    public CreditCard() {

    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Customer getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(Customer customerUsername) {
        this.customerUsername = customerUsername;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardNumber=" + creditCardNumber +
                ", creditCardName='" + creditCardName + '\'' +
                ", cvv=" + cvv +
                ", expDate=" + expDate +
                ", limit=" + limit +
                ", customerUsername=" + customerUsername +
                '}';
    }
}
