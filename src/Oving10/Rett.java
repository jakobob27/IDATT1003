package Oving10;

public class Rett {

    private final String navn;

    private final String type;

    private final String oppskrift;

    private int pris;

    public Rett(String navn, String type, int pris, String oppskrift) {
        this.navn=navn;
        this.type=type;
        this.pris=pris;
        this.oppskrift=oppskrift;
    }

    public String getType() {
        return type;
    }

    public String getNavn() {
        return navn;
    }

    public int getPris() {
        return pris;
    }

    public String getOppskrift() {
        return oppskrift;
    }

    @Override
    public String toString() {
        return type + ": " + navn + " for " + pris +"kr";
    }
}
