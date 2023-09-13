package Oving6;

import java.util.*;

public class Tabell {

    Random random = new Random();
    List<Integer> antall = new ArrayList<>(Collections.nCopies(10, 0));

    public Tabell() {

    }

    public void randomIterator(int loops) {
        for (int i=0; i<loops; i++) {
            int tall=random.nextInt(10);
            antall.set(tall, antall.get(tall)+1);
        }
    }

    @Override
    public String toString() {
        return antall.toString();
    }

    public static void main(String[] args) {
        Tabell test = new Tabell();
        test.randomIterator(1000);
        System.out.println(test);
    }

}
