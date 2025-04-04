import java.util.Arrays;

public class lc3169 {
  static public int countDays(int days, int[][] meetings) {
    int l = meetings.length;
    Arrays.sort(meetings, (m1, m2) -> {
      if (m1[0] == m2[0])
        return Integer.compare(m1[1], m2[1]);
      return Integer.compare(m1[0], m2[0]);
    });
    int[][] tmp = new int[l][2];
    tmp[0][0] = meetings[0][0];
    tmp[0][1] = meetings[0][1];
    for (int i = 1, j = 0; i < l; i++) {
      if (meetings[i][0] > tmp[j][1]) {
        tmp[++j][0] = meetings[i][0];
        tmp[j][1] = meetings[i][1] > tmp[j][1] ? meetings[i][1] : tmp[j][1];
        continue;
      }
      // merging
      tmp[j][1] = meetings[i][1] > tmp[j][1] ? meetings[i][1] : tmp[j][1];
    }
    int ans = days;
    for (int[] t : tmp) {
      if (t[0] == 0 && t[1] == 0)
        break;
      ans -= t[1] - t[0] + 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int days = 10;
    int[][] meetings = {{5,7},{1,3},{9,10}};
    System.out.println(countDays(days, meetings));
  }
}
