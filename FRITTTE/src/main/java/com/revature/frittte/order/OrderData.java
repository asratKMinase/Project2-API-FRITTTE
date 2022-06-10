package com.revature.frittte.order;

import com.revature.frittte.customer.Customer;
import com.revature.frittte.food.Food;

import javax.persistence.*;

@Entity
@Table (name = "order_o")
public class OrderData {

    @Id
    private int id;

    @Column(name = "order_date")
    private String orderDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Food", referencedColumnName = "item_name")
    private Food item_name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer", referencedColumnName = "username")
    private Customer customer_username;
    @Column(name = "comment_t")
    private String comment;

    public OrderData(int id, String orderDate, Food item_name, Customer customer_username, String comment) {
        this.id = id;
        this.orderDate = orderDate;
        this.item_name = item_name;
        this.customer_username = customer_username;
        this.comment = comment;
    }

    public OrderData() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Food getItem_name() {
        return item_name;
    }

    public void setItem_name(Food item_name) {
        this.item_name = item_name;
    }

    public Customer getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(Customer customer_username) {
        this.customer_username = customer_username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "id=" + id +
                ", orderDate='" + orderDate + '\'' +
                ", item_name=" + item_name +
                ", customer_username=" + customer_username +
                ", comment='" + comment + '\'' +
                '}';
    }
}
