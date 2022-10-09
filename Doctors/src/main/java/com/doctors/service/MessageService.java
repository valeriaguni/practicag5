package com.doctors.service;

import com.doctors.model.MessageModel;
import com.doctors.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAllMessages(){
        return messageRepository.getAllMessages();
    }

    public Optional<MessageModel> getMessage(Integer id){
        return messageRepository.getMessage(id);
    }

    public MessageModel saveMessage(MessageModel messageModel){
        return messageRepository.saveMessage(messageModel);
    }

    public boolean deleteMessage(Integer id){
        return messageRepository.deleteMessage(id);
    }

    public MessageModel updateMessage(MessageModel messageModel){ return messageRepository.updateMessage(messageModel);
    }

    public MessageModel save(MessageModel messageModel) {

        if (messageModel.getIdMessage() == null) {
            return messageRepository.saveMessage(messageModel);
        } else {
            Optional<MessageModel> message1 = messageRepository.getMessage(messageModel.getIdMessage());
            if(message1.isEmpty()) {
                return messageRepository.saveMessage(messageModel);
            } else {
                return messageModel;
            }
        }
    }

    public MessageModel update(MessageModel messageModel) {
        if(messageModel.getIdMessage()!=null) {
            Optional<MessageModel>g= messageRepository.getMessage(messageModel.getIdMessage());
            if(!g.isEmpty()){
                if(messageModel.getMessageText()!=null){
                    g.get().setMessageText(messageModel.getMessageText());
                }
                return messageRepository.saveMessage(g.get());
            }
        }
        return messageModel;
    }
}
