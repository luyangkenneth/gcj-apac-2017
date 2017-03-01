import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numCases = sc.nextInt();
    sc.nextLine();

    for (int caseId = 1; caseId <= numCases; caseId++) {
      // Inputs
      String target = sc.nextLine();

      // Setup
      long ans = 1;

      for (int i = 0; i < target.length(); i++) {
        HashSet<Character> hashset = new HashSet<Character>();
        hashset.add(target.charAt(i));
        if (i != 0) hashset.add(target.charAt(i - 1));
        if (i != target.length() - 1) hashset.add(target.charAt(i + 1));

        ans = ans * hashset.size() % 1000000007;
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
