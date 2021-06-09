package com.caglartelef.auctionbidtracker;

import com.caglartelef.auctionbidtracker.repository.entity.User;
import com.caglartelef.auctionbidtracker.reqeust.UserCreateRequest;
import com.caglartelef.auctionbidtracker.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTestCases {

    @Autowired
    private IUserService IUserService;

    Logger logger = LoggerFactory.getLogger(UserControllerTestCases.class);

    @Test
    public void createUser() {
        UserCreateRequest usersDTO = new UserCreateRequest();
        usersDTO.setUserName("Mark");
        usersDTO.setAccountBalance(300000);
        User result = IUserService.createUser(usersDTO);

        logger.info("id->" + result.getId());
        logger.info("userName->" + result.getUserName());
        logger.info("accountBalance->" + result.getAccountBalance());
    }

}
