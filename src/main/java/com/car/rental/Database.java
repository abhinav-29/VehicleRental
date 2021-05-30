package com.car.rental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private Database() {

    }

    public static Database INSTANCE = new Database();

    public Map<Slot, Map<Vehicle, Integer>> inventory = new HashMap<>();

    public List<Booking> bookings = new ArrayList<>();

    public Map<Slot, Map<Vehicle, Integer>> price = new HashMap<>();
}
