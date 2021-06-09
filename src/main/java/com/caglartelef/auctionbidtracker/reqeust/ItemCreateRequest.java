package com.caglartelef.auctionbidtracker.reqeust;

import lombok.Data;

@Data
public class ItemCreateRequest {
    private String itemName;
    private int basePrice;
}
