package com.caglartelef.auctionbidtracker.service.impl;

import com.caglartelef.auctionbidtracker.exception.exceptions.UserNotFoundException;
import com.caglartelef.auctionbidtracker.repository.UserRepository;
import com.caglartelef.auctionbidtracker.repository.entity.User;
import com.caglartelef.auctionbidtracker.reqeust.UserCreateRequest;
import com.caglartelef.auctionbidtracker.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class IUserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(UserCreateRequest request) {
        log.error("[{}][createUser] request -> request: {}", this.getClass().getSimpleName(), request);
        User savedUser = userRepository.save(User.builder()
                .accountBalance(request.getAccountBalance())
                .userName(request.getUserName())
                .build());
        log.error("[{}][createUser] response -> usersDTO: {}", this.getClass().getSimpleName(), savedUser);
        return savedUser;
    }

    @Override
    public List<User> getUsers() {
        log.debug("[{}][getUsers] -> request ", this.getClass().getSimpleName());
        List<User> users = new ArrayList<>();
        Iterable<User> userIterable = userRepository.findAll();

        for (User user : userIterable) {
            users.add(user);
        }
        log.debug("[{}][getUsers] -> response users: {}", this.getClass().getSimpleName(), users);
        return users;
    }

    @Override
    public User getUserById(int userId) {
        log.error("[{}][getUserById] request -> userId: {}", this.getClass().getSimpleName(), userId);
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found exception for userId: " + userId);
        }
        log.error("[{}][getUserById] response -> usersDTO: {}", this.getClass().getSimpleName(), optionalUser.get());
        return optionalUser.get();
    }
}
