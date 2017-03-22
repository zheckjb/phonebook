package com.tsi.jb;

import asg.cliche.ShellFactory;

import java.io.IOException;

/**
 * Created by Zheck on 19.03.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ShellFactory
                .createConsoleShell("Command", "This is Phone book", new PhoneBook())
                .commandLoop();
    }
}
