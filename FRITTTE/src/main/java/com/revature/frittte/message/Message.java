package com.revature.frittte.message;

import com.revature.frittte.chat.Chat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "message")
public class Message {
    @Id
    private int id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "Chat", referencedColumnName = "chatUsername")
    private Chat sender;
    private String text;
    private String created_date;
}