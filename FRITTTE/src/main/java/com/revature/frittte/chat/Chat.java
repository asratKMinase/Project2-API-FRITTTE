package com.revature.frittte.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class Chat {


        @Id
        private String id;
        @Column(name = "username", length = 25, nullable = false)
        private String username;
        @Column(name = "title", length = 25, nullable = false)
        private String title;
        private String date;
        private String people;

    public Chat(String id, String username, String title, String date, String people) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.date = date;
        this.people = people;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
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
