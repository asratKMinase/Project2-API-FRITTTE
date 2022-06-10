package com.revature.frittte.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ChatServlet {

    private final ChatService chatServices;

    @Autowired
    public ChatServlet(ChatService chatServices) {
        this.chatServices = chatServices;
    }
}