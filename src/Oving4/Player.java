package Oving4;

import java.util.Random;

public class Player {

    private int sumPoeng;

    private final String navn;

    private final Random terning = new Random();

    public Player(String navn){
        this.navn=navn;
    }

    public String getNavn() {
        return navn;
    }

    public int getSumPoeng() {
        return sumPoeng;
    }

    public void kastTerningen() {
        int kast = terning.nextInt(6) +1;
        System.out.println(navn + " kastet " + kast);
        if (kast==1) {
            sumPoeng=0;
            return;
        }
        sumPoeng+=kast;
    }

}
