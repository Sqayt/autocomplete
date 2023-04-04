package ru.ivanovds.repositories;

import com.opencsv.bean.CsvToBeanBuilder;
import org.yaml.snakeyaml.Yaml;
import ru.ivanovds.models.Airport;
import ru.ivanovds.models.Filter;
import ru.ivanovds.repositories.interfaces.AirportInterface;

import java.io.*;
import java.util.*;

public class AirportRepository implements AirportInterface {

    private String URL_DB;
    private List<Airport> airports;

    public AirportRepository() {
        try (InputStream inputStream = new FileInputStream("src/main/resources/application.yaml")) {
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);

            URL_DB = data.get("pathToFile").toString();
            init();
        } catch (IOException e) {
            URL_DB = "src/main/resources/airports.csv";
            System.err.println(e.getMessage());
        }

    }

    private void init() throws IOException {
        airports = new CsvToBeanBuilder(new FileReader(URL_DB))
                .withType(Airport.class)
                .build()
                .parse();
        airports.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    public List<Airport> findAirport(String nameAirport, Filter... filters) {

        return new ArrayList<>();
    }

    @Override
    public List<Airport> findAirport(String nameAirport) {
        List<Airport> airportsResult = new ArrayList<>();

        for (Airport airport : airports) {
            if (airport.getName().matches(nameAirport + ".+")) {
                airportsResult.add(airport);
            }
        }

        return airportsResult;
    }

    @Override
    public List<Airport> getAll() {
        return airports;
    }
}
