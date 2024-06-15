package com.mathboy11;

public class SocketIOMessage {
    private String message;

    public SocketIOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
