package com.caglartelef.auctionbidtracker.exception.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BidValueIsNotAcceptableException extends RuntimeException {
    public BidValueIsNotAcceptableException(String message) {
        super(message);
        log.error("[BidValueIsNotAcceptableException] -> bid value is not acceptable exception message: {}", message);
    }
}
