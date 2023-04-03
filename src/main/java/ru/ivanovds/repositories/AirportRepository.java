package ru.ivanovds.repositories;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.yaml.snakeyaml.Yaml;
import ru.ivanovds.models.Airport;
import ru.ivanovds.repositories.interfaces.AirportInterface;

import java.io.*;
import java.util.*;

public class AirportRepository implements AirportInterface {

    private final String URL_DB;

    public AirportRepository() {
        try (InputStream inputStream = new FileInputStream("src/main/resources/application.yaml")) {
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);
            URL_DB = data.get("pathToFile").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Airport findAirport(String nameAirport) {
        try (CSVReader reader = new CSVReader(new FileReader(URL_DB))) {
            int count = 0;
            List<String[]> r = reader.readAll();

            for (String[] word : r) {
                if (word[1].matches(nameAirport + ".+")) {
                    print(word);
                    count++;
                }
            }

            System.out.println(count);

        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        return new Airport();
    }

    @Override
    public List<String[]> getAll() {
        List<String[]> db;
        try (CSVReader reader = new CSVReader(new FileReader(URL_DB))) {
            db = reader.readAll();

        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        return db;
    }

    private void print(String[] words) {
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}
