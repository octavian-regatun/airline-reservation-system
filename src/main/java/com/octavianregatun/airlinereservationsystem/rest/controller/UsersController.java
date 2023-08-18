package com.octavianregatun.airlinereservationsystem.rest.controller;

import com.octavianregatun.airlinereservationsystem.entity.User;
import com.octavianregatun.airlinereservationsystem.rest.response.UserResponse;
import com.octavianregatun.airlinereservationsystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    UserService userService;

    UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    ResponseEntity<UserResponse> GetUser(@PathVariable int id) {
        User user = userService.findById(id);
        UserResponse userResponse = userService.getUserResponse(user);

        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    ResponseEntity<List<UserResponse>> GetUsers() {
        List<User> users = userService.findAll();
        List<UserResponse> userResponseList = userService.getUserResponses(users);

        return ResponseEntity.ok(userResponseList);
    }
}
