package com.example.demo.dtos;

public class Message {
    private String User;
    private String content;

    public Message(String user, String content) {
        User = user;
        this.content = content;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
