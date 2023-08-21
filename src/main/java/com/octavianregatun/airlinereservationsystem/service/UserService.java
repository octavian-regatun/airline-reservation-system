package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.User;
import com.octavianregatun.airlinereservationsystem.rest.response.UserResponse;

import java.util.List;

public interface UserService {
    User findById(int id);

    List<User> findAll();

    UserResponse getUserResponse(User user);

    List<UserResponse> getUserResponses(List<User> users);

    User update(User user);
}