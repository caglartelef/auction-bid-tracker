package com.caglartelef.auctionbidtracker.reqeust;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String userName;
    private int accountBalance;
}
