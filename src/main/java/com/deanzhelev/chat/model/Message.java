package com.deanzhelev.chat.model;

import javax.persistence.*;

@Entity
@Table
public class Message extends AbstractDomainEntity {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type", nullable = false, updatable = false)
    private MessageType type;

    @Column(name = "payload", nullable = false, updatable = false)
    private String payload;

    protected Message(String payload, MessageType messageType) {
        this.payload = payload;
        this.type = messageType;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }


}
