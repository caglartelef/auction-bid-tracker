package com.caglartelef.auctionbidtracker;

import com.caglartelef.auctionbidtracker.repository.entity.Item;
import com.caglartelef.auctionbidtracker.reqeust.ItemCreateRequest;
import com.caglartelef.auctionbidtracker.service.IItemService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemControllerTestCases {
    Logger logger = LoggerFactory.getLogger(ItemControllerTestCases.class);

    @Autowired
    IItemService IItemService;

    @Ignore
    @Test
    public void getItems() {
        List<Item> itemList = IItemService.getItems();
        for (Item item : itemList) {
            logger.info("id->" + item.getId());
            logger.info("itemName->" + item.getItemName());
            logger.info("basePrice->" + item.getBasePrice());
        }
    }

    @Ignore
    @Test
    public void createItem() {
        ItemCreateRequest itemDTO = new ItemCreateRequest();
        itemDTO.setItemName("NewItem");
        itemDTO.setBasePrice(4000);
        Item item = IItemService.createItem(itemDTO);

        logger.info("id->" + item.getId());
        logger.info("itemName->" + item.getItemName());
        logger.info("basePrice->" + item.getBasePrice());
    }
}
