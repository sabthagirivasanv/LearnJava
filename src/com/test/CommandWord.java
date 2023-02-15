package com.test;

public enum CommandWord {

    GO("go"), LOOK("look"), TAKE("take"),
    HELP("help"), QUIT("quit");
    private final String abc;

    CommandWord(String commandString)
    {
        this.abc = commandString;
    }

    public String toString ()
    {
        String commandString1 = GO.abc;
        return abc;
    }
}
