package com.caglartelef.auctionbidtracker.exception.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
        log.error("[ItemNotFoundException] -> item not found exception message: {}", message);
    }
}
