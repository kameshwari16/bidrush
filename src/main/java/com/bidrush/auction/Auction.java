package com.bidrush.auction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Auction {
    private String auctionId;
    private BigDecimal currentPrice;
    private final BidValidator bidValidator;
    List<Bid> bidHistory=new ArrayList<>();
    public Auction(String auctionId, BigDecimal startingPrice,BidValidator bidValidator) {
        this.auctionId = auctionId;
        this.currentPrice = startingPrice;
        this.bidValidator = bidValidator;
    }
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }
    public void placeBid(Bid bid){
        bidValidator.validate(bid,currentPrice);
        currentPrice=bid.Amount();
        bidHistory.add(bid);
    }
    public List<Bid> getBidHistory() {
        return List.copyOf(bidHistory);
    }
    public void printBidHistory() {
       for(Bid bid:bidHistory){
           System.out.println("Buyer:"+bid.bidderId()+" | Amount:"+bid.Amount());
       }
    }
}
