package com.solvd.booksy.messages;

import com.solvd.booksy.users.Client;
import com.solvd.booksy.users.Master;

public class ChatMessage extends Message {

    private Client clientSender;
    private Master masterSender;

    public ChatMessage(){}

    public ChatMessage(String text) {
        super(text);
    }

    public Client getClientSender() { return clientSender; }
    public void setClientSender(Client clientSender) { this.clientSender = clientSender; }

    public Master getMasterSender() { return masterSender; }
    public void setMasterSender(Master masterSender) { this.masterSender = masterSender; }

    @Override
    public void printMessage(String text) {
        System.out.println("com.solvd.booksy.messages.ChatMessage -> " + getText() + " (" + getSentAt() + ")");
    }
}