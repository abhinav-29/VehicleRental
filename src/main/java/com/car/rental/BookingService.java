package com.car.rental;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class BookingService {

    public void book(Slot slot, Vehicle vehicle, Integer count, Integer userId) {
        Objects.requireNonNull(count);
        Objects.requireNonNull(vehicle);
        Objects.requireNonNull(slot);
        Objects.requireNonNull(userId);
        if (count < 1) {
            throw new IllegalArgumentException("Count is invalid");
        }

        int availableCount = Optional.ofNullable(Database.INSTANCE.inventory.get(slot)).map(map -> map.get(vehicle)).orElse(0);

        if (availableCount < count) {
            throw new RuntimeException("Inventory not available");
        }

        saveBooking(vehicle, slot, count, userId);
        Database.INSTANCE.inventory.get(slot).put(vehicle, availableCount - count);
    }

    private void saveBooking(Vehicle vehicle, Slot slot, Integer count, Integer userId) {
        Booking booking = new Booking();
        booking.setVehicle(vehicle);
        booking.setSlot(slot);
        booking.setCount(count);
        booking.setUserId(userId);
        Database.INSTANCE.bookings.add(booking);
    }
}
