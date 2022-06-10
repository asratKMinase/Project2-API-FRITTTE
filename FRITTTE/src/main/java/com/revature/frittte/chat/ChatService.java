package com.revature.frittte.chat;

import com.revature.frittte.exception.AuthenticationException;
import com.revature.frittte.exception.InvalidRequestException;
import com.revature.frittte.exception.ResourcePersistanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChatService {
    private ChatDao chatDao;

    @Autowired
    public ChatService(ChatDao customerDao) {
        this.chatDao = chatDao;
    }

    public List<Chat> findAll(){
        List<Chat> customers = (List<Chat>) chatDao.findAll();
        return customers;
    }
    public Chat readById(String id) {
        Chat customer = chatDao.findById(id).get();
        return customer;
    }

    public Chat update(Chat updatedChat) {
        chatDao.save(updatedChat);
        return updatedChat;
    }
    public boolean delete(String username) {
        chatDao.deleteById(username);
        return true;
    }

    public boolean validateUsernameNotUsed(String username){
        return chatDao.existsById(username);
    }

    public Chat create(Chat newChat){
        if(!validateInput(newChat)){
            throw new InvalidRequestException("User input was not validated, either empty String or null values");
        }
//        if(validateUsernameNotUsed(newChat.getUsername())){
//            throw new InvalidRequestException("Username is already in use. Please try again with another email or login into previous made account.");
//        }
        Chat persistedChat = chatDao.save(newChat);
//TODO need to be checked in every services for persistedTrainer typo
        if(persistedChat == null){
            throw new ResourcePersistanceException("Chat was not persisted to the database upon registration");
        }
        return persistedChat;
    }


    public boolean validateInput(Chat newChat) {
        if(newChat == null) return false;
        if(newChat.getId()== null || newChat.getId().trim().equals("")) return false;
        if(newChat.getUsername() == null || newChat.getUsername().equals("")) return false;
        if(newChat.getTitle() == null || newChat.getTitle().trim().equals("")) return false;
        if(newChat.getDate() == null || newChat.getDate().trim().equals("")) return false;
        return newChat.getPeople() != null || !newChat.getPeople().trim().equals("");

    }


    public Chat authenticateChat(String id, String username){

        if(id == null || id.trim().equals("") || username == null || username.trim().equals("")) {
            throw new InvalidRequestException("Either email or password is an invalid entry. Please try logging in again");
        }

        Chat authenticatedChat = chatDao.authenticateChat(id, username);

        if (authenticatedChat == null){
            throw new AuthenticationException("Unauthenticated user, information provided was not consistent with our database.");
        }

        return authenticatedChat;

    }

}

