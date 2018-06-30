package com.deanzhelev.chat.service;

import com.deanzhelev.chat.dto.MessageDTO;
import com.deanzhelev.chat.factory.MessageFactory;
import com.deanzhelev.chat.model.Message;
import com.deanzhelev.chat.model.MessageType;
import com.deanzhelev.chat.repository.MessageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceUnitTest {

    private MessageService messageService;

    @Mock
    private MessageRepository messageRepository;
    @Mock
    private MessageFactory messageFactory;
    @Mock
    private Message message;
    @Mock
    private MessageDTO messageDTO;

    @Before
    public void setUp() {
        messageService = new DefaultMessageService(messageRepository, messageFactory);
        when(messageDTO.getPayload()).thenReturn("simple text");
        when(messageDTO.getType()).thenReturn(MessageType.TEXT);
        when(messageFactory.createMessage(messageDTO)).thenReturn(message);
    }

    @Test
    public void testSendMessage() {
        messageService.sendMessage(messageDTO);

        verify(messageFactory, times(1)).createMessage(messageDTO);
        verify(messageRepository, times(1)).save(message);
    }
}
