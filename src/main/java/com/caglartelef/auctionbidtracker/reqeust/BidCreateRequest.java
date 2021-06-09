package com.caglartelef.auctionbidtracker.reqeust;

import lombok.Data;

@Data
public class BidCreateRequest {
    private int userId;
    private int itemId;
    private int bidPrice;
}
