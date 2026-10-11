package com.bidrush.auction;

import com.bidrush.inventory.InventoryReservation;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BidValidator validator=new HigherBidValidator();
        Auction auction = new Auction(
                "AUC-101",
                new BigDecimal("40000"),
                validator
        );

        Bid bid1 = new Bid(
                "buyer-101",
                new BigDecimal("50000")
        );
        Bid bid2 = new Bid(
                "buyer-102",
                new BigDecimal("53000")
        );

        Bid bid3 = new Bid(
                "buyer-103",
                new BigDecimal("60000")
        );

        auction.placeBid(bid1);
        auction.placeBid(bid2);

//        try{
//            auction.placeBid(bid3);
//        }
//        catch(IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println(
//                auction.getCurrentPrice()
//        );
//        System.out.println(auction.getBidHistory().size());
//        auction.printBidHistory();

        InventoryReservation inventory =
                new InventoryReservation(10);

        inventory.reserve(3);
        inventory.reserve(5);

        System.out.println(inventory.getAvailableStock());
// Expected: 2

//        inventory.reserve(4);
// Expected: IllegalArgumentException
    }
}
