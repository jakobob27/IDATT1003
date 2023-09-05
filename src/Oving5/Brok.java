package Oving5;

public class Brok {
    private int teller;
    private int nevner;

    public Brok(int teller, int nevner){
        if (nevner==0) {
            throw new IllegalArgumentException();
        }
        this.teller=teller;
        this.nevner=nevner;
    }

    public Brok(int teller) {
        this.teller=teller;
        nevner=1;
    }

    public int getNevner() {
        return nevner;
    }

    public int getTeller() {
        return teller;
    }

    public void forkort() {
        for (int i=teller; i>1; i--) {
            if (nevner%i==0&&teller%i==0) {
                nevner/=i;
                teller/=i;
            }
        }
    }

    public void subtract(Brok brok) {
        int eqTeller = brok.getTeller()*nevner;
        teller=brok.getNevner()*teller-eqTeller;
        nevner*=brok.getNevner();
        forkort();
    }

    public void add (Brok brok) {
        int eqTeller = brok.getTeller()*nevner;
        teller=brok.getNevner()*teller+eqTeller;
        nevner*=brok.getNevner();
        forkort();
    }

    public void multiply(Brok brok) {
        teller*= brok.getTeller();
        nevner*= brok.getNevner();
        forkort();
    }

    public void divide(Brok brok) {
        teller*=brok.getNevner();
        nevner*= brok.getTeller();
        forkort();
    }

    @Override
    public String toString() {
        return teller +"/"+nevner;
    }

    public static void main(String[] args) {
        Brok brok1= new Brok(1, 2);
        Brok brok2 = new Brok(2, 4);

        brok1.add(brok2);
        System.out.println(brok1);
        brok1.subtract(brok2);
        System.out.println(brok1);
        brok1.multiply(brok2);
        System.out.println(brok1);
        brok1.divide(brok2);
        System.out.println(brok1);
    }
}
