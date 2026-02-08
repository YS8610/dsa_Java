import java.util.Arrays;

public class lc955 {
  static public int minDeletionSize(String[] strs) {
    int l = strs.length;
    int strl = strs[0].length();
    String[] ans = new String[l];
    for (int i =0;i<l;i++)
        ans[i] = new String();
    for (int c = 0; c < strl; c++) {
      String[] copy = Arrays.copyOf(ans, l);
      for (int r = 0; r < l; r++)
        copy[r] += strs[r].charAt(c);
      if (isSorted(copy))
        ans = copy;
    }
    return strl - ans[0].length();
  }

  static public boolean isSorted(String[] copy) {
    int l = copy.length;
    for (int i = 1; i < l; i++)
      if (copy[i].compareTo(copy[i - 1]) < 0)
        return false;
    return true;
  }

  public static void main(String[] args) {
    String[] strs = {"ca","bb","ac"};
    System.out.println(minDeletionSize(strs));
  }
}
