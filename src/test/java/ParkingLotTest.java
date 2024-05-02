import org.example.Car;
import org.example.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private Car car;

    @BeforeEach
    void setUp(){
        parkingLot = new ParkingLot(10);
        car = new Car("ABC123");
    }

    @Test
    void shouldBeAbleToParkCarInEmptyLot(){
        assertTrue(parkingLot.park(car));
    }

    @Test
    void shouldNotBeAbleToParkCarInEmptyLot(){
        for (int i = 0; i<10; i++){
            parkingLot.park(new Car("Car" + i));
        }

        assertFalse(parkingLot.park(car));
    }

    @Test
    void shouldReturnTrueIfACarIsParked(){
        assertTrue(parkingLot.park(car));
    }

    @Test
    void shouldReturnFalseIfACarIsReParked(){
        parkingLot.park(car);
        assertFalse(parkingLot.park(car));
    }
}
