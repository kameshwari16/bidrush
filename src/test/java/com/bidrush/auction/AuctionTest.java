package com.bidrush.auction;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuctionTest {
    @Test
    void shouldAcceptHigherBid() {

        BidValidator validator = new HigherBidValidator();

        Auction auction = new Auction(
                "AUC-101",
                new BigDecimal("40000"),
                validator
        );

        Bid bid = new Bid(
                "buyer-101",
                new BigDecimal("45000")
        );

        // TODO: Place the bid
        auction.placeBid(bid);

        // TODO: Verify current price is 45000
        assertEquals(new BigDecimal("45000"),auction.getCurrentPrice());

        // TODO: Verify bid history size is 1
        assertEquals(1,auction.getBidHistory().size());
    }
    @Test
    void shouldRejectLowerBid() {

        BidValidator validator = new HigherBidValidator();

        Auction auction = new Auction(
                "AUC-101",
                new BigDecimal("40000"),
                validator
        );

        Bid firstBid = new Bid(
                "buyer-101",
                new BigDecimal("45000")
        );

        Bid secondBid = new Bid(
                "buyer-102",
                new BigDecimal("42000")
        );

        auction.placeBid(firstBid);

        // TODO 1: Verify that secondBid throws
        // IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> auction.placeBid(secondBid));

        // TODO 2: Verify current price remains 45000
        assertEquals(new BigDecimal("45000"),auction.getCurrentPrice());

        // TODO 3: Verify bid history size remains 1
        assertEquals(1,auction.getBidHistory().size());
    }
    @Test
    void shouldRejectEqualBid() {
        // Your implementation
        BidValidator validator = new HigherBidValidator();
        Auction auction = new Auction(
                "AUC-101",
                new BigDecimal("40000"),
                validator
        );
        Bid firstBid = new Bid(
                "buyer-101",
                new BigDecimal("45000")
        );
        Bid secondBid = new Bid(
                "buyer-102",
                new BigDecimal("45000")
        );
        auction.placeBid(firstBid);
        assertThrows(IllegalArgumentException.class, () -> auction.placeBid(secondBid));
        assertEquals(new BigDecimal("45000"),auction.getCurrentPrice());
        assertEquals(1,auction.getBidHistory().size());
    }
}
