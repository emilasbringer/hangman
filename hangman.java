import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;

public class hangman {
    public static void main (String[] arg) {

        String secretword = randomWordGenerator();

        JOptionPane.showMessageDialog(null, secretword);










    }

    private static String randomWordGenerator() {
        String[] word = {"HUND", "FISK", "MAKARON", "ÅSNA", "GET", "FLÖJT", "SILL", "UNIVERSUM", "CHOCKLAD", "KANOT"};
        return word[(int) (Math.random() * word.length)];
    }
}
