package ru.ivanovds;

import ru.ivanovds.models.Airport;
import ru.ivanovds.models.Cmd;
import ru.ivanovds.utils.Filter;
import ru.ivanovds.repositories.AirportRepository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AirportRepository repository = new AirportRepository();
        Filter filters = new Filter();
        Cmd cmd = Cmd.getInstance();

        String a = "abc";
        String b = "bca";
        System.out.println(b.compareTo(a));

        while (true) {
            String filter = filters.inputFilter();
            cmd.setCommands(filter);
            System.out.println("Введите начало имени аэропорта");
            String nameAirport = scan.nextLine();
            if (nameAirport.equals("!quit")) {
                break;
            }


            long start = System.currentTimeMillis();
            List<Airport> airports = repository.findAirport(nameAirport, cmd.getCommands());
            long finish = System.currentTimeMillis();
            cmd.clearFilterDB();
            airports.forEach(System.out::println);
            System.out.println("Количество найденых строк: " + airports.size() +
                    " Время, затраченное на поиск: " + (finish - start) + " мс");
        }
    }
}