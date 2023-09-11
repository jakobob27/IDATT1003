package Oving5;

import java.util.Random;

public class TilfeldigTall {

    public TilfeldigTall(){}

    Random random = new Random();

    public int nesteHeltall(int nedre, int ovre) {
        return random.nextInt(nedre, ovre);
    }

    public double nesteDesimaltall(double nedre, double ovre) {
        return random.nextDouble(nedre, ovre);
    }

    public static void main(String[] args) {
        TilfeldigTall test = new TilfeldigTall();
        System.out.println(test.nesteHeltall(1, 10));
        System.out.println(test.nesteDesimaltall(0.1, 1.5));
    }
}
