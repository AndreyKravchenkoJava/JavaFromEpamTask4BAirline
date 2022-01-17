package main;

import builders.AirlineBuilder;
import entity.Airplane;
import entity.Airline;

public class MainClass {
    public static void main(String[] args) {
        Airline airline = AirlineBuilder.createAirline();
        airline.sortByFlightRange();
        System.out.println("Airline FlyUa:");
        for (Airplane airplane : airline) {
            System.out.println(airplane);
        }

        System.out.println("--------------------------------------------------------------------------------------------");

        for (Airplane airplane : airline.getAirplaneWithFuelConsumptionAmountRange(600, 700)) {
            System.out.println(airplane + " Fuel amount: " + airplane.getFuelConsumption());
        }

        System.out.println("Passengers capacity: " + airline.getPassengerCapacity());
        System.out.println("Lifting capacity: " + airline.getLiftingCapacity());
    }
}
