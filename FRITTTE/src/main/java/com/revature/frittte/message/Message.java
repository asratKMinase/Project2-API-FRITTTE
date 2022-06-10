package com.revature.frittte.message;

<<<<<<< HEAD
import com.revature.frittte.chat.Chat;

import javax.persistence.*;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
>>>>>>> 5c923f4893f704edbeafcd4822d2048c1e7396a8


@Entity
@Table
public class Message {
    @Id
    private int id;
<<<<<<< HEAD
    @ManyToOne(optional = false)
    @JoinColumn(name = "Chat", referencedColumnName = "chat_username")
    private Chat sender;
    private String text;
    private String created_date;

    public Message(int id, Chat sender, String text, String created_date) {
=======
    @Column(name = "sender", length = 50, nullable = false)
    private String sender;
    private String text;
    private String created_date;

    public Message(int id, String sender, String text, String created_date) {
>>>>>>> 5c923f4893f704edbeafcd4822d2048c1e7396a8
        this.id = id;
        this.sender = sender;
        this.text = text;
        this.created_date = created_date;
    }

<<<<<<< HEAD
    public Message() {

    }

=======
>>>>>>> 5c923f4893f704edbeafcd4822d2048c1e7396a8
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD
    public Chat getSender() {
        return sender;
    }

    public void setSender(Chat sender) {
=======
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
>>>>>>> 5c923f4893f704edbeafcd4822d2048c1e7396a8
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