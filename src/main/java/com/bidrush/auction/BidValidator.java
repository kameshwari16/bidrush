package com.bidrush.auction;

import java.math.BigDecimal;

public interface BidValidator {
    void validate(Bid bid, BigDecimal currentPrice);
}
