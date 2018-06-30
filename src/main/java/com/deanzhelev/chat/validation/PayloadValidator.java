package com.deanzhelev.chat.validation;

import com.deanzhelev.chat.dto.MessageDTO;
import com.deanzhelev.chat.model.MessageType;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
public class PayloadValidator implements ConstraintValidator<IsValidPayload, MessageDTO> {

    private final String TEXT_REGEX = "^.{1,160}$";
    private final String EMOTE_REGEX = "^[^(0-9)]{2,10}$";

    @Override
    public void initialize(IsValidPayload constraintAnnotation) {

    }

    @Override
    public boolean isValid(MessageDTO messageDTO, ConstraintValidatorContext constraintValidatorContext) {

        if (messageDTO == null) return false;

        if (MessageType.EMOTE.equals(messageDTO.getType())) {
            Pattern pattern = Pattern.compile(EMOTE_REGEX);
            if(!pattern.matcher(messageDTO.getPayload()).matches()) {
               return false;
            }
        }

        if (MessageType.TEXT.equals(messageDTO.getType())) {
            Pattern pattern = Pattern.compile(TEXT_REGEX);
            if(!pattern.matcher(messageDTO.getPayload()).matches()) {
                return false;
            }
        }

        return true;
    }
}
