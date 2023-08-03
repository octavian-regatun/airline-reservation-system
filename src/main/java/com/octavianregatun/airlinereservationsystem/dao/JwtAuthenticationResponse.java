package com.octavianregatun.airlinereservationsystem.dao;

public class JwtAuthenticationResponse {

    String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
