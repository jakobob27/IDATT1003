package Oving10;

import java.util.*;

public class ArrangementRegister {
    private final List<Arrangement> register;

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

        System.out.println(test);
        System.out.println(test.paSted("Kontoret"));
        System.out.println(test.paDato(20230918));
        System.out.println(test.intervallTid(20230918, 20230919));
        System.out.println(test.sortertLister());

    }


}
