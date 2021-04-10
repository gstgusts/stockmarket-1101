package com.example.stockmarket;

import com.example.stockmarket.data.StockMarketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class StockmarketApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getCategories() {
        var repo = new StockMarketRepository();

        var result = repo.getCategories();

        Assert.notEmpty(result);
    }

}
