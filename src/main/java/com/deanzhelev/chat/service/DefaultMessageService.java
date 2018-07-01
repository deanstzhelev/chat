package com.deanzhelev.chat.service;

import com.deanzhelev.chat.dto.MessageDTO;
import com.deanzhelev.chat.model.MessageFactory;
import com.deanzhelev.chat.model.Message;
import com.deanzhelev.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultMessageService implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageFactory messageFactory;

    @Autowired
    public DefaultMessageService(MessageRepository messageRepository, MessageFactory messageFactory) {

        this.messageRepository = messageRepository;
        this.messageFactory = messageFactory;
    }


    @Override
    public Message sendMessage(MessageDTO messageDTO) {
        Message message = messageRepository.save(messageFactory.createMessage(messageDTO));
        return message;
    }
}
