package entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Airline implements Iterable<Airplane> {
    private List<Airplane> list;

    public Airline(List<Airplane> list) {
        this.list = list;
    }

    public List<Airplane> getAirplaneWithFuelConsumptionAmountRange(int from, int to) {
        List<Airplane> fuelConsumptionList = new ArrayList<>();
        for (Airplane airplane : list) {
            if (airplane.getFuelConsumption() >= from && airplane.getFuelConsumption() <= to) {
                fuelConsumptionList.add(airplane);
            }
        }
        return fuelConsumptionList;
    }

    public void sortByFlightRange() {
        Collections.sort(list, new Comparator<Airplane>() {
            @Override
            public int compare(Airplane o1, Airplane o2) {
                return o1.getFlightRange() - o2.getFlightRange();
            }
        });
    }

    public int getPassengerCapacity() {
        int passengerCapacity = 0;
        for (Airplane airplane : list) {
            passengerCapacity += airplane.getPassengerCapacity();
        }
        return passengerCapacity;
    }

    public int getLiftingCapacity() {
        int liftingCapacity = 0;
        for (Airplane airplane : list) {
            liftingCapacity += airplane.getLiftingCapacity();
        }
        return liftingCapacity;
    }

    @Override
    public Iterator<Airplane> iterator() {
        return list.iterator();
    }
}
