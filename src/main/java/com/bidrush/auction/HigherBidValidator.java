package com.bidrush.auction;

import java.math.BigDecimal;

public class HigherBidValidator implements BidValidator {
    @Override
    public void validate(Bid bid, BigDecimal currentPrice) {
        if(bid.Amount().compareTo(currentPrice) <= 0) {
            throw new IllegalArgumentException("Bid must be higher than current price");
        }
    }
}
