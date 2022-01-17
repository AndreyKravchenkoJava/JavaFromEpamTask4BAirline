package builders;

import java.util.List;

import entity.Airplane;
import entity.Airline;
import utils.FileUtils;

public class AirlineBuilder {
    public static Airline createAirline() {
        FileUtils utils = new FileUtils();
        List<Airplane> list = utils.getAirplaneListFromFile();
        Airline airline = new Airline(list);
        return airline;
    }
}
