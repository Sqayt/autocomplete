package ru.ivanovds.models;

import java.util.ArrayList;
import java.util.List;

public class CmdSingleton {
    private final List<String[]> commands = new ArrayList<>();

    public static CmdSingleton cmd;

    private CmdSingleton () {}

    public static CmdSingleton getInstance() {
        if (cmd == null) {
            cmd = new CmdSingleton();
        }

        return cmd;
    }

    public void setCommands(String filter) {
        String[] filters = filter.split("(?<=&)|(?=&)|(?=\\|{2})|(?<=\\|{2})\\b");
        setCommands(filters);
    }

    private void setCommands(String[] filters) {
        for (String filter: filters) {
            String[] cmds = filter.split("(?=[<>=])|(?<=[<>=])");
            cmds[0] = cmds[0].replaceAll("column", "");
            commands.add(cmds);
        }
    }

    public List<String[]> getCommands() {
        return commands;
    }

    public void clearFilterDB() {
        commands.clear();
    }
}
