public class lc2598 {
  public int findSmallestInteger(int[] nums, int value) {
    int l = nums.length;
    int[] map = new int[value];
    int tmp;
    int count;
    for (int n : nums) {
      if (n < 0)
        n = n % value + value;
      tmp = n % value;
      map[tmp]++;
    }
    for (int i = 0; i < l; i++) {
      tmp = i % value;
      count = map[tmp];
      if (count == 0)
        return i;
      map[tmp]--;
    }
    return l;
  }
}