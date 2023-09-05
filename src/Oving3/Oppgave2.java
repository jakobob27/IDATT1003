package Oving3;

import java.util.Scanner;

public class Oppgave2 {

    private Scanner input;

    public Oppgave2() {

    }

    public void sjekkPrimtall() {
        input = new Scanner(System.in);
        System.out.println("Hvilket tall vil du sjekke er primtall? ");
        String inp = input.nextLine();
        if (inp.equals("break")) {
            return;
        }

        Integer tall = Integer.valueOf(inp);

        if (tall < 0) {
            throw new IllegalArgumentException("Kan ikke ha et negativt tall!");
        }

        if (tall == 1 || tall == 2) {
            System.out.println("Det er primtall!");
            sjekkPrimtall();
            return;
        }

        else if (tall == 0) {
            System.out.println("Ikke et primtall!");
            sjekkPrimtall();
            return;
        }

        else {
            for (int i = 2; i < tall; i++) {
                if (tall % i == 0) {
                    System.out.println("Ikke et primtall!");
                    sjekkPrimtall();
                    return;
                }
            }
            System.out.println("Det er et primtall!");
            sjekkPrimtall();
            return;
        }

    }

    public static void main(String[] args) {
        Oppgave2 test = new Oppgave2();
        test.sjekkPrimtall();
    }

}
