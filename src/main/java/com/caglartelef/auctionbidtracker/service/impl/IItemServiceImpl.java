package com.caglartelef.auctionbidtracker.service.impl;

import com.caglartelef.auctionbidtracker.repository.ItemRepository;
import com.caglartelef.auctionbidtracker.repository.entity.Item;
import com.caglartelef.auctionbidtracker.reqeust.ItemCreateRequest;
import com.caglartelef.auctionbidtracker.service.IItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IItemServiceImpl implements IItemService {
    private final ItemRepository itemRepository;

    @Override
    public Item createItem(ItemCreateRequest request) {
        log.debug("[{}][createItem] -> request itemDTO: {}", this.getClass().getSimpleName(), request);
        Item createdItem = itemRepository.save(Item.builder()
                .basePrice(request.getBasePrice())
                .itemName(request.getItemName())
                .build());
        log.debug("[{}][createItem] -> response itemDTO: {}", this.getClass().getSimpleName(), createdItem);
        return createdItem;
    }

    @Override
    public List<Item> getItems() {
        log.debug("[{}][getItems] -> request ", this.getClass().getSimpleName());
        List<Item> items = new ArrayList<>();
        Iterable<Item> itemIterable = itemRepository.findAll();

        for (Item item : itemIterable) {
            items.add(item);
        }
        log.debug("[{}][getItems] -> response items: {}", this.getClass().getSimpleName(), items);
        return items;
    }
}
