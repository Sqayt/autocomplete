package ru.ivanovds.repositories.interfaces;

import ru.ivanovds.models.Airport;

import java.util.List;

public interface AirportInterface {

    List<String[]> getAll();

    Airport findAirport(String nameCity);
}
