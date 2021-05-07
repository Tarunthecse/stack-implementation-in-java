package com.stack.rep;

public class ErrorRep {
    private String message = null;
    private String detailMessage = null;

    public ErrorRep() {
    }

    public ErrorRep(String message, String detailMessage) {
        this.message = message;
        this.detailMessage = detailMessage;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetailMessage() {
        return this.detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

}
