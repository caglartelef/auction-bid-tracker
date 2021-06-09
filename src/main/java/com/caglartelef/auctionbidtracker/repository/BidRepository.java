package com.caglartelef.auctionbidtracker.repository;

import com.caglartelef.auctionbidtracker.repository.entity.Bid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends CrudRepository<Bid, Integer> {

    Page<Bid> findAllByItemIdOrderByBidPriceDesc(int itemId, Pageable pageable);

    List<Bid> findAllByUserId(int userId);

    List<Bid> findAllByItemIdOrderByBidPriceDesc(int itemId);
}
