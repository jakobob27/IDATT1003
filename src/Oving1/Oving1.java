package Oving1;

public class Oving1 {

    public Oving1() {
    }

    public double tommerTilCm(double tommer) {
        return tommer * 2.54;
    }

    public int sekunder(int timer, int minutter, int sekunder) {
        return timer * 3600 + minutter * 60 + sekunder;
    }

    public String sekunderTilTimer(int sekunder) {
        return "Timer: " + sekunder / 3600 + " Minutter: " + (sekunder % 3600) / 60 + " Sekunder: "
                + (sekunder % 3600) % 60;
    }

    public static void main(String[] args) {
        Oving1 test = new Oving1();
        System.out.println(test.tommerTilCm(6));
        System.out.println(test.sekunder(1, 30, 5));
        System.out.println(test.sekunderTilTimer(61));
    }

}
