package Oving6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrise {

    private final List<List<Integer>> matrise;
    private int rows=0;
    private int cols=0;

    public Matrise() {
        List<List<Integer>> tempMatrise = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Hvor mange rader? ");
        rows= input.nextInt();

        System.out.println("Hvor mange kolonner? ");
        cols= input.nextInt();

        for (int i=1; i<rows+1;i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=1; j<cols+1; j++) {
                System.out.println("Skriv inn element nr." +j+" i rad " + i);
                temp.add(input.nextInt());
            }
            tempMatrise.add(temp);
        }
        this.matrise=tempMatrise;
        System.out.println(this);

    }

    public Matrise(List<List<Integer>> matrise) {

        this.matrise=matrise;
        rows= matrise.size();
        cols=matrise.get(0).size();
        for (List<Integer> l : matrise) {
            if (l.size()!=cols) {
                throw new IllegalArgumentException("Radene må ha lik lengde!");
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getElement (int row, int col) {
        return matrise.get(row).get(col);
    }

    public Matrise addisjon(Matrise m) {
        if (this.rows!=m.getRows() || this.cols!=m.getCols()) {
            return null;
        }
        List<List<Integer>> temp = new ArrayList<>();
        for (int i=0; i<matrise.size(); i++) {
            List<Integer> l = new ArrayList<>();
            temp.add(l);
            for (int j=0; j<matrise.get(i).size(); j++) {
                int val1 = this.getElement(i, j);
                int val2 = m.getElement(i, j);

                temp.get(i).add(val1+val2);
            }
        }
        return new Matrise(temp);
    }

    public Matrise subtract(Matrise m) {
        if (this.rows!=m.getRows() || this.cols!=m.getCols()) {
            return null;
        }
        List<List<Integer>> temp = new ArrayList<>();
        for (int i=0; i<matrise.size(); i++) {
            List<Integer> l = new ArrayList<>();
            temp.add(l);
            for (int j=0; j<matrise.get(i).size(); j++) {
                int val1 = this.getElement(i, j);
                int val2 = m.getElement(i, j);

                temp.get(i).add(val1-val2);
            }
        }
        return new Matrise(temp);
    }

    public Matrise multiply (Matrise m) {
        if (this.rows!=m.getCols() || this.cols!=m.getRows()) {
            return null;
        }
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i<rows; i++) {
            List<Integer> l = new ArrayList<>();
            temp.add(l);

            for (int j=0; j<m.getCols(); j++) {
                int dotSum=0;
                for (int k=0; k<cols; k++) {
                    dotSum+=this.getElement(i, k)*m.getElement(k, j);
                }
                temp.get(i).add(dotSum);
            }


        }

        return new Matrise(temp);
    }

    public Matrise transpose() {
        List<List<Integer>> temp = new ArrayList<>();
        for (int i=0; i<cols; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j=0; j<rows; j++) {
                l.add(this.getElement(j, i));
            }
            temp.add(l);
        }

        return new Matrise(temp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> l : matrise) {
            for (Integer i : l) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Matrise A = new Matrise();
        Matrise B = new Matrise();
        Matrise C = new Matrise();

        Matrise AB = A.multiply(B);
        Matrise BA = B.multiply(A);

        System.out.println(AB.subtract(BA));

        Matrise AC = A.multiply(C);
        Matrise CA = C.multiply(A);

        System.out.println(AC.subtract(CA));


    }
}

