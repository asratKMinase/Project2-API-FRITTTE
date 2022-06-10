package com.revature.frittte.message;

import com.revature.frittte.chat.Chat;

import javax.persistence.*;


@Entity
@Table
public class Message {
    @Id
    private int id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "Chat", referencedColumnName = "chat_username")
    private Chat sender;
    private String text;
    private String created_date;

    public Message(int id, Chat sender, String text, String created_date) {
        this.id = id;
        this.sender = sender;
        this.text = text;
        this.created_date = created_date;
    }

    public Message() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Chat getSender() {
        return sender;
    }

    public void setSender(Chat sender) {
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