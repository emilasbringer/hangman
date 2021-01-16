import javax.swing.*;
import java.util.Arrays;

public class hangman {
    public static void main (String[] arg) {

        String secretword = randomWordGenerator();
        String guess;
        int wordlength = secretword.length();
        int ToFlength = secretword.length();
        int life = 10;
        int correctguesses = 0;
        int falseguesses = 0;
        boolean isrunning = true;
        boolean madetrueguess;
        boolean[] previouslyguessed = new boolean[wordlength];

        char letterguess;
        char[] secretletters = new char[wordlength];
        char[] displayletters = new char[ToFlength];
        char[] falseguess = new char[life];
        char understreck = '_';

        for (int i = 0; i <= wordlength - 1; i++) {
            secretletters[i] = secretword.charAt(i);
            displayletters[i] = understreck;
            previouslyguessed[i] = false;
        }

        while (isrunning) {
            madetrueguess = false;
            guess = JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess));
            letterguess = guess.toUpperCase().charAt(0);

            for (int i = 0; i <= wordlength - 1; i++) {
                if (letterguess == secretletters[i]) {
                    if(!previouslyguessed[i]) {
                        displayletters[i] = letterguess;
                        correctguesses++;
                        madetrueguess = true;
                        previouslyguessed[i] = true;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Aja baja no cheating the system!");
                        break;
                    }
                }
            }

            if (!madetrueguess) {
                falseguess[falseguesses] = letterguess;
                life--;
                falseguesses++;
            }

            if (life == 0) {
                isrunning = false;
                JOptionPane.showMessageDialog(null, "Game Over! You have 0 lifes remaining");
            }

            if (correctguesses == wordlength) {
                isrunning = false;
                JOptionPane.showMessageDialog(null, "You Win! \n With " + life + " lives to spare!");
            }


        }
    }


    private static String randomWordGenerator() {
        String[] word = {"HUND", "FISK", "MAKARON", "ÅSNA", "GET", "FLÖJT", "SILL", "UNIVERSUM", "CHOCKLAD", "KANOT"};
        return word[(int) (Math.random() * word.length)];
    }
}

