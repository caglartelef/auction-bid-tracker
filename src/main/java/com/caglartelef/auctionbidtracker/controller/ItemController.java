package com.caglartelef.auctionbidtracker.controller;

import com.caglartelef.auctionbidtracker.repository.entity.Item;
import com.caglartelef.auctionbidtracker.reqeust.ItemCreateRequest;
import com.caglartelef.auctionbidtracker.service.IItemService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/1.0")
@RequiredArgsConstructor
public class ItemController {
    private final IItemService itemService;

    @ApiOperation("This API is used to get create items for auctions.")
    @PostMapping("/create-item")
    public ResponseEntity<Item> createItem(@RequestBody ItemCreateRequest request) {
        Item resultBody = itemService.createItem(request);
        return ResponseEntity.status(HttpStatus.OK).body(resultBody);
    }

    @ApiOperation("This API is used to get the list of items.")
    @GetMapping("/get-items")
    public ResponseEntity<List<Item>> getItemsList() {
        List<Item> resultBody = itemService.getItems();
        return ResponseEntity.status(HttpStatus.OK).body(resultBody);
    }
}
