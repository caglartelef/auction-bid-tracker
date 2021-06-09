package com.caglartelef.auctionbidtracker.controller;

import com.caglartelef.auctionbidtracker.repository.entity.Bid;
import com.caglartelef.auctionbidtracker.reqeust.BidCreateRequest;
import com.caglartelef.auctionbidtracker.response.ItemVm;
import com.caglartelef.auctionbidtracker.service.IBidService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/1.0")
@RequiredArgsConstructor
public class BidController {
    private final IBidService bidService;

    @ApiOperation("This API is used to bid on the item in an auction by the user.")
    @PostMapping("/create-bid")
    public ResponseEntity<Bid> createBid(@RequestBody BidCreateRequest request) {
        log.debug("[{}][saveBid] -> request: {}", this.getClass().getSimpleName(), request);
        Bid bid = bidService.createBidForItem(request);
        log.debug("[{}][saveBid] -> response request: {} bidDTO: {}", this.getClass().getSimpleName(), request, bid);
        return ResponseEntity.status(HttpStatus.OK).body(bid);
    }

    @ApiOperation("This Api gets the track or list of bids on an item in auction.")
    @GetMapping("/get-bids/{itemId}")
    public ResponseEntity<Page<Bid>> getBidsForItem(@PathVariable(value = "itemId") int itemId, Pageable pageable) {
        log.debug("[{}][getBidsForItem] -> request itemId: {}", this.getClass().getSimpleName(), itemId);
        Page<Bid> pageBid = bidService.getAllBidsForItem(itemId, pageable);
        log.debug("[{}][getBidsForItem] -> response itemId: {} pageBid: {}", this.getClass().getSimpleName(), itemId, pageBid);
        return ResponseEntity.status(HttpStatus.OK).body(pageBid);
    }

    @ApiOperation("This API is used to get the winning bid and the details of the respective user.")
    @GetMapping("/get-winning-bid/{itemId}")
    public ResponseEntity<ItemVm> getWinningBid(@PathVariable(value = "itemId") int itemId) {
        log.debug("[{}][getWinningBid] -> request itemId: {}", this.getClass().getSimpleName(), itemId);
        ItemVm itemVm = bidService.getWinningBid(itemId);
        log.debug("[{}][getWinningBid] -> response itemId: {} itemVm: {}", this.getClass().getSimpleName(), itemId, itemVm);
        return ResponseEntity.status(HttpStatus.OK).body(itemVm);
    }

    @ApiOperation("This API gets the track or list of bids on a user in the auction.")
    @GetMapping("/get-bids-user/{userId}")
    public ResponseEntity<List<Bid>> getBidsForUser(@PathVariable(value = "userId") int userId) {
        log.debug("[{}][getBidsForItem] -> request itemId: {}", this.getClass().getSimpleName(), userId);
        List<Bid> bids = bidService.getBidsListByUserId(userId);
        log.debug("[{}][getBidsForItem] -> response itemId: {} pageBid: {}", this.getClass().getSimpleName(), userId, bids);
        return ResponseEntity.status(HttpStatus.OK).body(bids);
    }
}