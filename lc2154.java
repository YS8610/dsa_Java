public class lc2154 {
  public int findFinalValue(int[] nums, int original) {
    boolean[] map = new boolean[1001];
    for (int n : nums)
      map[n] = true;
    while (original <= 1001 && map[original])
      original <<= 1;
    return original;
  }
}
