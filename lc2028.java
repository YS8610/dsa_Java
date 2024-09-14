import java.util.Arrays;

public class lc2028 {
  private static int[] missingRolls(int[] rolls, int mean, int n) {
    int[] ans = new int[n];
    int l = rolls.length;
    int total = mean * (l+n);
    int mtotal = 0;
    for (int r:rolls) mtotal +=r;
    int ntotal = total - mtotal;
    if (ntotal < n) return new int[0];
    if (ntotal <= 0) return new int[0];
    if (n*6 <ntotal) return new int[0];
    int nmean = ntotal/n;
    int remainder = ntotal%n;
    Arrays.fill(ans, nmean);
    for(int i=0;i<remainder;i++) ans[i]++;
    return ans;
  }

  public static void main(String[] args) {
    int[] rolls = {3,2,4,3};
    int mean = 4, n = 2;
    System.out.println(Arrays.toString(missingRolls(rolls, mean, n)));
  }
}
