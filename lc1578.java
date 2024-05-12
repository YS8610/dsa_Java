public class lc1578 {

  private static int minCost(String colors, int[] neededTime) {
    int rp;
    int len = colors.length();
    int ans = 0;
    int max;
    int sum = 0;
    for (int lp = 0; lp < len - 1; lp++) {
      rp = lp + 1;
      if (rp >= len) break;
      if (colors.charAt(lp) != colors.charAt(rp)) continue; else {
        max = neededTime[lp];
        sum = max;
        while (rp < len && colors.charAt(lp) == colors.charAt(rp)) {
          sum += neededTime[rp];
          max = Math.max(max, neededTime[rp]);
          rp++;
        }
        ans += sum - max;
        lp = rp - 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String colors = "aabaa";
    int[] neededTime = {1,2,3,4,1};
    System.out.println( minCost(colors, neededTime) );
  }
}
