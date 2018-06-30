package com.deanzhelev.chat.service;

import com.deanzhelev.chat.dto.MessageDTO;
import com.deanzhelev.chat.model.Message;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {

    Message sendMessage(MessageDTO messageDTO);

}
