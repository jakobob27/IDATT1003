package Oving8;

public class Person {
    private final String fornavn;
    private final String etternavn;

    private final int fodselsar;

    public Person(String navn, String etternavn, int fodselsar) {
        this.fornavn=navn;
        this.etternavn=etternavn;
        this.fodselsar=fodselsar;
    }

    public int getFodselsar() {
        return fodselsar;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

}
