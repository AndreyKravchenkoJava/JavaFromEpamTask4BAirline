package entity;

import java.util.Objects;

public class Airplane {
    private String manufacturer;
    private String model;
    private int flightRange;
    private int fuelConsumption;
    private int passengerCapacity;
    private int liftingCapacity;

    public Airplane(String manufacturer, String model, int flightRange, int fuelConsumption, int passengerCapacity, int liftingCapacity) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
        this.passengerCapacity = passengerCapacity;
        this.liftingCapacity = liftingCapacity;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public String getModel() {
        return model;
    }
    public int getFlightRange() {
        return flightRange;
    }
    public int getFuelConsumption() {
        return fuelConsumption;
    }
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public int getLiftingCapacity() {
        return liftingCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Airplane airplane = (Airplane) obj;
        if (manufacturer != airplane.manufacturer) return false;
        if (model != airplane.model) return false;
        if (flightRange != airplane.flightRange) return false;
        if (fuelConsumption != airplane.fuelConsumption) return false;
        if (passengerCapacity != airplane.passengerCapacity) return false;
        if (liftingCapacity != airplane.liftingCapacity) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, flightRange, fuelConsumption, passengerCapacity, liftingCapacity);
    }

    @Override
    public String toString() {
        return "Airplane { " + "manufacturer: " + manufacturer + ", model: " + model + ", flightRange: " + flightRange + ", fuelConsumption: " + fuelConsumption +
                ", passengersCapacity: " + passengerCapacity + ", liftingCapacity: " + liftingCapacity + " }";
    }
}
