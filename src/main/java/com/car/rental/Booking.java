package com.car.rental;

public class Booking {
    private Integer userId;
    private Vehicle vehicle;
    private Slot slot;
    private Integer count;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
