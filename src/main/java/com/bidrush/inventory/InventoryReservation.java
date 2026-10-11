package com.bidrush.inventory;

public class InventoryReservation {
    private final int totalStock;
    private int reservedStock;
    public InventoryReservation(int totalStock) {
        this.totalStock = totalStock;
        this.reservedStock = 0;
    }
    public int getAvailableStock() {
        return totalStock - reservedStock;
    }
    public void reserve(int quantity){
        if(quantity<=0 || quantity>getAvailableStock()){
            throw new IllegalArgumentException("Quantity invalid");
        }
        reservedStock += quantity;
    }
}
