package com.deanzhelev.chat.controller;


import com.deanzhelev.chat.dto.MessageDTO;
import com.deanzhelev.chat.model.Message;
import com.deanzhelev.chat.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageControllerUnitTest {

    @Mock
    private MessageService messageService;
    @Mock
    private MessageDTO messageDTO;
    @Mock
    private Message message;
    @Mock
    private BindingResult bindingResult;

    private MessageController messageController;

    @Before
    public void setUp() {
        messageController = new MessageController(messageService);
        when(messageService.sendMessage(messageDTO)).thenReturn(message);
    }


    @Test
    public void testShouldSendMessage() {

        ResponseEntity responseEntity = messageController.sendMessage(messageDTO, bindingResult);

        verify(messageService, times(1)).sendMessage(messageDTO);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));
    }

    @Test
    public void testShouldFailWithPreconditionFailed() {
        when(bindingResult.hasErrors()).thenReturn(true);
        ResponseEntity responseEntity = messageController.sendMessage(messageDTO, bindingResult);

        verify(messageService, times(0)).sendMessage(messageDTO);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.PRECONDITION_FAILED));
    }



}
