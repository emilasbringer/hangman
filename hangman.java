public class hangman {
    public static void main (String[] arg) {

        String secretword = randomWordGenerator();
        int wordlength = secretword.length();
        int i = 0;

        char letters[] = new char[wordlength];

        while(i < wordlength) {
          letters[i] = secretword.charAt(i);
          i++;
        }












    }

    private static String randomWordGenerator() {
        String[] word = {"HUND", "FISK", "MAKARON", "ÅSNA", "GET", "FLÖJT", "SILL", "UNIVERSUM", "CHOCKLAD", "KANOT"};
        return word[(int) (Math.random() * word.length)];
    }
}
