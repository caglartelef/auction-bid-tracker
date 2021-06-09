package com.caglartelef.auctionbidtracker.exception.handler;

import com.caglartelef.auctionbidtracker.exception.exceptions.BidNotFoundException;
import com.caglartelef.auctionbidtracker.exception.exceptions.BidValueIsNotAcceptableException;
import com.caglartelef.auctionbidtracker.exception.exceptions.ItemNotFoundException;
import com.caglartelef.auctionbidtracker.exception.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BidNotFoundException.class)
    public ResponseEntity<String> handleBidNotFoundException(BidNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BidValueIsNotAcceptableException.class)
    public ResponseEntity<String> handleBidValueIsNotAcceptableException(BidValueIsNotAcceptableException exception) {
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

}
