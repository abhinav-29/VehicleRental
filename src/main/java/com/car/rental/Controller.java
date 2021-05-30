package com.car.rental;

import java.util.List;

public class Controller {

    private InventoryService inventoryService = new InventoryService();

    private BookingService bookingService = new BookingService();

    private PriceService priceService = new PriceService();

    private QueryService queryService = new QueryService();

    public void updateInventory(Slot slot, Vehicle vehicle, Integer count, Integer price) {
        inventoryService.update(slot, vehicle, count);
        priceService.update(slot, vehicle, price);
    }

    public void book(Slot slot, Vehicle vehicle, Integer count, Integer userId) {
        bookingService.book(slot, vehicle, count, userId);
    }

    public List<QueryResultDto> query(Query query) {
        return queryService.query(query);
    }
}
