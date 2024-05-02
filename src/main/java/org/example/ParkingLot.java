package org.example;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Car> slots;
    private int availableSlots;

    public ParkingLot(int capacity) {

        slots = new ArrayList<>();
        this.availableSlots=capacity;
    }

    public boolean park(Car car) {

        //check if the car is already parked
        if(isCarParked(car)){
            return false;
        }

        if(slots.size()<availableSlots){
            slots.add(car);
            availableSlots--;
            return true;
        }
        return false;
    }

    public boolean isCarParked(Car car) {
        return slots.contains(car);
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "slots=" + slots +
                ", availableSlots=" + availableSlots +
                '}';
    }
}
