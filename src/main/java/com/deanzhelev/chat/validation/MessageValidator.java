package com.deanzhelev.chat.validation;

import com.deanzhelev.chat.model.MessageType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Component
public class MessageValidator {

    private final String TEXT_REGEX = "^.{1,160}$";
    private final String EMOTE_REGEX = "^[^(0-9)]{2,10}$";

    public boolean validateMessage(String payload, MessageType type) {
        if (StringUtils.isEmpty(payload) || type == null) return false;

        if (MessageType.SEND_EMOTE.equals(type)) {
            Pattern pattern = Pattern.compile(EMOTE_REGEX);
            if(!pattern.matcher(payload).matches()) {
                return false;
            }
        }

        if (MessageType.SEND_TEXT.equals(type)) {
            Pattern pattern = Pattern.compile(TEXT_REGEX);
            if(!pattern.matcher(payload).matches()) {
                return false;
            }
        }
        return true;
    }
}
