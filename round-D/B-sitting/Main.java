import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numCases = sc.nextInt();

    for (int caseId = 1; caseId <= numCases; caseId++) {
      // Inputs
      int rows = sc.nextInt();
      int cols = sc.nextInt();

      // Setup
      // x x .
      // x . x
      // . x x
      int[][] grid = new int[][]{
        { 0, 1, 2 },
        { 0, 1, 1 },
        { 0, 0, 1 }
      };

      // Special case
      // x x .
      // x x .
      // . . x
      if (rows == 2 || cols == 2) {
        grid = new int[][]{
          { 0, 1, 2 },
          { 0, 1, 2 },
          { 0, 0, 0 }
        };
      }

      // Processing
      int numRow3 = rows / 3;
      int numRow2 = numRow3 + (rows % 3 / 2);
      int numRow1 = rows - numRow2 - numRow3;

      int numPlayersInRow1 = cols / 3 * 2 + grid[0][cols % 3];
      int numPlayersInRow2 = cols / 3 * 2 + grid[1][cols % 3];
      int numPlayersInRow3 = cols / 3 * 2 + grid[2][cols % 3];

      int ans = numRow1 * numPlayersInRow1 +
                numRow2 * numPlayersInRow2 +
                numRow3 * numPlayersInRow3;

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
