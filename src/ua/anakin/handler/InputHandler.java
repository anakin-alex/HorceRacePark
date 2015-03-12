package ua.anakin.handler;

import ua.anakin.commands.AbstractCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {

    public String[] getUserInput() {

        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (input.equals("")) {
            try {
                input = reader.readLine().toLowerCase();
            } catch (IOException e) {
                System.out.println("");
            }
        }
        return input.split(" ");
    }

}
