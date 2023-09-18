package Oving10;

import java.util.ArrayList;
import java.util.List;

public class MenyRegister {
    private final List<Rett> retter;
    private final List<Meny> menyer;

    public MenyRegister(){
        retter=new ArrayList<>();
        menyer=new ArrayList<>();
    }

    public void addRett(Rett rett) {
        retter.add(rett);
    }

    public Rett finnRett(String navn) {
        for (Rett i : retter) {
            if (i.getNavn().equals(navn)) {
                return i;
            }
        }
        return null;
    }

    public List<Rett> finnType(String type) {
        List<Rett> temp = new ArrayList<>();
        for (Rett i : retter) {
            if (i.getType().equals(type)) {
                temp.add(i);
            }
        }
        return temp;
    }

    public void nyMeny (Meny meny) {
        menyer.add(meny);
    }

    public List<Meny> menyPrisIntervall (int fra, int til) {
        List<Meny> temp = new ArrayList<>();
        for (Meny i : menyer) {
            if (i.totalPris()>=fra && i.totalPris()<=til) {
                temp.add(i);
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        return "Retter: " + retter.toString() + "\n" + "Menyer: " + menyer.toString();
    }

    public static void main(String[] args) {
        Rett test1 = new Rett("Egg", "Forrett", 20, "Stek Egg!");
        Rett test2 = new Rett("Tunfisk", "Tortur", 12, "Åpne boksen");
        Rett test3 = new Rett("Kylling", "Nam", 200, "Spis rå");

        Meny mtest1 = new Meny();
        Meny mtest2 = new Meny();

        mtest1.nyRett(test1);
        mtest1.nyRett(test3);

        mtest2.nyRett(test1);
        mtest2.nyRett(test2);

        MenyRegister test = new MenyRegister();
        test.nyMeny(mtest1);
        test.nyMeny(mtest2);
        test.addRett(test1);
        test.addRett(test2);
        test.addRett(test3);

        System.out.println(test);

        System.out.println(test.finnType("Frokost"));
        System.out.println(test.menyPrisIntervall(0, 100));
        System.out.println(test.finnRett("Egg"));
    }
}
