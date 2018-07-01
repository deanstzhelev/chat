package com.deanzhelev.chat.controller;

import com.deanzhelev.chat.dto.MessageDTO;
import com.deanzhelev.chat.model.MessageType;
import com.deanzhelev.chat.service.MessageService;
import com.deanzhelev.chat.validation.MessageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class MessageController {


    private final MessageService messageService;
    private final MessageValidator messageValidator;

    @Autowired
    public MessageController(MessageService messageService, MessageValidator messageValidator) {
        this.messageService = messageService;
        this.messageValidator = messageValidator;
    }

    @PostMapping(value = "/messages/{type}")
    public ResponseEntity sendMessage(@RequestBody Map<String,String> body, @PathVariable MessageType type) {

        boolean preconditionSuccessful = messageValidator.validateMessage(body.get("payload"), type);

        if (preconditionSuccessful) {
            MessageDTO messageDTO = new MessageDTO(body.get("payload"), type);
            messageService.sendMessage(messageDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.PRECONDITION_FAILED);
        }

    }
}
