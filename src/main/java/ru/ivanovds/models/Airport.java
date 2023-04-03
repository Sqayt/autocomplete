package ru.ivanovds.models;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class Airport {

    @CsvBindByPosition(position = 0)
    private Long id;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String city;

    @CsvBindByPosition(position = 3)
    private String fromCity;

    @CsvBindByPosition(position = 4)
    private String key;

    @CsvBindByPosition(position = 5)
    private String keyFrom;

    @CsvBindByPosition(position = 6)
    private double coordinateX;

    @CsvBindByPosition(position = 7)
    private double CoordinatesY;

    @CsvBindByPosition(position = 8)
    private String value;

    @CsvBindByPosition(position = 9)
    private String valueTwo;

    @CsvBindByPosition(position = 10)
    private String flag;

    @CsvBindByPosition(position = 11)
    private String route;

    @CsvBindByPosition(position = 12)
    private String type;

    @CsvBindByPosition(position = 13)
    private String help;
}
