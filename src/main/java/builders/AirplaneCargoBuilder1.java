package builders;

import entity.Airplane;

public class AirplaneCargoBuilder1 implements AirplaneBuilder {
    @Override
    public Airplane createAirplane() {
        return new Airplane("AH", "АH-225", 10000, 1000, 20, 100000);
    }
}
