public class lc3147 {
  private static int maximumEnergy(int[] energy, int k) {
    int l = energy.length;
    int[] dp = new int[l];
    for (int i = l - 1, counter = k; i >= 0 && counter > 0; i--, counter--) {
      dp[i] = energy[i];
    }
    for (int i = l - 1 - k; i >= 0; i--) {
      dp[i] = energy[i] + dp[i+k];
    }
    int ans = dp[0];
    for (int d : dp) ans=Math.max(ans, d);
    return ans;
  }

  public static void main(String[] args) {
    int[] energy = {5,2,-10,-5,1};
    int k = 3;
    System.out.println(maximumEnergy(energy, k));
  }
}
