package com.revature.frittte.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column(name = "fname", length = 25, nullable = false)
    private String fname;
    @Column(name = "lname", length = 20, nullable = false)
    private String lname;
    private String dob;
    private boolean employee;
    private boolean admin;


    public Customer(String username, String password, String fname, String lname, String dob, boolean employee, boolean admin) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.employee = employee;
        this.admin = admin;
    }

    //TODO why we need the constructor the model gets ungree
    public Customer() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isEmployee() {
        return employee;
    }

    public void setEmployee(boolean employee) {
        this.employee = employee;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", dob='" + dob + '\'' +
                ", employee=" + employee +
                ", admin=" + admin +
                '}';
    }
}
