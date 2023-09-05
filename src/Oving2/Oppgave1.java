package Oving2;

public class Oppgave1 {
    public Oppgave1() {
    }

    public boolean leapYear(int year) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                return true;
            } else {
                return false;
            }
        }

        else {
            if (year % 4 == 0) {
                return true;
            }

            else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Oppgave1 test = new Oppgave1();
        System.out.println(test.leapYear(2012));
        System.out.println(test.leapYear(2100));
        System.out.println(test.leapYear(2000));
    }
}