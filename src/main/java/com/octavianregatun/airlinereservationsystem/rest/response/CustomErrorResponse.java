package com.octavianregatun.airlinereservationsystem.rest.response;

import org.springframework.http.HttpStatus;

public class CustomErrorResponse {
    private HttpStatus status;
    private String message;
    private final long timestamp = System.currentTimeMillis();

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public CustomErrorResponse(String message, HttpStatus status) {
        this.status = status;
        this.message = message;
    }
}
