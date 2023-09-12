package Oving8;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ArbTaker {

    private final Person personalia;

    private final int arbtakernr;

    private final int ansettelsesar;

    private double manedslonn;

    private double skatteprosent;

    public ArbTaker(Person person, int arbtakenr, int ar) {
        this.personalia=person;
        this.arbtakernr=arbtakenr;
        this.ansettelsesar=ar;
    }

    public double getManedslonn() {
        return manedslonn;
    }

    public double getSkatteprosent() {
        return skatteprosent;
    }

    public int getAnsettelsesar() {
        return ansettelsesar;
    }

    public Person getPersonalia() {
        return personalia;
    }

    public int getArbtakernr() {
        return arbtakernr;
    }

    public void setManedslonn(double manedslonn) {
        this.manedslonn = manedslonn;
    }

    public void setSkatteprosent(double skatteprosent) {
        this.skatteprosent = skatteprosent;
    }

    public double skattprManed() {
        return manedslonn*(skatteprosent/100);
    }

    public double bruttoArsLonn() {
        return manedslonn*12;
    }

    public double skattprAr() {
        return skattprManed()*10.5;
    }

    public String navn() {
        return personalia.getEtternavn()+", " + personalia.getFornavn();
    }

    public int alder() {
        GregorianCalendar kalender = new GregorianCalendar();
        return kalender.get(Calendar.YEAR) - personalia.getFodselsar();
    }

    public int arIBedrift() {
        GregorianCalendar kalender = new GregorianCalendar();
        return kalender.get(Calendar.YEAR) - ansettelsesar;
    }

    public boolean antallarIBedrift (int ar) {
        return ar<arIBedrift();
    }

    public static void main(String[] args) {
        Person testPerson = new Person("Jakob", "Huuse", 2003);
        ArbTaker test = new ArbTaker(testPerson, 2703, 2020);
        test.setManedslonn(1000000);
        test.setSkatteprosent(0.2);

        System.out.println(test.skattprManed());
        System.out.println(test.bruttoArsLonn());
        System.out.println(test.skattprAr());
        System.out.println(test.navn());
        System.out.println(test.alder());
        System.out.println(test.arIBedrift());
        System.out.println(test.antallarIBedrift(5));

    }
}
