public class lc1578 {

  static public int minCost(String colors, int[] neededTime) {
    int l = colors.length();
    int ans = 0;
    int lp = 0, rp = 1;
    int sum = 0;
    int high = neededTime[lp];
    while (lp < l) {
      rp = lp + 1;
      sum = neededTime[lp];
      high = neededTime[lp];
      // move rp
      while (rp < l && colors.charAt(lp) == colors.charAt(rp)) {
        sum += neededTime[rp];
        high = Math.max(high, neededTime[rp]);
        rp++;
      }
      ans += sum - high;
      // move lp
      lp = rp;
    }
    return ans;
  }

  public static void main(String[] args) {
    String colors = "aabaa";
    int[] neededTime = { 1, 2, 3, 4, 1 };
    System.out.println(minCost(colors, neededTime));
  }
}
