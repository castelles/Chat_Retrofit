package com.example.chat_retrofit.model;

public class MessageRetro {

    private String text;
    private int id;

    public MessageRetro(String text, int id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
