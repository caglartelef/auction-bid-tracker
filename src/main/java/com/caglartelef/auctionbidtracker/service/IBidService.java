package com.caglartelef.auctionbidtracker.service;

import com.caglartelef.auctionbidtracker.repository.entity.Bid;
import com.caglartelef.auctionbidtracker.reqeust.BidCreateRequest;
import com.caglartelef.auctionbidtracker.response.ItemVm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBidService {

    Bid createBidForItem(BidCreateRequest request);

    Page<Bid> getAllBidsForItem(int itemId, Pageable pageable);

    List<Bid> getBidsListByUserId(int userId);

    ItemVm getWinningBid(int itemId);
}
