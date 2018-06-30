package com.deanzhelev.chat.controller;

import com.deanzhelev.chat.dto.MessageDTO;
import com.deanzhelev.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class MessageController {


    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity sendMessage(@Valid @RequestBody MessageDTO messageDTO, BindingResult result) {
        if (!result.hasErrors()) {
            messageService.sendMessage(messageDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.PRECONDITION_FAILED);
        }

    }
}
