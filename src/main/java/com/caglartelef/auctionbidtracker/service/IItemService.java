package com.caglartelef.auctionbidtracker.service;

import com.caglartelef.auctionbidtracker.repository.entity.Item;
import com.caglartelef.auctionbidtracker.reqeust.ItemCreateRequest;

import java.util.List;

public interface IItemService {
    Item createItem(ItemCreateRequest request);

    List<Item> getItems();
}