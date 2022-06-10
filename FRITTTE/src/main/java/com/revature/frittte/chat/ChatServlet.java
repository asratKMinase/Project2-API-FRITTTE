package com.revature.frittte.chat;

import com.revature.frittte.message.Message;
import com.revature.frittte.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class ChatServlet {
    private final ChatService chatServices;
    @Autowired
    public ChatServlet(ChatService chatServices) {
        this.chatServices = chatServices;
    }

    @GetMapping("/findAllChat")
    public ResponseEntity<List> findAllChat(){
        return new ResponseEntity<>(chatServices.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/findChat")
    public ResponseEntity<Chat> findChat(@RequestBody String id){
        return new ResponseEntity<>(chatServices.readById(id), HttpStatus.FOUND);
    }

    @PutMapping("/updateChat")
    public ResponseEntity<Chat> updateChat(@RequestBody Chat chat) {
        Chat newChat = chatServices.update(chat);
        return new ResponseEntity<>(newChat, HttpStatus.OK);
    }
    @DeleteMapping("/deleteChat")
    public void deleteChat(@RequestBody String username) {
        boolean newChat = chatServices.delete(username);
    }

    @PostMapping("/addChat")
    public ResponseEntity<Chat> CreateChat(@RequestBody Chat newChat){
        Chat chat = chatServices.create(newChat);
        return new ResponseEntity<>(chat, HttpStatus.CREATED);
    }
}