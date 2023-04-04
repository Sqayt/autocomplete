package ru.ivanovds.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

@Data
public class Filter {
    Scanner scanner = new Scanner(System.in);

    private String cmd;
    private List<String> cmds = new ArrayList<>();

    public String inputFilter() {
        System.out.println("Введите фильтр");
        while (true) {
            if (scanner.hasNextLine()) {
                String filter = scanner.nextLine();
                if (filter.equals("!quit")) {
                    return filter;
                }

                filter = filter.replaceAll("\\s+","");
                filter = filter.replaceAll("[()]", "");
                String[] filters = filter.split("(?<=&)|(?=&)|(?=\\|{2})|(?<=\\|{2})\\b");
                if (isValidFilter(filters)) {
                    return filter;
                }
            }
        }
    }

    public boolean isValidFilter(String[] filters) {
        boolean isValid = true;
        for (int i = 0; i < filters.length; i++) {
            if (i % 2 == 0) {
                isValidRelationship(filters[i]);
            } else {
                if (!filters[i].matches("&") || !filters[i].matches("[|]")) {
                    isValid = false;
                }
            }
        }
        if (filters[filters.length - 1].matches("&") || filters[filters.length - 1].matches("[|]")) {
            isValid = false;
        }

        return isValid;
    }

    public boolean isValidRelationship(String filter) {
        String[] filters = filter.split("(?=[<>=])|(?<=[<>=])");

        if (!filters[0].matches("column\\[\\d+]")) {
            return false;
        }
        if (filters[1].matches("<")) {
            if (filters[2].matches(">")) {
                return true;
            }
        }

        return filters[1].matches("=|<>|<|>");
    }
}
