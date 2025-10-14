import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc3186 {
  static public long maximumTotalDamage(int[] power) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int p : power)
      map.put(p, map.getOrDefault(p, 0) + 1);
    int[][] array = new int[map.size()][2];
    int i = 0;
    for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
      array[i][0] = (int) entry.getKey();
      array[i++][1] = (int) entry.getValue();
    }
    int m = map.size();
    Arrays.sort(array, (m1, m2) -> Integer.compare(m1[0], m2[0]));
    long[] dp = new long[m];
    dp[m - 1] = (long) array[m - 1][1] * array[m - 1][0];
    int pos;
    for (i = m - 2; i >= 0; i--) {
      pos = bs(array, array[i][0]+2);
      if (pos == m)
        dp[i] = Math.max((long)array[i][1]*array[i][0], dp[i+1]);
      else
        dp[i] = Math.max((long)array[i][1]*array[i][0] + dp[pos], dp[i+1]);
    }
    return dp[0];
  }

  public static int bs(int[][] array, int key){
    int l = array.length;
    int lp = 0, rp = l-1;
    int mp;
    if (key >= array[l-1][0])
      return l;
    if (key < array[0][0])
      return 0;
    while (lp < rp){
      mp = (lp+rp)/2;
      if (array[mp][0] <= key)
        lp = mp +1;
      else
        rp = mp;
    }
    return lp;
  }

  public static void main(String[] args) {
    int[] power = {7,1,6,3};
    System.out.println(maximumTotalDamage(power));
  }
}
