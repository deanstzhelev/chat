package com.deanzhelev.chat.validator;

import com.deanzhelev.chat.model.MessageType;
import com.deanzhelev.chat.validation.MessageValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MessagePayloadValidatorUnitTest {

    private MessageValidator messageValidator;

    @Before
    public void setUp() {
        messageValidator = new MessageValidator();
    }

    @Test
    public void testShouldFailTextValidation() {
        boolean isValid = messageValidator.validateMessage("", MessageType.SEND_TEXT);
        assertThat(isValid , is(false));
    }

    @Test
    public void testShouldFailEmoteValidation() {
        boolean isValid = messageValidator.validateMessage("E1", MessageType.SEND_EMOTE);
        assertThat(isValid , is(false));
    }

    @Test
    public void testShouldSucceedTextValidation() {
        boolean isValid = messageValidator.validateMessage("Sample text", MessageType.SEND_TEXT);
        assertThat(isValid , is(true));
    }

    @Test
    public void testShouldSucceedEmoteValidation() {
        boolean isValid = messageValidator.validateMessage(":D", MessageType.SEND_EMOTE);
        assertThat(isValid , is(true));
    }
}
