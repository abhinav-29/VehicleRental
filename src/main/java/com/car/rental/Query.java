package com.car.rental;

public class Query {

    private Slot slot;
    private Vehicle vehicle;
    private boolean sortByPrice;

    public Slot getSlot() {
        return slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Query setSlot(Slot slot) {
        this.slot = slot;
        return this;
    }

    public Query setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public Query setSortByPrice(boolean sortByPrice) {
        this.sortByPrice = sortByPrice;
        return this;
    }

    public boolean isSortByPrice() {
        return sortByPrice;
    }
}
