package ru.ivanovds;

import ru.ivanovds.models.Airport;
import ru.ivanovds.models.CmdSingleton;
import ru.ivanovds.repositories.AirportRepository;
import ru.ivanovds.utils.FilterValidation;

import java.util.List;
import java.util.Scanner;

public class App {
    public void startApp() {
        Scanner scan = new Scanner(System.in);
        AirportRepository repository = new AirportRepository();
        FilterValidation filters = new FilterValidation();
        CmdSingleton cmd = CmdSingleton.getInstance();

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
