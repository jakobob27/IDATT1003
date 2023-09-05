package Oving4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValutaProgram {
    public static void main(String[] args) {
        List<Valuta> val = new ArrayList<>();

        Valuta USDollar = new Valuta("Amerikansk Dollar", 10.65);
        Valuta Euro = new Valuta("Euro", 11.50);
        Valuta DKrone = new Valuta("Dansk Krone",1.54);

        val.add(USDollar);
        val.add(Euro);
        val.add(DKrone);

        System.out.println("Hvilken valuta vil du bruke?");
        for (int i=0; i<val.size(); i++) {
            System.out.println(i+1+". "+ val.get(i).getNavn());
        }
        System.out.println(val.size()+1 +". Avslutt");

        Scanner input = new Scanner(System.in);
        int tall = input.nextInt();
        if (tall > val.size()) {
            return;
        }
        Valuta valgtValuta = val.get(tall-1);
        System.out.println("Vil du konvertere til eller fra " + valgtValuta.getNavn());
        System.out.println("1. Til");
        System.out.println("2. Fra");
        System.out.println("3. Avslutt");

        int valg = input.nextInt();

        System.out.println("Skriv inn mengden du vil konvertere");
        double mengde = input.nextDouble();

        if(valg==1) {
            System.out.println(mengde + " NOK er " + valgtValuta.fraNOK(mengde) + " " + valgtValuta.getNavn());
        }
        else if (valg==2) {
            System.out.println(mengde + " " + valgtValuta.getNavn() + " er " + valgtValuta.tilNOK(mengde) + " NOK");
        }


    }
}
