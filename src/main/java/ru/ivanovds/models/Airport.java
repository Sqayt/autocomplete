package ru.ivanovds.models;

import java.util.Objects;

public class Airport {
    public Long id;
    public String name;
    public String city;
    public String fromCity;
    public String key;
    public String keyFrom;
    public double coordinateX;
    public double CoordinatesY;
    public int value;
    public String valueTwo;
    public String flag;
    public String route;
    public String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyFrom() {
        return keyFrom;
    }

    public void setKeyFrom(String keyFrom) {
        this.keyFrom = keyFrom;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinatesY() {
        return CoordinatesY;
    }

    public void setCoordinatesY(double coordinatesY) {
        CoordinatesY = coordinatesY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getValueTwo() {
        return valueTwo;
    }

    public void setValueTwo(String valueTwo) {
        this.valueTwo = valueTwo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Double.compare(airport.coordinateX, coordinateX) == 0 && Double.compare(airport.CoordinatesY, CoordinatesY) == 0 && value == airport.value && Objects.equals(id, airport.id) && Objects.equals(name, airport.name) && Objects.equals(city, airport.city) && Objects.equals(fromCity, airport.fromCity) && Objects.equals(key, airport.key) && Objects.equals(keyFrom, airport.keyFrom) && Objects.equals(valueTwo, airport.valueTwo) && Objects.equals(flag, airport.flag) && Objects.equals(route, airport.route) && Objects.equals(type, airport.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, fromCity, key, keyFrom, coordinateX, CoordinatesY, value, valueTwo, flag, route, type);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", key='" + key + '\'' +
                ", keyFrom='" + keyFrom + '\'' +
                ", coordinateX=" + coordinateX +
                ", CoordinatesY=" + CoordinatesY +
                ", value=" + value +
                ", valueTwo='" + valueTwo + '\'' +
                ", flag='" + flag + '\'' +
                ", route='" + route + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
