import java.util.Arrays;

public class lc2943 {
  static public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
    int l1 = hBars.length;
    int l2 = vBars.length;
    Arrays.sort(hBars);
    Arrays.sort(vBars);
    int c1 = 1;
    int c2 = 1;
    for (int i = 1, tmp = 1; i < l1; i++) {
      if (hBars[i] - 1 != hBars[i - 1]) {
        tmp = 1;
        continue;
      }
      tmp++;
      c1 = Math.max(tmp, c1);
    }
    for (int i = 1, tmp = 1; i < l2; i++) {
      if (vBars[i] - 1 != vBars[i - 1]) {
        tmp = 1;
        continue;
      }
      tmp++;
      c2 = Math.max(tmp, c2);
    }
    int longestSide = Math.min(c1, c2) - 1 + 2;
    return longestSide * longestSide;
  }

  public static void main(String[] args) {
    int n = 1;
    int m = 1000000000;
    int[] hBars = { 2 }, vBars = { 1000000001 };
    System.out.println(maximizeSquareHoleArea(n, m, hBars, vBars));
  }
}
