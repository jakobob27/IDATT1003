package Oving10;

import java.util.ArrayList;
import java.util.List;

public class Meny {
    private final List<Rett> meny;

    public Meny() {
        meny=new ArrayList<>();
    }

    public Meny(List<Rett> meny) {
        this.meny=meny;
    }

    public List<Rett> getMeny() {
        return meny;
    }

    public void nyRett(Rett rett) {
        meny.add(rett);
    }

    public int totalPris(){
        int sum=0;
        for (Rett i : meny) {
            sum+=i.getPris();
        }

        return sum;
    }

    @Override
    public String toString() {
        return meny.toString();
    }
}
