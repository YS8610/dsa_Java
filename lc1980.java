import java.util.HashSet;
import java.util.Set;

public class lc1980 {
  public static String findDifferentBinaryString(String[] nums) {
    int l = nums.length;
    Set<Integer> set = new HashSet<>();
    int tmp;
    for (String num : nums) {
      tmp = 0;
      for (int i = 0; i < l; i++) {
        if (num.charAt(i) == '0')
          continue;
        tmp += (1 << (l - i - 1));
      }
      set.add(tmp);
    }
    char[] ans = new char[l];
    for (int i = 0, n = 2 << l; i < n; i++) {
      if (set.contains(i))
        continue;
      for (int j = l - 1, k = 0; j >= 0; j--)
        ans[k++] = ((i & (1 << j)) == 0 ? '0' : '1');
      return String.valueOf(ans);
    }
    return "";
  }

  public static void main(String[] args) {
    String[] nums = { "00", "10" };
    System.out.println(findDifferentBinaryString(nums));
  }
}
