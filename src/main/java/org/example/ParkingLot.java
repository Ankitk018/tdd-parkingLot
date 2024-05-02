package org.example;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Parkable> parkableObjects;
    private int capacity;

    public ParkingLot(int capacity) {

        parkableObjects = new ArrayList<>();
        this.capacity=capacity;
    }

    public void parkObject(Parkable parkableObject) throws ParkingException {

//        if(isCarParked(car)){
//            return false;
//        }
//
//        if(slots.size()<availableSlots){
//            slots.add(car);
//            availableSlots--;
//            return true;
//        }
//        return false;

        if(parkableObjects.size() >= capacity){
            throw new ParkingException("The parking lot is full");
        }

        if(parkableObjects.contains(parkableObject)){
            throw  new ParkingException("Car are already parked");
        }

        parkableObjects.add(parkableObject);

    }

    public boolean isObjectParked(Parkable parkableObject) throws ParkingException{
        return parkableObjects.contains(parkableObject);
    }


    public void unparkObject(Parkable parkableObject) throws ParkingException{

        if (!parkableObjects.contains(parkableObject)) {
            throw new ParkingException("Car is not parked in the parking lot");
        }
        parkableObjects.remove(parkableObject);
    }
    @Override
    public String toString() {
        return "ParkingLot{" +
                "slots=" + parkableObjects +
                ", availableSlots=" + capacity +
                '}';
    }
}
