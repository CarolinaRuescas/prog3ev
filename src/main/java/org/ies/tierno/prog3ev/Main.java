package org.ies.tierno.prog3ev;

import org.ies.tierno.prog3ev.ej9.HighschoolApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HighschoolApp app = new HighschoolApp(scanner);

        app.run();
    }
}