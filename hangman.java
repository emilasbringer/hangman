import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class hangman {
    public static void main (String[] arg) {

        String secretword = randomWordGenerator();
        String guess;
        int wordlength = secretword.length();
        int ToFlength = secretword.length();
        int life = 10;
        int correctguesses = 0;
        boolean isrunning = true;
        boolean madetrueguess = false;

        char letterguess;
        char secretletters[] = new char[wordlength];
        char displayletters[] = new char [ToFlength];
        char empty = '_';

        for(int i = 0 ; i <= wordlength - 1 ; i++) {
          secretletters[i] = secretword.charAt(i);
          displayletters[i] = empty;
        }

        while(isrunning) {
            guess = JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters));
            letterguess = guess.toUpperCase().charAt(0);

            for(int i = 0 ; i <= wordlength - 1 ; i++) {
                if (letterguess == secretletters[i]) {
                    displayletters[i] = letterguess;
                    correctguesses++;
                    madetrueguess = true;
                }
            }
        }









    }

    private static String randomWordGenerator() {
        String[] word = {"HUND", "FISK", "MAKARON", "ÅSNA", "GET", "FLÖJT", "SILL", "UNIVERSUM", "CHOCKLAD", "KANOT"};
        return word[(int) (Math.random() * word.length)];
    }
}
