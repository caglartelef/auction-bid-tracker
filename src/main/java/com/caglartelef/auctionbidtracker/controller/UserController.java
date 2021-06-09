package com.caglartelef.auctionbidtracker.controller;

import com.caglartelef.auctionbidtracker.repository.entity.User;
import com.caglartelef.auctionbidtracker.reqeust.UserCreateRequest;
import com.caglartelef.auctionbidtracker.service.IUserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/1.0")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @ApiOperation("This API is used to create user.")
    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        User resultBody = userService.createUser(userCreateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(resultBody);
    }

    @ApiOperation("This API is used to get the list of user.")
    @GetMapping("/get-users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> resultBody = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(resultBody);
    }
}
