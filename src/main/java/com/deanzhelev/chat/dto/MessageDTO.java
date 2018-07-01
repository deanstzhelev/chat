package com.deanzhelev.chat.dto;

import com.deanzhelev.chat.model.MessageType;

public class MessageDTO {

    private String payload;
    private MessageType type;

    public MessageDTO() {}

    public MessageDTO(String payload,MessageType type) {
        this.payload = payload;
        this.type = type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
