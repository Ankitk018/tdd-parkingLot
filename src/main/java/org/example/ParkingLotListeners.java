package org.example;

public interface ParkingLotListeners {
    void notifyEntitiesOnParkingLotFull(String message);
    void notifyEntitiesWhenAParkingLotIsAvailable(String message);
}
