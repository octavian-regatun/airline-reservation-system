package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(User userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
