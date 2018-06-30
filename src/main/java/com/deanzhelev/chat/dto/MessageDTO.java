package com.deanzhelev.chat.dto;

import com.deanzhelev.chat.model.MessageType;
import com.deanzhelev.chat.validation.IsValidPayload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@IsValidPayload
public class MessageDTO implements Serializable {


    @NotEmpty
    private String payload;
    @NotNull
    private MessageType type;

    public MessageDTO() {}

    public MessageDTO(@NotEmpty String payload, @NotNull MessageType type) {
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
