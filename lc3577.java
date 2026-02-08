public class lc3577 {
  public int countPermutations(int[] complexity) {
    int l = complexity.length;
    int lowest = complexity[0];
    for (int i = 1; i < l; i++)
      if (lowest >= complexity[i])
        return 0;
    int ans = 1;
    int MOD = 1000000007;
    for (int i = l - 1; i > 1; i--)
      ans = (int) ((1l * ans * i) % MOD);
    return ans;
  }
}
