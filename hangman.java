import javax.swing.*;
import java.util.Arrays;

public class hangman {

    static String secretword = randomWordGenerator();
    static int wordlength = secretword.length();
    static char letterguess;
    static boolean madetrueguess;
    static int correctguesses = 0;
    static boolean[] previouslyguessed = new boolean[wordlength];
    static char[] secretletters = new char[wordlength];
    static char[] displayletters = new char[wordlength];

    public static void main (String[] arg) {
        String guess;
        int life = 10;
        int falseguesses = 0;
        boolean isrunning = true;

        char[] falseguess = new char[life];
        char understreck = '_';

        //start
        JOptionPane.showMessageDialog(null, "Hello and welcome to my JOptionPane hangman game :]" + "\n" + " ");

        for (int i = 0; i <= wordlength - 1; i++) {
            secretletters[i] = secretword.charAt(i);
            displayletters[i] = understreck;
            previouslyguessed[i] = false;
        }

        while (isrunning) {
            System.out.println(life);
            madetrueguess = false;
            guess = hangmanGraphics(life, displayletters, falseguess);
            assert guess != null;
            letterguess = guess.toUpperCase().charAt(0);

//True guess check + anticheat same letter

        truechecker();

//falseguess checker + wrong guess tracker
            if (!madetrueguess) {
                for(int i = 0 ; i <= falseguesses  ; i++){
                    if (letterguess == falseguess[i]) {
                        JOptionPane.showMessageDialog(null, "You already guessed that!");
                        break;
                    }
                    else if(falseguess[i] == '\0'){
                        falseguess[falseguesses] = letterguess;
                        life--;
                        if(falseguesses < 9)
                            falseguesses++;
                        break;
                    }
                }
            }
//lifecounter + deathscreen
            if (life == 0) {
                isrunning = false;
                JOptionPane.showMessageDialog(null, "Game Over! You have 0 guesses remaining");
            }
//all letters done? + Winscreen
            if (correctguesses == wordlength) {
                isrunning = false;
                JOptionPane.showMessageDialog(null, "You Win! \n With " + life + " lives to spare!");
            }
        }
    }



    private static String randomWordGenerator() {
        String[] word = {"CHOCKLAD", "CHORIZO", "CLICK", "FISK", "FLÖJT", "GET", "HUND", "HUS", "HUVUD", "HÖNA", "HOCKEY", "HOSTA", "KANOT", "MAKARON", "SILL", "UNIVERSUM", "ÅSNA"};
        return word[(int) (Math.random() * word.length)];
    }

    private static String hangmanGraphics(int life, char[] displayletters, char[] falseguess){
        if (life > 9) {
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|------------------------------------------------------------|");
        }
        else if (life > 8) {
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|                                                                           |" + "\n" + "|      ------------------                                               |" + "\n" + "|    /                         \\                                            |" + "\n" + "|  /                            \\                                           |" + "\n" + "|------------------------------------------------------------|");
        }
        else if (life >7){
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|      ------------------                                               |" + "\n" + "|    /                         \\                                            |" + "\n" + "|  /                            \\                                           |" + "\n" + "|------------------------------------------------------------|");
        }
        else if (life >6){
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|              |---------------------------------                   |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|      ------------------                                               |" + "\n" + "|    /                         \\                                            |" + "\n" + "|  /                            \\                                           |" + "\n" + "|------------------------------------------------------------|");
        }
        else if (life >5) {
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|              |---------------------------------                   |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|      ------------------                                               |" + "\n" + "|    /                         \\                                            |" + "\n" + "|  /                            \\                                           |" + "\n" + "|------------------------------------------------------------|");
        }
        else if (life >4){
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|              |---------------------------------                   |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                       /--\\                 |" + "\n" + "|              |                                       \\--/                 |" + "\n" + "|              |                                                            |" + "\n" + "|              |                                                            |" + "\n" + "|      ------------------                                               |" + "\n" + "|    /                         \\                                            |" + "\n" + "|  /                            \\                                           |" + "\n" + "|------------------------------------------------------------|");
        }
        else if (life >3){
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|              |---------------------------------                   |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                       /--\\                 |" + "\n" + "|              |                                       \\--/                 |" + "\n" + "|              |                                         |                   |" + "\n" + "|              |                                         |                   |" + "\n" + "|      ------------------                            |                  |" + "\n" + "|    /                         \\                                            |" + "\n" + "|  /                            \\                                           |" + "\n" + "|------------------------------------------------------------|");
        }
        else if (life >2){
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|              |---------------------------------                   |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                       /--\\                 |" + "\n" + "|              |                                       \\--/                 |" + "\n" + "|              |                                         |                   |" + "\n" + "|              |                                         |                   |" + "\n" + "|      ------------------                            |                  |" + "\n" + "|    /                         \\                         /\\                   |" + "\n" + "|  /                            \\                                           |" + "\n" + "|------------------------------------------------------------|");
        }
        else if (life >1){
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|              |---------------------------------                   |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                       /--\\                 |" + "\n" + "|              |                                       \\--/                 |" + "\n" + "|              |                                         |-----              |" + "\n" + "|              |                                         |                   |" + "\n" + "|      ------------------                            |                  |" + "\n" + "|    /                         \\                         /\\                   |" + "\n" + "|  /                            \\                                           |" + "\n" + "|------------------------------------------------------------|");
        }
        else if (life >0){
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|              |---------------------------------                   |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                       /--\\                 |" + "\n" + "|              |                                       \\--/                 |" + "\n" + "|              |                                   -----|-----              |" + "\n" + "|              |                                         |                   |" + "\n" + "|      ------------------                            |                  |" + "\n" + "|    /                         \\                         /\\                   |" + "\n" + "|  /                            \\                                           |" + "\n" + "|------------------------------------------------------------|");
        }
        else if (life >-1){
            return JOptionPane.showInputDialog("You have " + life + " guesses remaining! " + "\n" + Arrays.toString(displayletters) + "\n" + "\n" + "Wrong guesses: " + Arrays.toString(falseguess) + "\n" + "\n" + "|------------------------------------------------------------|" + "\n" + "|                                                                           |" + "\n" + "|              |---------------------------------                   |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                        |                    |" + "\n" + "|              |                                       /--\\                 |" + "\n" + "|              |                                       \\--/                 |" + "\n" + "|              |                                   -----|-----              |" + "\n" + "|              |                                         |                   |" + "\n" + "|      ------------------                            |                  |" + "\n" + "|    /                         \\                         /\\                   |" + "\n" + "|  /                            \\                                           |" + "\n" + "|------------------------------------------------------------|");
        }

        return JOptionPane.showInputDialog("operation failed");
    }
    public static void truechecker() {
        for (int i = 0; i <= wordlength - 1; i++) {
            if (letterguess == secretletters[i]) {
                if(!previouslyguessed[i]) {
                    displayletters[i] = letterguess;
                    correctguesses++;
                    madetrueguess = true;
                    previouslyguessed[i] = true;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Aja baja no cheating the system by typing a previously correct letter.");
                    break;
                }
            }
        }
    }

}