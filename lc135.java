import java.util.Arrays;

public class lc135 {
  static public int candy(int[] ratings) {
    int l = ratings.length;
    int[] tmp = new int[l];
    int ans = 0;
    Arrays.fill(tmp, 1);
    for (int i = 1; i < l; i++) {
      if (ratings[i] <= ratings[i - 1])
        continue;
      if (tmp[i] > tmp[i - 1])
        continue;
      tmp[i] = tmp[i - 1] + 1;
    }
    for (int i = l - 2; i >= 0; i--) {
      if (ratings[i] <= ratings[i + 1])
        continue;
      if (tmp[i] > tmp[i + 1])
        continue;
      tmp[i] = tmp[i + 1] + 1;
    }
    for (int t : tmp)
      ans += t;
    return ans;
  }

  public static void main(String[] args) {
    int[] ratings = { 3, 6, 3, 2 };
    System.out.println(candy(ratings));
  }
}
