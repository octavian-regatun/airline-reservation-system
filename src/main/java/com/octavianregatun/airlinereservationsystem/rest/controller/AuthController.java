package com.octavianregatun.airlinereservationsystem.rest.controller;

import com.octavianregatun.airlinereservationsystem.rest.response.JwtAuthenticationResponse;
import com.octavianregatun.airlinereservationsystem.rest.request.SignInRequest;
import com.octavianregatun.airlinereservationsystem.rest.request.SignUpRequest;
import com.octavianregatun.airlinereservationsystem.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    AuthenticationService authenticationService;

    AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("sign-up")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("sign-in")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
