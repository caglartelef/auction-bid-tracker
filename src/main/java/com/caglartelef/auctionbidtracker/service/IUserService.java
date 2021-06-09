package com.caglartelef.auctionbidtracker.service;

import com.caglartelef.auctionbidtracker.repository.entity.User;
import com.caglartelef.auctionbidtracker.reqeust.UserCreateRequest;

import java.util.List;

public interface IUserService {
    User createUser(UserCreateRequest request);

    List<User> getUsers();

    User getUserById(int userId);
}
