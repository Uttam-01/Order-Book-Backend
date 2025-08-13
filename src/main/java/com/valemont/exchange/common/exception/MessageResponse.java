package com.valemont.exchange.common.exception;

public class MessageResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public MessageResponse(String message) {
        this.message = message;
    }
}
