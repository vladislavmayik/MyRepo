package com.solvd.booksy.messages;

import java.time.LocalDateTime;

public abstract class Message {

    private LocalDateTime sentAt;
    private String text;

    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Message(){}
    public Message(String text) {
        this.text = text;
        this.sentAt = LocalDateTime.now();
    }

    public abstract void printMessage(String text);
}