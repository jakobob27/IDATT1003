package oving6;

import java.util.ArrayList;
import java.util.List;

public class Matrise {

    private final List<List<Integer>> matrise;
    private int rows=0;
    private int cols=0;

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
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list2.add(2);
        list1.add(3);
        list2.add(4);

        List<List<Integer>> m1 = new ArrayList<>();
        m1.add(list1);
        m1.add(list2);

        List<List<Integer>> m2 = new ArrayList<>();
        m2.add(list2);
        m2.add(list1);

        Matrise test1 = new Matrise(m1);
        Matrise test2 = new Matrise(m2);

        System.out.println(test1);
        System.out.println(test2);

        Matrise test3 = test1.addisjon(test2);

        System.out.println(test3);

        Matrise test4 = test1.multiply(test2);

        System.out.println(test4);

        System.out.println(test4.transpose());

    }
}

