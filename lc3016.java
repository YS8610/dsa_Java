import java.util.Arrays;

public class lc3016 {

  private static int minimumPushes(String word) {
    int[] map = new int['z' - 'a' + 1];
    int l = word.length();
    for (int i = 0; i < l; i++) {
      map[word.charAt(i) - 'a']++;
    }
    int n = 0;
    for (int a : map) {
      if (a > 0) n++;
    }
    int[][] arr = new int[n][2];
    for (int i = 0, m = map.length; i < m; i++) {
      if (map[i] == 0) continue;
      arr[n - 1][0] = i;
      arr[n - 1][1] = map[i];
      n--;
    }
    Arrays.sort(arr, (m1, m2) -> Integer.compare(m2[1], m1[1]));
    int ans = 0;
    for (int i = 0, m = arr.length; i < m; i++) {
      if (i >= 0 && i <= 7) {
        ans += arr[i][1];
      } else if (i >= 8 && i <= 15) {
        ans += arr[i][1] * 2;
      } else if (i >= 16 && i <= 23) {
        ans += arr[i][1] * 3;
      } else ans += arr[i][1] * 4;
    }
    return ans;
  }

  public static void main(String[] args) {
    String word = "xyzxyzxyzxyz";
    System.out.println(minimumPushes(word));
  }
}
