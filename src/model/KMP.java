package model;

import terminal.Terminal;
import terminal.Terminal.Color;

public class KMP {

  static int comparisons;

  public static void search(String text, String pattern) {
    int textSize = text.length();
    int pattenSize = pattern.length();
    int occurrences = 0;
    comparisons = 0;

    int[] prefixTable = computePrefixTable(pattern);

    int i = 0;
    int j = 0;
    while (i < textSize) {
      comparisons++;

      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      }

      if (j == pattenSize) {
        Terminal.println(Color.GREEN, "Pattern found at index " + (i - j) + " after " + comparisons + " comparisons");
        j = prefixTable[j - 1];
        occurrences++;
      } else {
        if (i < textSize && text.charAt(i) != pattern.charAt(j)) {
          if (j != 0) {
            j = prefixTable[j - 1];
          } else {
            i++;
          }
        }
      }
    }
    Terminal.println(Color.YELLOW, "Total of occurrences: " + occurrences);
  }

  public static int[] computePrefixTable(String pattern) {
    int patternSize = pattern.length();
    int[] prefixTable = new int[patternSize];
    int i = 1;
    int prefixSize = 0;
    prefixTable[0] = 0;

    while (i < patternSize) {

      if (pattern.charAt(i) == pattern.charAt(prefixSize)) {
        prefixSize++;
        prefixTable[i] = prefixSize;
        i++;
      } else {
        if (prefixSize != 0) {
          prefixSize = prefixTable[prefixSize - 1];
        } else {
          prefixTable[i] = prefixSize;
          i++;
        }
      }
    }
    return prefixTable;
  }
}
