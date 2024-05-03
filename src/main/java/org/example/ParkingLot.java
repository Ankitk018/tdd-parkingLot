package org.example;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Parkable> parkableCars;
    private final List<ParkingLotFullListeners> listeners;
    private final int capacity;

    public ParkingLot(int capacity) {
        parkableCars = new ArrayList<>();
        this.capacity = capacity;
        listeners = new ArrayList<>();
    }

    public void addListeners(ParkingLotFullListeners parkingLotFullListeners){
        listeners.add(parkingLotFullListeners);
    }
    public void parkObject(Parkable parkableCar) throws ParkingException {

        if(parkableCars.size() > capacity){
            throw new ParkingException("The parking lot is full");
        }

        if(parkableCars.contains(parkableCar)){
            throw  new ParkingException("Car are already parked");
        }

        parkableCars.add(parkableCar);

        if(parkableCars.size()==capacity){
            notifyAllResponsibleEntity();
        }
    }

    private void notifyAllResponsibleEntity() {
        for(ParkingLotFullListeners listener: listeners){
            listener.notifyEntitiesOnParkingLotFull();
        }
    }

    public boolean isObjectParked(Parkable parkableObject) {
        return parkableCars.contains(parkableObject);
    }


    public void unparkObject(Parkable parkableCar) throws ParkingException{

        if (!parkableCars.contains(parkableCar)) {
            throw new ParkingException("Car is not parked in the parking lot");
        }
        parkableCars.remove(parkableCar);
    }
    @Override
    public String toString() {
        return "ParkingLot{" +
                "slots=" + parkableCars +
                ", availableSlots=" + capacity +
                '}';
    }
}
