package model;

import terminal.Terminal;
import terminal.Terminal.Color;

public class BruteForce {
  public static void search(String text, String pattern) {
    int textSize = text.length();
    int patternSize = pattern.length();
    int occurrences = 0;
    int comparisons = 0;

    for (int i = 0; i <= textSize - patternSize; i++) {
      int j;

      for (j = 0; j < patternSize; j++) {
        comparisons++;
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }

      if (j == patternSize) {
        Terminal.println(Color.GREEN, "Pattern found at index " + i + " after " + comparisons + " comparisons");
        occurrences++;
      }
    }

    Terminal.println(Color.YELLOW, "Total of occurrences: " + occurrences);
  }
}
