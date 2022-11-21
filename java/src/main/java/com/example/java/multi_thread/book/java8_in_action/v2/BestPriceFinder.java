package com.example.java.multi_thread.book.java8_in_action.v2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                   new Shop("LetsSaveBig"),
                                                   new Shop("MyFavoriteShop"),
                                                   new Shop("BuyItAll"),
                                                   new Shop("BuyItAll2"));

    public List<String> findPricesSequential(String product) {
        return shops.stream()
                .map(shop -> shop.getPrice(product)) // delay
                .map(Quote::parse)
                .map(Discount::applyDiscount) // delay
                .collect(Collectors.toList());
    }

}
