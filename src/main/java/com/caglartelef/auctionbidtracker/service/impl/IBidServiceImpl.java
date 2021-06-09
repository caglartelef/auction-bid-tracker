package com.caglartelef.auctionbidtracker.service.impl;

import com.caglartelef.auctionbidtracker.exception.exceptions.BidNotFoundException;
import com.caglartelef.auctionbidtracker.exception.exceptions.BidValueIsNotAcceptableException;
import com.caglartelef.auctionbidtracker.repository.BidRepository;
import com.caglartelef.auctionbidtracker.repository.entity.Bid;
import com.caglartelef.auctionbidtracker.repository.entity.User;
import com.caglartelef.auctionbidtracker.reqeust.BidCreateRequest;
import com.caglartelef.auctionbidtracker.response.ItemVm;
import com.caglartelef.auctionbidtracker.service.IBidService;
import com.caglartelef.auctionbidtracker.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class IBidServiceImpl implements IBidService {
    private final BidRepository bidRepository;
    private final IUserService userService;

    @Override
    public Bid createBidForItem(BidCreateRequest request) {
        log.debug("[{}][createBidForItem] -> request : {}", this.getClass().getSimpleName(), request);
        List<Bid> bidList = bidRepository.findAllByItemIdOrderByBidPriceDesc(request.getItemId());
        if (!bidList.isEmpty()) {
            if (request.getBidPrice() <= bidList.get(0).getBidPrice()) {
                throw new BidValueIsNotAcceptableException("Current Bid Value is less than the last highest bid value.");
            }
        }
        Bid bid = bidRepository.save(Bid.builder()
                .bidPrice(request.getBidPrice())
                .itemId(request.getItemId())
                .userId(request.getUserId())
                .build());
        log.debug("[{}][createBidForItem] -> response : {}", this.getClass().getSimpleName(), request);
        return bid;
    }

    @Override
    public Page<Bid> getAllBidsForItem(int itemId, Pageable pageable) {
        log.debug("[{}][getAllBidsForItem] -> request itemId: {}", this.getClass().getSimpleName(), itemId);
        Page<Bid> pageBid = bidRepository.findAllByItemIdOrderByBidPriceDesc(itemId, pageable);
        if (pageBid.isEmpty()) {
            throw new BidNotFoundException("Bid not found for itemId: " + itemId);
        }
        log.debug("[{}][getAllBidsForItem] -> response itemId: {} pageBid: {}", this.getClass().getSimpleName(), itemId, pageBid);
        return pageBid;
    }

    @Override
    public List<Bid> getBidsListByUserId(int userId) {
        log.debug("[{}][getBidsListByUserId] -> request userId : {}", this.getClass().getSimpleName(), userId);
        List<Bid> bidList;
        bidList = bidRepository.findAllByUserId(userId);
        if (Objects.isNull(bidList) || bidList.isEmpty()) {
            throw new BidNotFoundException("Bid list not found for userId: " + userId);
        }
        log.debug("[{}][getBidsListByUserId] -> response userId: {} bidList: {}", this.getClass().getSimpleName(), userId, bidList);
        return bidList;
    }

    @Override
    public ItemVm getWinningBid(int itemId) {
        log.debug("[{}][getWinningBid] -> request userId : {}", this.getClass().getSimpleName(), itemId);
        ItemVm itemVm = new ItemVm();
        List<Bid> bidList;
        bidList = bidRepository.findAllByItemIdOrderByBidPriceDesc(itemId);
        if (bidList.isEmpty()) {
            throw new BidNotFoundException("Bid list not found for itemId: " + itemId);
        }
        Bid bid = bidList.get(0);
        User user = userService.getUserById(bid.getUserId());
        itemVm.setUser(user);
        itemVm.setBidId(bid.getId());
        itemVm.setBidPrice(bid.getBidPrice());
        itemVm.setItemId(bid.getItemId());
        log.debug("[{}][getWinningBid] -> response itemId : {}", this.getClass().getSimpleName(), itemId);
        return itemVm;
    }
}
