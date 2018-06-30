package com.deanzhelev.chat.validator;


import com.deanzhelev.chat.dto.MessageDTO;
import com.deanzhelev.chat.model.MessageType;
import com.deanzhelev.chat.validation.PayloadValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PayloadValidatorUnitTest {


    private PayloadValidator payloadValidator;
    @Mock
    private ConstraintValidatorContext constraintValidatorContext;
    private MessageDTO messageDTO;

    @Before
    public void setUp() {
        payloadValidator = new PayloadValidator();
    }

    @Test
    public void testShouldFailTextValidation() {
        messageDTO = new MessageDTO("", MessageType.TEXT);
        boolean isValid = payloadValidator.isValid(messageDTO, constraintValidatorContext);
        assertThat(isValid , is(false));
    }

    @Test
    public void testShouldFailEmoteValidation() {
        messageDTO = new MessageDTO("E1", MessageType.EMOTE);
        boolean isValid = payloadValidator.isValid(messageDTO, constraintValidatorContext);
        assertThat(isValid , is(false));
    }

    @Test
    public void testShouldSucceedTextValidation() {
        messageDTO = new MessageDTO("Sample text", MessageType.TEXT);
        boolean isValid = payloadValidator.isValid(messageDTO, constraintValidatorContext);
        assertThat(isValid , is(true));
    }

    @Test
    public void testShouldSucceedEmoteValidation() {
        messageDTO = new MessageDTO(":D", MessageType.EMOTE);
        boolean isValid = payloadValidator.isValid(messageDTO, constraintValidatorContext);
        assertThat(isValid , is(true));
    }
}
