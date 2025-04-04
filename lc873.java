import java.util.Set;
import java.util.HashSet;

class lc873 {
  static public int lenLongestFibSubseq(int[] arr) {
    int l = arr.length;
    Set<Integer> set = new HashSet<>();
    for (int a : arr)
      set.add(a);
    int ans = 0;
    for (int i = 0, n = l - 2; i < n; i++)
      for (int j = i + 1, m = l - 1; j < m && j < l - ans; j++)
        ans = Math.max(ans, flen(set, arr[i], arr[j]));
    return ans > 0 ? ans + 2 : 0;
  }

  private static int flen(Set<Integer> set, int t1, int t2) {
    int t3 = t1 + t2;
    if (!set.contains(t3))
      return 0;
    int ans = 1 + flen(set, t2, t3);
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
    System.out.println(lenLongestFibSubseq(arr));
  }

}
