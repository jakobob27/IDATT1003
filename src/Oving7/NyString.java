package Oving7;

public class NyString {
    private final String str;

    public NyString(String str) {
        this.str=str;
    }

    public String forkort() {
        StringBuilder forkortet = new StringBuilder();
        String[] ord = str.split(" ");
        for (String s : ord) {
            forkortet.append(s.charAt(0));
        }
        return forkortet.toString();
    }

    public String tegnFjerner(String c) {
        return str.replace(c, "");
    }

    public static void main(String[] args) {
        NyString test1 = new NyString("Trondheims Ingeniør Høgskole Linjeforening Dannede EDBere");
        System.out.println(test1.forkort());
        System.out.println(test1.tegnFjerner("i"));
    }
}
