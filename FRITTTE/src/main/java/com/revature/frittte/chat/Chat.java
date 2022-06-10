package com.revature.frittte.chat;

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
        private Customer chat_username;
        @Column(name = "title", length = 25, nullable = false)
        private String title;
        @Column(name = "date_t")
        private String date;
        private String people;

    public Chat(String id, Customer chat_username, String title, String date, String people) {
        this.id = id;
        this.chat_username = chat_username;
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

    public Customer getChat_username() {
        return chat_username;
    }

    public void setChat_username(Customer chat_username) {
        this.chat_username = chat_username;
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
                ", username='" + chat_username + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", people='" + people + '\'' +
                '}';
    }
}
