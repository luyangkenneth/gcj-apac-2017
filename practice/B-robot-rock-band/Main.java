import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numCases = sc.nextInt();

    for (int caseId = 1; caseId <= numCases; caseId++) {
      // Inputs
      int N = sc.nextInt();
      int K = sc.nextInt();

      long[] arrayA = new long[N];
      long[] arrayB = new long[N];
      long[] arrayC = new long[N];
      long[] arrayD = new long[N];

      for (int i = 0; i < N; i++) arrayA[i] = sc.nextInt();
      for (int i = 0; i < N; i++) arrayB[i] = sc.nextInt();
      for (int i = 0; i < N; i++) arrayC[i] = sc.nextInt();
      for (int i = 0; i < N; i++) arrayD[i] = sc.nextInt();

      // Setup
      HashMap<Long, Long> mapAB = new HashMap<Long, Long>();
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          long xorAB = arrayA[i] ^ arrayB[j];
          if (mapAB.containsKey(xorAB)) mapAB.put(xorAB, mapAB.get(xorAB) + 1);
          else mapAB.put(xorAB, new Long(1));
        }
      }

      HashMap<Long, Long> mapCD = new HashMap<Long, Long>();
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          long xorCD = arrayC[i] ^ arrayD[j];
          if (mapCD.containsKey(xorCD)) mapCD.put(xorCD, mapCD.get(xorCD) + 1);
          else mapCD.put(xorCD, new Long(1));
        }
      }

      // Processing
      long ans = 0;
      for (Map.Entry<Long, Long> entry : mapAB.entrySet()) {
        // For each xorAB in mapAB, does its complement (relative to K) exist in mapCD?
        Long xorAB = entry.getKey();
        Long occurrences = entry.getValue();

        long complement = xorAB ^ K;
        if (mapCD.containsKey(complement)) ans += occurrences * mapCD.get(complement);
      }

      // Print results
      p("Case #" + caseId + ": " + ans);
    }
  }

  //////////

  private static void p() {
    p("");
  }

  private static void p(String s) {
    System.out.println(s);
  }
}
