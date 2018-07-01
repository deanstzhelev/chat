package com.deanzhelev.chat.factory;

import com.deanzhelev.chat.dto.MessageDTO;
import com.deanzhelev.chat.model.Message;
import com.deanzhelev.chat.model.MessageType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageFactoryUnitTest {

    private MessageFactory messageFactory;
    private MessageDTO messageDTO;

    @Before
    public void setUp() {
        messageFactory = new MessageFactory();
        messageDTO = Mockito.mock(MessageDTO.class);
    }

    @Test
    public void testCreateTextMessage() {
        when(messageDTO.getPayload()).thenReturn("Simple text");
        when(messageDTO.getType()).thenReturn(MessageType.SEND_TEXT);

        Message message = messageFactory.createMessage(messageDTO);

        assertCreatedMessage(message);
    }

    @Test
    public void testCreateEmoteMessage() {
        when(messageDTO.getPayload()).thenReturn(":D");
        when(messageDTO.getType()).thenReturn(MessageType.SEND_EMOTE);

        Message message = messageFactory.createMessage(messageDTO);

        assertCreatedMessage(message);
    }

    private void assertCreatedMessage(Message message) {
        assertEquals(message.getType(), messageDTO.getType());
        assertEquals(message.getPayload(), messageDTO.getPayload());
    }
}
