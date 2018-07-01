package com.deanzhelev.chat.model;

import com.deanzhelev.chat.dto.MessageDTO;
import com.deanzhelev.chat.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageFactory {

    public Message createMessage(MessageDTO messageDTO) {
        return new Message(messageDTO.getPayload(), messageDTO.getType());
    }
}
