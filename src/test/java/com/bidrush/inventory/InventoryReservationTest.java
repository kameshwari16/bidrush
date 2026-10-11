package com.bidrush.inventory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventoryReservationTest {
    @Test
    public void shouldReserveAvailableStock() {
        //AAA
        //Arrange
        InventoryReservation reservation=new InventoryReservation(10);
        //Act
        reservation.reserve(6);
        //Assert
        assertEquals(4,reservation.getAvailableStock());
    }
    @Test
    void shouldRejectReservationWhenStockIsInsufficient(){
        InventoryReservation reservation=new InventoryReservation(10);
        reservation.reserve(6);
        assertThrows(IllegalArgumentException.class,()->reservation.reserve(5));
        assertEquals(4,reservation.getAvailableStock());
    }
}
