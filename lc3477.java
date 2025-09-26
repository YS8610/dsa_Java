public class lc3477 {
  public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
    int l = fruits.length;
    boolean[] used = new boolean[l];
    int ans = l;
    for (int f : fruits) {
      for (int i = 0; i < l; i++) {
        if (used[i] || baskets[i] < f)
          continue;
        ans--;
        used[i] = true;
        break;
      }
    }
    return ans;
  }
}
