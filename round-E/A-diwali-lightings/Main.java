import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numCases = sc.nextInt();
    sc.nextLine();

    for (int caseId = 1; caseId <= numCases; caseId++) {
      // Inputs
      String sequence = sc.nextLine();
      long start = sc.nextLong();
      long end = sc.nextLong();
      sc.nextLine();

      // Setup
      int[] counts = new int[sequence.length() + 1];
      int accum = 0;
      for (int i = 0; i < sequence.length(); i++) {
        if (sequence.charAt(i) == 'B') accum++;
        counts[i + 1] = accum;
      }

      // Processing
      long ans = numBlueBulbs(counts, end) - numBlueBulbs(counts, start - 1);

      // Print results
      p("Case #" + caseId + ": " + ans);
    }
  }

  private static long numBlueBulbs(int[] counts, long index) {
    int sequenceLength = counts.length - 1;
    return index / (long) sequenceLength * counts[sequenceLength] + counts[(int) (index % (long) sequenceLength)];
  }

  //////////

  private static void p() {
    p("");
  }

  private static void p(String s) {
    System.out.println(s);
  }
}
