package builders;

import entity.Airplane;

public class Director {
    private AirplaneBuilder builder;

    public void setBuilder(AirplaneBuilder builder) {
        this.builder = builder;
    }

    public Airplane createAirplane() {
        return builder.createAirplane();
    }
}
