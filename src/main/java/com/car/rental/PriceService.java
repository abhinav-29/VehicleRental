package com.car.rental;

import java.util.HashMap;
import java.util.Objects;

public class PriceService {

    public void update(Slot slot, Vehicle vehicle, Integer price) {
        Objects.requireNonNull(slot);
        Objects.requireNonNull(vehicle);
        Objects.requireNonNull(price);

        Database.INSTANCE.price.computeIfAbsent(slot, k -> new HashMap<>()).put(vehicle, price);
    }
}
