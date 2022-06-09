package com.revature.frittte.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Message {
    @Id
    private int id;
    @Column(name = "sender", length = 50, nullable = false)
    private String sender;
    private String text;
    private String created_date;

    public Message(int id, String sender, String text, String created_date) {
        this.id = id;
        this.sender = sender;
        this.text = text;
        this.created_date = created_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", created_date='" + created_date + '\'' +
                '}';
    }
}