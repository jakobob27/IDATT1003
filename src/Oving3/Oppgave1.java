package Oving3;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Oppgave1 {
    private Scanner input;

    public Oppgave1() {
    }

    public void gangeTabell() {
        System.out.println("Hvilken gangetabell vil du ha fra? ");
        input = new Scanner(System.in);
        Integer fra = Integer.valueOf(input.nextLine());
        System.out.println("Hvilken gangetabell vil du ha til? ");
        Integer til = Integer.valueOf(input.nextLine());

        if (fra > til) {
            throw new InvalidParameterException();
        }

        for (int i = fra; i <= til; i++) {
            System.out.println(i + "-Gangen:");
            for (int j = 0; j <= 10; j++) {
                System.out.println(i + " x " + j + " = " + i * j);
            }
        }

    }

    public static void main(String[] args) {
        Oppgave1 test = new Oppgave1();
        test.gangeTabell();
    }
}
