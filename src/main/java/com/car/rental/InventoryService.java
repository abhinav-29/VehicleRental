package com.car.rental;

import java.util.HashMap;
import java.util.Objects;

public class InventoryService {

    public void update(Slot slot, Vehicle vehicle, Integer count) {
        Objects.requireNonNull(slot);
        Objects.requireNonNull(vehicle);
        Objects.requireNonNull(count);

        Database.INSTANCE.inventory.computeIfAbsent(slot, k -> new HashMap<>()).put(vehicle, count);
    }
}
