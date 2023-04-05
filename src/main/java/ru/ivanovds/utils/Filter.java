package ru.ivanovds.utils;

import java.util.Scanner;

public class Filter {
    Scanner scanner = new Scanner(System.in);

    public String inputFilter() {
        System.out.println("Введите фильтр");
        while (true) {
            if (scanner.hasNextLine()) {
                String filterMain = scanner.nextLine();
                if (filterMain.equals("!quit")) {
                    return filterMain;
                }

                String filter = filterMain.replaceAll("\\s+","");
                String filterValid = filter.replaceAll("[()]", "");
                String[] filters = filterValid.split("(?<=&)|(?=&)|(?=\\|{2})|(?<=\\|{2})\\b");

                if (isValidFilter(filters)) {
                    return filter;
                }

                System.out.println("Неправильно введен фильтр, попробуйте еще раз");
            }
        }
    }

    private boolean isValidFilter(String[] filters) {
        boolean isValid = true;
        for (int i = 0; i < filters.length; i++) {
            if (i % 2 == 0) {
                isValid = isValidRelationship(filters[i]);
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

    private boolean isValidRelationship(String filter) {
        String[] filters = filter.split("(?=[<>=])|(?<=[<>=])");

        try {
            if (!filters[0].matches("column\\[\\d+]")) {
                return false;
            }
            if (filters[1].matches("<")) {
                if (filters[2].matches(">")) {
                    return true;
                }
            }

            return filters[1].matches("=|<>|<|>") && !filters[2].matches("=|<>|<|>");
        } catch (IndexOutOfBoundsException e) {

            return false;
        }
    }
}
