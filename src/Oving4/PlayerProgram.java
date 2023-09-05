package Oving4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerProgram {

    static Scanner input = new Scanner(System.in);
    public static String inputReader() {
        return input.nextLine();
    }
    public static void main(String[] args) {
        int runder = 1;
        List<Player> players = new ArrayList<>();

        Player player1 = new Player("Jakob");
        Player player2 = new Player("Kris");

        players.add(player1);
        players.add(player2);

        boolean action;
        while (true) {
            System.out.println("Runde " + runder);
            for (Player p : players) {
                System.out.println("Det er " +p.getNavn()+ " sin tur!");
                action=false;
                while (!action) {
                    String inp = inputReader();
                    if (inp.equalsIgnoreCase("kast")) {
                        p.kastTerningen();
                        action=true;

                    }
                    else if (inp.equalsIgnoreCase("avslutt")) {
                        return;
                    }
                }

                System.out.println("Summen til " + p.getNavn() + " er nå " + p.getSumPoeng());
                if (p.getSumPoeng()>=100) {
                    System.out.println(p.getNavn() + " vant!");
                    return;
                }

            }
            runder++;
        }
    }
}
