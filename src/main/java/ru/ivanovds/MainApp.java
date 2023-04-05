package ru.ivanovds;

import ru.ivanovds.models.Airport;
import ru.ivanovds.utils.Filter;
import ru.ivanovds.repositories.AirportRepository;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    /*
        (column[1]> 10 & (column[2] = 3 || column[10]=30)) || ( column[3] = 'BCA' || column[4]<>'ACB')
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AirportRepository repository = new AirportRepository();
        Filter filter = new Filter();

        while (true) {
            String cmd = filter.inputFilter();

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