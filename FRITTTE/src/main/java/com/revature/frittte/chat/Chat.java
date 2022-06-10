package com.revature.frittte.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.frittte.customer.Customer;

import javax.persistence.*;


@Entity
@Table(name = "chat")
public class Chat {
        @Id
        private String id;
        @ManyToOne(optional = false)
        @JoinColumn(name = "Customer", referencedColumnName = "username")
        //@Column(name = "chat_username", length = 25, nullable = false)
        private Customer username;
        @Column(name = "title", length = 25, nullable = false)
        private String title;
        @Column(name = "date_t")
        private String date;
        private String people;

    public Chat(String id, Customer username, String title, String date, String people) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.date = date;
        this.people = people;
    }

    public Chat() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getUsername() {
        return username;
    }

    public void setUsername(Customer username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", people='" + people + '\'' +
                '}';
    }
}
