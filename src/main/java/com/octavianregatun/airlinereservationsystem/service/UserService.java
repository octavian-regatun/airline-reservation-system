package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.User;

import java.util.List;

public interface UserService {
    User findById(int id);

    List<User> findAll();
}