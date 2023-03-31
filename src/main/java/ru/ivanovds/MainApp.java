package ru.ivanovds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {

    private String inputCmd(Scanner scanner) {
        if (scanner == null)
            scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextLine()) {
                String cmd = scanner.nextLine().replaceAll("\\s+", "");
                if (isValid(cmd)) {
                    return cmd;
                } else {
                    return "Неправилно введена команда, повторите еще раз";
                }
            } else {
               scanner.next();
            }
        }
    }

    private boolean isValid(String cmd) {
        if (cmd == null)
            return false;

        Set<String> rl = Stream
                .of("&", "||")
                .collect(Collectors.toSet());

        String[] expressions = cmd.split("(?<=[\\|{2}])|(?=[\\|{3}])\\b");
        System.out.println(Arrays.toString(expressions));
        isValidRel(expressions);
        return true;
    }

    private boolean isValidRel(String[] expressions) {
        for (String expr :
                expressions) {
        }

        return true;
    }

    public static void inputDB() {
        try (BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/airports.csv"))) {
            while (csvReader.readLine() != null) {
                System.out.println(csvReader.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MainApp mainApp = new MainApp();

        while (true) {
            System.out.println("Введите фильтр");
            String cmd = mainApp.inputCmd(scan);
            System.out.println("Введите имя аэропорта");

            if (cmd.equals("!quit")) {
                break;
            }
        }

    }
}