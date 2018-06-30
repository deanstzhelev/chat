package com.deanzhelev.chat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MessageType {
    @JsonProperty("send_text")
    TEXT,
    @JsonProperty("send_emote")
    EMOTE
}
