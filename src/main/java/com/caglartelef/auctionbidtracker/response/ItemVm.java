package com.caglartelef.auctionbidtracker.response;

import com.caglartelef.auctionbidtracker.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemVm {
    private User user;
    private int bidId;
    private int itemId;
    private int bidPrice;
}