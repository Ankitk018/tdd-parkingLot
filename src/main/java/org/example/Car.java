//package org.example;
//
//import java.util.Objects;
//
//public class Car {
//
//    private final String licensePlate;
//
//    public Car(String licensePlate) {
//        this.licensePlate=licensePlate;
//    }
//
//    public String getLicensePlate(){
//        return this.licensePlate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Car car)) return false;
//        return Objects.equals(getLicensePlate(), car.getLicensePlate());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getLicensePlate());
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "licensePlate='" + licensePlate + '\'' +
//                '}';
//    }
//}
