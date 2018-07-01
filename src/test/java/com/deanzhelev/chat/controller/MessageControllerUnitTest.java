package com.deanzhelev.chat.controller;

import com.deanzhelev.chat.model.MessageType;
import com.deanzhelev.chat.service.MessageService;
import com.deanzhelev.chat.validation.MessageValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageControllerUnitTest {

    @Mock
    private MessageService messageService;
    @Mock
    private MessageValidator messageValidator;

    private MessageController messageController;
    @Mock
    private Map<String, String> body;

    @Before
    public void setUp() {
        messageController = new MessageController(messageService, messageValidator);

    }


    @Test
    public void testShouldSendMessage() {
        when(messageValidator.validateMessage(body.get("payload"), MessageType.SEND_TEXT)).thenReturn(true);
        ResponseEntity responseEntity = messageController.sendMessage(body,  MessageType.SEND_TEXT);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));
    }

    @Test
    public void testShouldFailWithPreconditionFailed() {
        when(messageValidator.validateMessage(body.get("payload"), MessageType.SEND_TEXT)).thenReturn(false);
        ResponseEntity responseEntity = messageController.sendMessage(body,  MessageType.SEND_TEXT);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.PRECONDITION_FAILED));
    }



}
