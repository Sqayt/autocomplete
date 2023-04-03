package ru.ivanovds.models;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private String cmd;
    private List<String> cmds = new ArrayList<>();

    public Filter(String filter) {
        setCmd(filter);
    }

    public void addCmd() {

    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public void findSymb(String cmd) {
        String filter = cmd.replaceAll("\\s+", "");
        String[] filters = filter.split("");

        // Псевдо стек
        int res = 0;
        for (String s : filters) {
            if (s.equals("(")) {
                res++;
            } else if (s.equals(")")) {
                res--;
            }

            if (res > 0) {
                cmds.add(s);
            }

            if (res < 0) {
                break;
            }
        }
    }
}
