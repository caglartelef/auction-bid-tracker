package com.caglartelef.auctionbidtracker.exception.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BidNotFoundException extends RuntimeException {
    public BidNotFoundException(String message) {
        super(message);
        log.error("[BidNotFoundException] -> bid not found exception message: {}", message);
    }
}
