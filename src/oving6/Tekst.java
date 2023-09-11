package oving6;

import java.util.Arrays;

public class Tekst {

    private final String tekst;
    int[] antallTegn = new int[30];
    int asciiConvert=97;

    public Tekst (String input) {
        tekst=input;
    }

    public void charCounter() {
        String tempTekst = tekst.toLowerCase();

        for (int i=0; i<tempTekst.length(); i++) {
            char tempChar = tempTekst.charAt(i);
            if (tempChar==' ') {
                continue;
            }
            int charValue;
            switch (tempChar) {
                case 'æ' -> charValue = 26;
                case 'ø' -> charValue = 27;
                case 'å' -> charValue = 28;
                default -> {
                    charValue = tempChar - asciiConvert;
                    if (charValue > 29 || charValue < 0) {
                        charValue = 29;
                    }
                }
            }

            antallTegn[charValue]+=1;

        }
    }

    @Override
    public String toString() {
        return Arrays.toString(antallTegn);
    }

    public static void main(String[] args) {
        Tekst test = new Tekst("abc abc ABC Ø æ Å ?");
        test.charCounter();
        System.out.println(test);
    }
}
