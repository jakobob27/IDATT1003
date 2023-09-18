package Oving10;

public class Arrangement implements Comparable<Arrangement>{
    private final long tidspunkt;
    private final String navn;
    private final String sted;
    private final String arrangor;
    private final String type;

    public Arrangement(String navn, String sted, String arrangor, String type, long tidspunkt) {
        this.tidspunkt=tidspunkt;
        this.navn=navn;
        this.sted=sted;
        this.arrangor=arrangor;
        this.type=type;
    }

    public String getNavn() {
        return navn;
    }

    public String getArrangor() {
        return arrangor;
    }

    public long getTidspunkt() {
        return tidspunkt;
    }

    public String getSted() {
        return sted;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return navn + " på " + sted;
    }

    @Override
    public int compareTo(Arrangement o) {
        return (int) (this.tidspunkt-o.getTidspunkt());
    }
}
