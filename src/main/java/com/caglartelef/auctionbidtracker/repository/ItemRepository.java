package com.caglartelef.auctionbidtracker.repository;

import com.caglartelef.auctionbidtracker.repository.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
