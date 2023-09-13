package Oving9;

public class Student {
    private final String navn;
    private int antOpg=0;

    public Student(String navn) {
        this.navn=navn;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOpg() {
        return antOpg;
    }

    public void okAntOpg(int okning) {
        antOpg += okning;
    }

    @Override
    public String toString() {
        return navn +" har gjort " + antOpg + " oppgave(r)";
    }

    public static void main(String[] args) {
        Student test = new Student("Jakob");
        System.out.println(test);
        test.okAntOpg(2);
        System.out.println(test);
    }
}
