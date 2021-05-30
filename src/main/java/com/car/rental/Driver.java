package com.car.rental;

public class Driver {

    private Controller controller = new Controller();

    public void test() {
        controller.updateInventory(Slot.MORNING, Vehicle.CAR, 10, 100);
        controller.updateInventory(Slot.MORNING, Vehicle.TRUCK, 10, 90);

        controller.book(Slot.MORNING, Vehicle.CAR, 5, 123);
        controller.book(Slot.MORNING, Vehicle.TRUCK, 5, 123);
        System.out.println(controller.query(new Query().setSlot(Slot.MORNING).setSortByPrice(true)));
    }

    public static void main(String[] args) {
        new Driver().test();
    }
}
