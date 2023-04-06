package ru.ivanovds.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ivanovds.models.Airport;

import java.util.ArrayList;
import java.util.List;

class AirportRepositoryTest {

    private AirportRepository repository;

    @BeforeEach
    public void init() {
        repository = new AirportRepository();
    }

    @Test
    void findAllAirport() {
        List<Airport> airports = repository.getAll();
        Assertions.assertEquals(airports.size(), 7184);
    }

    @Test
    void findAirport() {
        List<String[]> cmds = new ArrayList<>();
        cmds.add(new String[]{"[1]", ">", "1"});
        List<Airport> airports = repository.findAirport("Bo", cmds);
        Assertions.assertEquals(airports.size(), 68);
    }
}