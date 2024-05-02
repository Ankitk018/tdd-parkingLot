package org.example;

public class ParkingLot {

    private final int capacity;
    private int availableSlots;

    public ParkingLot(int capacity) {
        this.capacity=capacity;
        this.availableSlots=capacity;
    }

    public boolean parkCar(Car car) {
        if(availableSlots>0){
            availableSlots--;
            return true;
        }

        return false;
    }
}
