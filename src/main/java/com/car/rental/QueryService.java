package com.car.rental;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class QueryService {

    private final Comparator<QueryResultDto> PRICE_COMPARATOR = new Comparator<QueryResultDto>() {
        @Override
        public int compare(QueryResultDto dto1, QueryResultDto dto2) {
            return dto1.getPrice() - dto2.getPrice();
        }
    };

    public List<QueryResultDto> query(Query query) {
        Objects.requireNonNull(query);

        List<QueryResultDto> result = getInventory();

        result = result.stream().filter(queryResultDto -> queryResultDto.getCount() != 0).collect(Collectors.toList());

        if (query.getSlot() != null) {
            result = result.stream().filter(queryResultDto -> query.getSlot().equals(queryResultDto.getSlot())).collect(Collectors.toList());
        }
        if (query.getVehicle() != null) {
            result = result.stream().filter(queryResultDto -> query.getVehicle().equals(queryResultDto.getVehicle())).collect(Collectors.toList());
        }
        if (query.isSortByPrice()) {
            result.sort(PRICE_COMPARATOR);
        }
        return result;
    }

    private List<QueryResultDto> getInventory() {
        List<QueryResultDto> result = new ArrayList<>();
        for (Map.Entry<Slot, Map<Vehicle, Integer>> entry: Database.INSTANCE.inventory.entrySet()) {
            for (Map.Entry<Vehicle, Integer> vehicleEntry: entry.getValue().entrySet()) {
                Integer price = Optional.ofNullable(Database.INSTANCE.price.get(entry.getKey())).map(map -> map.get(vehicleEntry.getKey())).orElse(null);
                result.add(getPojo(entry.getKey(), vehicleEntry.getKey(), vehicleEntry.getValue(), price));
            }
        }
        return result;
    }

    private QueryResultDto getPojo(Slot slot, Vehicle vehicle, Integer count, Integer price) {
        QueryResultDto dto = new QueryResultDto();
        dto.setSlot(slot);
        dto.setVehicle(vehicle);
        dto.setCount(count);
        dto.setPrice(price);
        return dto;
    }
}
