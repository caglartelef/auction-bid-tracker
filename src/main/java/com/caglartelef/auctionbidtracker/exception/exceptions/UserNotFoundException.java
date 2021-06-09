package com.caglartelef.auctionbidtracker.exception.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
        log.error("[UserNotFoundException] -> user not found exception message: {}", message);
    }
}
