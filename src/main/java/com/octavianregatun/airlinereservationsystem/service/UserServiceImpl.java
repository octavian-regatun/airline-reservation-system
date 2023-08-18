package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.User;
import com.octavianregatun.airlinereservationsystem.exception.CustomException;
import com.octavianregatun.airlinereservationsystem.repository.UserRepository;
import com.octavianregatun.airlinereservationsystem.rest.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) {
        if (userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        throw new CustomException("User with id " + id + " not found");
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse getUserResponse(User user) {
        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());

        return userResponse;
    }

    @Override
    public List<UserResponse> getUserResponses(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
            userResponses.add(getUserResponse(user));
        }

        return userResponses;
    }
}