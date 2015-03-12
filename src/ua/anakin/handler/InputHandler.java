package ua.anakin.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {

    public String[] getUserInput() {

        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Ignore blank input lines
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
