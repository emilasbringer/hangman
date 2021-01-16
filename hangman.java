import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class hangman {
    public static void main (String[] arg) {

        String secretword = randomWordGenerator();
        String guess;
        int wordlength = secretword.length();
        int ToFlength = secretword.length();
        int i = 0;
        int life = 10;

        char letters[] = new char[wordlength];
        char trueorfalse[] = new char [ToFlength];
        char empty = '_';

        while(i < wordlength) {
          letters[i] = secretword.charAt(i);
          trueorfalse[i] = empty;
          i++;
        }

        guess = JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(trueorfalse));











    }

    private static String randomWordGenerator() {
        String[] word = {"HUND", "FISK", "MAKARON", "ÅSNA", "GET", "FLÖJT", "SILL", "UNIVERSUM", "CHOCKLAD", "KANOT"};
        return word[(int) (Math.random() * word.length)];
    }
}
