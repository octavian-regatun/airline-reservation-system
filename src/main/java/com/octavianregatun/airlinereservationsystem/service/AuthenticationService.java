package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.rest.response.JwtAuthenticationResponse;
import com.octavianregatun.airlinereservationsystem.rest.request.SignInRequest;
import com.octavianregatun.airlinereservationsystem.rest.request.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}