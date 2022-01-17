package builders;

import entity.Airplane;

public class AirplanePassengerBuilder1 implements AirplaneBuilder {
    @Override
    public Airplane createAirplane() {
        return new Airplane("Boeing", "787", 5000, 500, 250, 10000);
    }
}
