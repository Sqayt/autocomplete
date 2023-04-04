package ru.ivanovds.repositories.interfaces;

import ru.ivanovds.models.Airport;

import java.util.List;

public interface AirportInterface {

    List<Airport> getAll();

    List<Airport> findAirport(String nameCity);
}
