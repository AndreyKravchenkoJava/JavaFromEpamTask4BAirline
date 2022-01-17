package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import builders.AirplaneBuilderPool;
import org.apache.log4j.Logger;

import builders.Director;
import builders.AirplaneBuilder;
import entity.Airplane;

public class FileUtils {
    private static final Logger log = Logger.getLogger("FileUtils.class");
    private static final String FILE_FULL_PATH = "./res/Airplane.txt";

    public List<Airplane> getAirplaneListFromFile() {
        List<Airplane> airplaneList = new ArrayList<>();
        File file = new File(FILE_FULL_PATH);

        try {
            List<String> fileRows = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            Map<String , Integer> airplaneSet = parseFileRows(fileRows);
            airplaneList = createCertainObject(airplaneSet);
        } catch (IOException e) {
            log.error(e);
        }
        return airplaneList;
    }

    private Map<String , Integer> parseFileRows(List<String> fileRows) {
        Map<String, Integer> map = new HashMap<>();
        String[] splitedRows;
        for (int i = 0; i < fileRows.size(); i++) {
            splitedRows = fileRows.get(i).trim().split(",");
            if (splitedRows.length == 2) {
                try {
                    int count = Integer.parseInt(splitedRows[1]);
                    map.put(splitedRows[0], count);
                } catch (NumberFormatException e) {
                    log.error(e);
                }
            } else {
                if (!("".equals(splitedRows[0]))) {
                    log.warn("Invalid rows format: " + fileRows.get(i));
                }
            }
        }
        return map;
    }

    private List<Airplane> createCertainObject(Map<String, Integer> airplaneSet) {
        List<Airplane> airplaneList = new ArrayList<>();
        AirplaneBuilderPool abp =new AirplaneBuilderPool();
        Director director = new Director();
        for (Map.Entry<String, Integer> element : airplaneSet.entrySet()) {
            int count= 0;
            for (Class<? extends AirplaneBuilder> clazz : abp) {
                count++;
                if (clazz.getSimpleName().equals(element.getKey())) {
                    try {
                        director.setBuilder(clazz.newInstance());
                        for (int i = 0; i < element.getValue(); i++) {
                            airplaneList.add(director.createAirplane());
                        }
                    } catch (InstantiationException | IllegalAccessException e) {
                        log.error(e);
                    }
                    count--;
                }
            }
            if (count == abp.getPoolSize()) {
                log.warn("Such builder doesent exist: " + element.getKey());
            }
        }
        return airplaneList;
    }
}
