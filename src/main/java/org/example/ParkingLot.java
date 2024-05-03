package org.example;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Parkable> parkableCars;
    private final List<ParkingLotListeners> listeners;

    private boolean isFull = false;

    private final int capacity;

    public ParkingLot(int capacity) {
        parkableCars = new ArrayList<>();
        this.capacity = capacity;
        listeners = new ArrayList<>();
    }

    public void addListeners(ParkingLotListeners parkingLotListeners){
        listeners.add(parkingLotListeners);
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
            isFull=true;
            notifyAllResponsibleEntity();
        }
    }

    private void notifyAllResponsibleEntity() {
        for(ParkingLotListeners listener: listeners){
            listener.notifyEntitiesOnParkingLotFull("Parking lot is full");
        }
    }

    private void notifyAllResponsibleEntityWhenLotBecomeAvailable() {
        for(ParkingLotListeners listener: listeners){
            listener.notifyEntitiesWhenAParkingLotIsAvailable("A parking lot is available");
        }
    }

    public boolean isObjectParked(Parkable parkableObject) {
        return parkableCars.contains(parkableObject);
    }

    public void unparkObject(Parkable parkableCar) throws ParkingException{

        if(parkableCars.contains(parkableCar)){
            parkableCars.remove(parkableCar);
            if(isFull && parkableCars.size() < capacity){
                isFull=false;
                    notifyAllResponsibleEntityWhenLotBecomeAvailable();
            }
        } else{
            throw new ParkingException("Car is not parked in the parking lot");
        }
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "slots=" + parkableCars +
                ", availableSlots=" + capacity +
                '}';
    }
}
