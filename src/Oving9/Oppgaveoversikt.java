package Oving9;

import java.util.ArrayList;
import java.util.List;

public class Oppgaveoversikt {
    private final List<Student> studenter;
    private int antStud=0;

    public Oppgaveoversikt(List<Student> list){
        studenter = new ArrayList<>(list);
        antStud = studenter.size();
    }

    public int getAntStud() {
        return antStud;
    }

    public int antOpg (Student stud) {
        return studenter.get(studenter.indexOf(stud)).getAntOpg();
    }

    public void nyStud (Student stud) {
        studenter.add(stud);
        antStud++;
    }

    public void okAntOpg(Student stud, int opg) {
        studenter.get(studenter.indexOf(stud)).okAntOpg(opg);
    }

    @Override
    public String toString() {
        return "Antall studenter: " + antStud + "\n" + studenter.toString();
    }

    public static void main(String[] args) {
        List<Student> testList = new ArrayList<>();
        Student test1 = new Student("Jakob");
        Student test2 = new Student("Kris");
        testList.add(test1);

        Oppgaveoversikt test = new Oppgaveoversikt(testList);
        System.out.println(test);
        test.nyStud(test2);
        test.okAntOpg(test1, 2);
        System.out.println(test);

    }
}
