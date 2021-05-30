package com.car.rental;

public class QueryResultDto {

    private Vehicle vehicle;
    private Slot slot;
    private Integer price;
    private Integer count;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Slot getSlot() {
        return slot;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "QueryResultDto{" +
                "vehicle=" + vehicle +
                ", slot=" + slot +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
