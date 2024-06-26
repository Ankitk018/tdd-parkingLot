
import org.example.Parkable;
import org.example.ParkingException;
import org.example.ParkingLot;
import org.example.ParkingLotListeners;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;
    @Mock
    private ParkingLotListeners parkingLotOwner;
    @Mock
    private ParkingLotListeners trafficCop;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        parkingLot = new ParkingLot(2);

    }

    @Test
    void shouldBeAbleToParkCarInEmptyLot() throws ParkingException {
        Parkable parkableObject = new Parkable() {
            @Override
            public String toString() {
                return "Car 1";
            }
        };

        parkingLot.parkObject(parkableObject);
        assertTrue(parkingLot.isObjectParked(parkableObject));

    }

//    @Test
//    void shouldNotBeAbleToParkCarInEmptyLot(){
//        for (int i = 0; i<5; i++){
//            parkingLot.park(new Car("Car" + i));
//        }
//
//        assertFalse(parkingLot.park(car));
//    }

    @Test
    void shouldReturnTrueIfACarIsParked() throws ParkingException {
//        assertTrue(parkingLot.park(car));
        Parkable parkableObject = new Parkable() {
            @Override
            public String toString() {
                return "Car 1";
            }
        };

        parkingLot.parkObject(parkableObject);

        assertTrue(parkingLot.isObjectParked(parkableObject));
    }

    @Test
    void shouldReturnFalseIfACarIsReParked(){
//        parkingLot.park(car);
//        assertFalse(parkingLot.park(car));

    }

    @Test
    void shouldUnparkTheParkedObject() throws ParkingException {
        Parkable parkedObject = new Parkable() {
            @Override
            public String toString() {
                return "Car 1";
            }
        };

        parkingLot.parkObject(parkedObject);

        parkingLot.unparkObject(parkedObject);

        assertFalse(parkingLot.isObjectParked(parkedObject));
    }

    @Test
    void shouldThrowExceptionIfTheObjectIsNotParked() {
        Parkable parkedObject = new Parkable() {};

     assertThrows(ParkingException.class, ()-> parkingLot.unparkObject(parkedObject));
    }

    @Test
    public void shouldNotifyOwnerAndTrafficCopWhenParkingLotIsFull() throws ParkingException {
        parkingLot.addListeners(parkingLotOwner);
        parkingLot.addListeners(trafficCop);
        Parkable parkedCar1 = new Parkable() {};
        Parkable parkedCar2 = new Parkable() {};

        parkingLot.parkObject(parkedCar1);
        parkingLot.parkObject(parkedCar2);

        verify(parkingLotOwner).notifyEntitiesOnParkingLotFull("Parking lot is full");
        verify(trafficCop).notifyEntitiesOnParkingLotFull("Parking lot is full");
    }

    @Test
    public void shouldNotifyOwnerAndTrafficCopWhenACarisUnparkedFromParkingLot() throws ParkingException {
        parkingLot.addListeners(parkingLotOwner);
        parkingLot.addListeners(trafficCop);
        Parkable parkedCar1 = new Parkable() {};
        Parkable parkedCar2 = new Parkable() {};

        parkingLot.parkObject(parkedCar1);
        parkingLot.parkObject(parkedCar2);

        parkingLot.unparkObject(parkedCar1);

        verify(parkingLotOwner).notifyEntitiesWhenAParkingLotIsAvailable("A parking lot is available now");
        verify(trafficCop).notifyEntitiesWhenAParkingLotIsAvailable("A parking lot is available now");
    }
}
