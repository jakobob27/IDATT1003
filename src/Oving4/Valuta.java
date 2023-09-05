package Oving4;

public class Valuta {
private String navn;
private double kurs;
    public Valuta(String navn, double kurs){
        this.navn=navn;
        this.kurs=kurs;
    }

    public double getKurs() {
        return kurs;
    }

    public String getNavn(){
        return navn;
    }

    public double tilNOK(double mengde) {
        return mengde*kurs;
    }

    public double fraNOK(double NOK) {
        return NOK/kurs;
    }
}
