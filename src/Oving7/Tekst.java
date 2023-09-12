package Oving7;

public class Tekst {

    private final String str;

    public Tekst (String str) {
        this.str=str;
    }

    public int antallOrd() {
        String[] ord = str.split(" ");
        return ord.length;
    }

    public double gjenomsnittligLengde() {
        double sum = 0;
        String temp=fjernSkilleTegn();
        String[] ord = temp.split(" ");
        for (String s : ord) {
            sum+=s.length();
        }

        return sum/antallOrd();
    }

    public String fjernSkilleTegn() {
        String temp = str.replace("?", "");
        temp=temp.replace(".", "");
        temp=temp.replace(",", "");
        temp=temp.replace("!", "");
        return temp;
    }

    public double gjenomsnitligPeriode() {
        String[] ord = str.split(" ");
        double sum=0;
        double perioder=0;
        for (String s : ord) {
            if (s.contains(".") || s.contains("!") || s.contains(":") || s.contains("?")) {
                perioder++;
                sum--;
            }

            sum+=s.length();
        }
        return sum/perioder;
    }

    public String replaceWord(String oldString, String newString) {
        return str.replace(oldString, newString);
    }

    public String getStr() {
        return str;
    }

    public String getBigStr() {
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        Tekst test = new Tekst("Skattesvindel eller grovbrød?");
        System.out.println(test.antallOrd());
        System.out.println(test.gjenomsnittligLengde());
        System.out.println(test.gjenomsnitligPeriode());
        System.out.println(test.replaceWord("eller", "og"));
        System.out.println(test.getStr());
        System.out.println(test.getBigStr());
    }
}
