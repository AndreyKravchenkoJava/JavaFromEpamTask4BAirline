package builders;

import entity.Airplane;

public class AirplaneCargoBuilder2 implements AirplaneBuilder {
    @Override
    public Airplane createAirplane() {
        return new Airplane("AH", "Ah-124", 8000, 700, 10, 50000);
    }
}
