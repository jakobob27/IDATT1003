package Oving2;

public class Oppgave2 {
    public Oppgave2() {
    }

    public String billigst(double prisA, double vektA, double prisB, double vektB) {
        if (prisA / vektA > prisB / vektB) {
            return "B er billigere";
        }

        else if (prisA / vektA < prisB / vektB) {
            return "A er billigere";
        }

        else {
            return "De er samme pris";
        }
    }

    public static void main(String[] args) {
        Oppgave2 test = new Oppgave2();
        System.out.println(test.billigst(35.90, 450, 39.50, 500));
    }

}
