package ru.ivanovds;

import ru.ivanovds.models.Airport;
import ru.ivanovds.models.Filter;
import ru.ivanovds.repositories.AirportRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private String inputCmd(Scanner scanner) {
        if (scanner == null)
            scanner = new Scanner(System.in);

        System.out.println("Введите фильтр");
        while (true) {
            if (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                if (word.equals("!quit")) {
                    return word;
                }

                String cmd = word.replaceAll("\\s+", "");
                if (isValid(cmd)) {
                    return cmd;
                } else {
                    System.out.println("Неправильно введена команда, повторите еще раз");
                }
            } else {
               scanner.next();
            }
        }
    }

    private boolean isValid(String cmd) {
        if (cmd == null)
            return false;

        String[] expressions = cmd.split("(?<=&)|(?=&)|(?=\\|{2})|(?<=\\|{2})\\b");

        return isValid(expressions);
    }

    private boolean isValid(String[] expressions) {
        for (int i = 0; i < expressions.length; ) {
            String[] expression = expressions[i].split("(?=[<>=])|(?<=[<>=])");
            return isValidRel(expression);
        }
        return true;
    }

    private boolean isValidRel(String[] expressions) {
        for (int i = 0; i < expressions.length; i++) {
            String word = expressions[i];
            if (i % 2 == 0) {
                boolean cmd = expressions[i].matches("column\\[\\d\\]");

                if (word.matches("column\\[\\d+\\]")) {
                    return true;
                }

                if (word.charAt(0) == '(') {
                    return true;
                }

                if (word.charAt(word.length() - 1) == ')') {
                    return true;
                }
            } else {
                if (word.matches("&")) {
                    return true;
                } else return word.matches("//|");
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AirportRepository repository = new AirportRepository();
        MainApp mainApp = new MainApp();
        Filter filter = new Filter();

        while (true) {
            System.out.println(filter.inputFilter());

            System.out.println("Введите начало имени аэропорта");
            String nameAirport = scan.nextLine();
            if (nameAirport.equals("!quit")) {
                break;
            }

            long start = System.currentTimeMillis();
            List<Airport> airports = repository.findAirport(nameAirport);
            long finish = System.currentTimeMillis();
            airports.forEach(System.out::println);
            System.out.println("Количество найденых строк: " + airports.size() +
                    " Время, затраченное на поиск: " + (finish - start) + " мс");
        }
    }
}