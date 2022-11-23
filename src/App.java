import java.io.File;
import java.util.Scanner;

import model.BruteForce;
import model.KMP;
import terminal.Terminal;
import terminal.Terminal.Color;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/text.txt"));

        String text = "";

        while (sc.hasNextLine()) {
            text += sc.nextLine();
        }

        Terminal.println(Color.CYAN_BRIGHT, "Searching for patterns in text file with Brute Force algorithm:");

        Terminal.println(Color.PURPLE_BRIGHT, "Pattern: TATATAAGAAAAAAG");
        BruteForce.search(text, "TATATAAGAAAAAAG");

        Terminal.println(Color.PURPLE_BRIGHT, "Pattern: AGACTCTG");
        BruteForce.search(text, "AGACTCTG");

        Terminal.println(Color.PURPLE_BRIGHT, "Pattern: GAGAGCGG");
        BruteForce.search(text, "GAGAGCGG");

        Terminal.println(Color.PURPLE_BRIGHT, "Pattern: TCCTCCCAC");
        BruteForce.search(text, "TCCTCCCAC");

        Terminal.println(Color.CYAN_BRIGHT, "\nSearching for patterns in text file with KMP algorithm:");

        Terminal.println(Color.PURPLE_BRIGHT, "Pattern: TATATAAGAAAAAAG");
        KMP.search(text, "TATATAAGAAAAAAG");

        Terminal.println(Color.PURPLE_BRIGHT, "Pattern: AGACTCTG");
        KMP.search(text, "AGACTCTG");

        Terminal.println(Color.PURPLE_BRIGHT, "Pattern: GAGAGCGG");
        KMP.search(text, "GAGAGCGG");

        Terminal.println(Color.PURPLE_BRIGHT, "Pattern: TCCTCCCAC");
        KMP.search(text, "TCCTCCCAC");

    }
}
