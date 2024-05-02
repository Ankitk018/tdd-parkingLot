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
        assertTrue(parkingLot.parkCar(car));
    }

    @Test
    void shouldNotBeAbleToParkCarInEmptyLot(){
        for (int i = 0; i<10; i++){
            parkingLot.parkCar(new Car("Car" + i));
        }

        assertFalse(parkingLot.parkCar(car));
    }
}
