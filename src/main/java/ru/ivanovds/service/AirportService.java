package ru.ivanovds.service;

import ru.ivanovds.models.Airport;

public final class AirportService {

    private AirportService() {
    }

    public static boolean parse(String[] array, Airport airport) {
        if (array == null) {
            return false;
        }

        if (array.length <= 1) {
        //TODO Доделать реализацию (,),&,||
        }
        try {
            switch (array[0]) {
                case "[1]":
                    return convert(airport.getId(), array[1], array[2]);

                case "[2]":
                    return convert(airport.getName(), array[1], array[2]);

                case "[3]":
                    return convert(airport.getCity(), array[1], array[2]);

                case "[4]":
                    return convert(airport.getFromCity(), array[1], array[2]);

                case "[5]":
                    return convert(airport.getKey(), array[1], array[2]);

                case "[6]":
                    return convert(airport.getKeyFrom(), array[1], array[2]);

                case "[7]":
                    return convert(airport.getCoordinateX(), array[1], array[2]);

                case "[8]":
                    return convert(airport.getCoordinatesY(), array[1], array[2]);

                case "[9]":
                    return convert(Long.valueOf(airport.getValue()), array[1], array[2]);

                case "[10]":
                    return convert(airport.getValueTwo(), array[1], array[2]);

                case "[11]":
                    return convert(airport.getFlag(), array[1], array[2]);

                case "[12]":
                    return convert(airport.getRoute(), array[1], array[2]);

                case "[13]":
                    return convert(airport.getType(), array[1], array[2]);

                case "[14]":
                    return convert(airport.getHelp(), array[1], array[2]);

                default:
                    throw new Exception();

            }
        } catch (Exception e) {
            System.out.println("Неправильно введен фильтр");
            return false;
        }
    }

    private static boolean convert(Long el1, String el2, String el3) throws Exception {
        if (el1 == null || el2 == null || el3 == null) {
            throw new Exception();
        }

        if (el2.equals("<")) return el1 < Long.parseLong(el3);
        if (el2.equals(">")) return el1 > Long.parseLong(el3);
        if (el2.equals("=")) return el1 == Long.parseLong(el3);
        if (el2.equals("<>")) return el1 != Long.parseLong(el3);
        else throw new Exception("Неправильно введено сравнение");
    }

    private static boolean convert(Double el1, String el2, String el3) throws Exception {
        if (el1 == null || el2 == null || el3 == null) {
            throw new Exception();
        }

        if (el2.equals("<")) return el1 < Long.parseLong(el3);
        if (el2.equals(">")) return el1 > Long.parseLong(el3);
        if (el2.equals("=")) return el1 == Long.parseLong(el3);
        if (el2.equals("<>")) return el1 != Long.parseLong(el3);
        else throw new Exception("Неправильно введено сравнение");
    }

    private static boolean convert(String el1, String el2, String el3) throws Exception {
        if (el1 == null || el2 == null || el3 == null) {
            throw new Exception();
        }

        if (el2.equals("<")) return el1.compareTo(el3) >= 0;
        if (el2.equals(">")) return el1.compareTo(el3) <= 0;
        if (el2.equals("=")) return el1.compareTo(el3) == 0;
        if (el2.equals("<>")) return el1.compareTo(el3) != 0;
        else throw new Exception("Неправильно введено сравнение");
    }
}
