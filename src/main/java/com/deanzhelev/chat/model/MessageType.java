package com.deanzhelev.chat.model;

public enum MessageType {

    SEND_TEXT("send_text"),
    SEND_EMOTE("send_emote");

    private String value;
    MessageType (String value) {
        this.value = value;
    }
    private String getValue() {
        return value;
    }

    public static MessageType fromString(String text) {
        for (MessageType type : MessageType.values()) {
            if (type.value.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return null;
    }
}
