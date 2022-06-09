package com.revature.frittte.creditcard;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @Column(name = "credit_card_number", nullable = false)
    private int creditCardNumber;
    @Column(name = "credit_card_name" ,nullable = false)
    private String creditCardName;
    private int cvv;
    @Column(name = "exp_date" ,nullable = false)
    private String expDate;
    @Column(name = "limit_l" ,nullable = false)
    private int limit;
    @Column(name = "customer_username" ,nullable = false)
    private String customerUsername;

    public CreditCard(int creditCardNumber, String creditCardName, int cvv, String expDate, int limit, String customerUsername) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardName = creditCardName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.limit = limit;
        this.customerUsername = customerUsername;
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

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
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
