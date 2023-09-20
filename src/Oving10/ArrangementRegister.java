package Oving10;

import java.util.*;

public class ArrangementRegister {
    private final List<Arrangement> register;

    private static Scanner inp = new Scanner(System.in);

    public ArrangementRegister() {
        register=new ArrayList<>();
    }

    public ArrangementRegister(List<Arrangement> list) {
        register = new ArrayList<>(list);
    }

    public void nyttArrangement(Arrangement arr) {
        register.add(arr);
    }

    public List<Arrangement> paSted(String sted) {
        List<Arrangement> temp = new ArrayList<>();
        for (Arrangement i : register) {
            if (i.getSted().equals(sted)) {
                temp.add(i);
            }

        }
        return temp;
    }

    public long roundDato(long dato) {
        return (dato/10000*10000)/10000;
    }

    public List<Arrangement> paDato(long dato) {
        List<Arrangement> temp = new ArrayList<>();
        for (Arrangement i : register) {
            if (roundDato(i.getTidspunkt())==dato) {
                temp.add(i);
            }
        }
        return temp;
    }

    public List<Arrangement> intervallTid(long dato1, long dato2) {
        List<Arrangement> temp = new ArrayList<>();
        for (Arrangement i : register) {
            if (roundDato(i.getTidspunkt())>=dato1 && roundDato(i.getTidspunkt())<=dato2) {
                temp.add(i);
            }
        }
        Collections.sort(temp);
        return temp;
    }

    public HashMap<String, HashMap<String, List<Arrangement>>> sortertLister() {

        HashMap<String, HashMap<String, List<Arrangement>>> temp = new HashMap<>();
        temp.put("Steder", new HashMap<String, List<Arrangement>>());
        temp.put("Typer", new HashMap<String, List<Arrangement>>());
        temp.put("Tidspunkter", new HashMap<String, List<Arrangement>>());

        for (Arrangement i : register) {
            if (!temp.get("Steder").containsKey(i.getSted())) {
                List<Arrangement> temp1 = new ArrayList<>();
                temp1.add(i);
                temp.get("Steder").put(i.getSted(), temp1);
            } else {
                temp.get("Steder").get(i.getSted()).add(i);
            }

            if (!temp.get("Typer").containsKey(i.getType())) {
                List<Arrangement> temp1 = new ArrayList<>();
                temp1.add(i);
                temp.get("Typer").put(i.getType(), temp1);
            } else {
                temp.get("Typer").get(i.getType()).add(i);

            }

            if (!temp.get("Tidspunkter").containsKey(Long.toString(i.getTidspunkt()))) {
                List<Arrangement> temp1 = new ArrayList<>();
                temp1.add(i);
                temp.get("Tidspunkter").put(Long.toString(i.getTidspunkt()), temp1);
            } else {
                temp.get("Tidpunkter").get(Long.toString(i.getTidspunkt())).add(i);
            }

        }
        return temp;
    }

    @Override
    public String toString() {
        return register.toString();
    }

    public static void main(String[] args) {
        Arrangement test1 = new Arrangement("Jobbing", "Kontoret", "TIHLDE", "Linjeforening", 202309181900L);
        Arrangement test2 = new Arrangement("gamin", "Kontoret", "TIHLDE", "Linjeforening", 202309181800L);
        Arrangement test3 = new Arrangement("Matlaging", "Hybel", "Meg", "Livets Harde Gang", 2023091202100L);
        ArrangementRegister test = new ArrangementRegister();
        test.nyttArrangement(test1);
        test.nyttArrangement(test2);
        test.nyttArrangement(test3);

        System.out.println("Velg modus:");
        System.out.println("1. Søk på sted");
        System.out.println("2. Søk etter dato");
        System.out.println("3. Søk etter tidsintervall");
        System.out.println("4. Sortert etter sted, type eller tidspunkt");

        int valg = inp.nextInt();

        switch (valg) {
            case 1 -> {
                System.out.println("Skriv inn sted: ");
                inp.nextLine();
                System.out.println(test.paSted(inp.nextLine()));
            }
            case 2 -> {
                System.out.println("Skriv inn dato på formatet yyyymmdd: ");
                System.out.println(test.paDato(inp.nextLong()));
            }
            case 3 -> {
                System.out.println("Hvilken tid vil du ha fra? ");
                long fra = inp.nextLong();
                System.out.println("Hvilken tid vil du ha til? ");
                System.out.println(test.intervallTid(fra, inp.nextLong()));
            }
            case 4 -> {
                HashMap<String, HashMap<String, List<Arrangement>>> sortert = test.sortertLister();
                System.out.println("Hva vil du sortere etter? ");
                System.out.println("1. Sted");
                System.out.println("2. Type");
                System.out.println("3. Tidspunkt");
                int valg2 = inp.nextInt();
                switch (valg2) {
                    case 1 -> {
                        System.out.println(sortert.get("Steder").keySet());
                        System.out.println("Skriv inn et sted fra listen");
                        inp.nextLine();
                        System.out.println(sortert.get("Steder").get(inp.nextLine()));
                    }
                    case 2 -> {
                        System.out.println(sortert.get("Typer").keySet());
                        System.out.println("Skriv inn en type fra listen");
                        inp.nextLine();
                        System.out.println(sortert.get("Typer").get(inp.nextLine()));
                    }
                    case 3 -> {
                        System.out.println(sortert.get("Tidspunkter").keySet());
                        System.out.println("Skriv inn et tidspunkt fra listen");
                        inp.nextLine();
                        System.out.println(sortert.get("Tidspunkter").get(inp.nextLine()));
                    }
                }
            }
        }

    }


}
