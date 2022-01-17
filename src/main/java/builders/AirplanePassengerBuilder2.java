package builders;

import entity.Airplane;

public class AirplanePassengerBuilder2 implements AirplaneBuilder {
    @Override
    public Airplane createAirplane() {
        return new Airplane("Boeing", "777", 6000, 600, 300, 12000);
    }
}
