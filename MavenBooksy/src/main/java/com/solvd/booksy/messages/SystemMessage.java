package com.solvd.booksy.messages;

public class SystemMessage extends Message {

    public SystemMessage(){}

    public SystemMessage(String text) {
        super(text);
    }

    @Override
    public void printMessage(String text) {
        System.out.println("SYSTEM -> " + getText() + " (" + getSentAt() + ")");
    }
}
