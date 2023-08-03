package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.dao.JwtAuthenticationResponse;
import com.octavianregatun.airlinereservationsystem.dao.SignInRequest;
import com.octavianregatun.airlinereservationsystem.dao.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}