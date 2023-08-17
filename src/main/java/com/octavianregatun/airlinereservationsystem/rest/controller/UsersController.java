package com.octavianregatun.airlinereservationsystem.rest.controller;

import com.octavianregatun.airlinereservationsystem.entity.PublicUser;
import com.octavianregatun.airlinereservationsystem.entity.User;
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
    ResponseEntity<PublicUser> GetUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id).getPublicUser());
    }

    @GetMapping
    ResponseEntity<List<PublicUser>> GetUsers() {
        List<User> users = userService.findAll();
        List<PublicUser> publicUsers = users.stream().map(user -> user.getPublicUser()).toList();

        return ResponseEntity.ok(publicUsers);
    }
}
