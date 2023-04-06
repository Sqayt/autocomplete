package ru.ivanovds.repositories;

import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import ru.ivanovds.models.Airport;
import ru.ivanovds.repositories.interfaces.AirportInterface;
import ru.ivanovds.service.AirportService;

import java.io.*;
import java.util.*;

public class AirportRepository implements AirportInterface {
    private String URL_DB;
    private List<Airport> airports;

    private static final Logger logger = LoggerFactory.getLogger(AirportRepository.class);

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

    @Override
    public List<Airport> findAirport(String nameAirport, List<String[]> cmds) {
        List<Airport> airportsResult = new ArrayList<>();

        try {
            for (Airport airport: airports) {
                for (String[] cmd: cmds) {
                    if (airport.getName().matches(nameAirport + ".+") && AirportService.parse(cmd, airport)) {
                        airportsResult.add(airport);
                    }
                }
            }

            return airportsResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Airport> getAll() {
        return airports;
    }
}
