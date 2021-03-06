package com.deanzhelev.chat.converter;

import com.deanzhelev.chat.model.MessageType;
import org.springframework.core.convert.converter.Converter;

public class MessageTypeConverter implements Converter<String, MessageType> {

    @Override
    public MessageType convert(String source) {
        return MessageType.fromString(source);
    }
}
