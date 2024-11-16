import java.util.Arrays;

public class lc2070 {

  private static int find1st(int[] px, int q) {
    int pos = Arrays.binarySearch(px, q);
    if (pos >= 0) {
      while (pos >= 0) pos = Arrays.binarySearch(px, 0, pos, q);
      return -pos - 1;
    }
    pos = -pos - 1;
    if (pos == 0) return -1;
    if (pos == px.length) return find1st(px, px[px.length - 1]);
    // find 1st pos of larger int
    pos = find1st(px, px[pos]);
    // pos-1 = last pos of 1st smaller int
    return find1st(px, px[pos - 1]);
  }

  private static int[] maximumBeauty(int[][] items, int[] queries) {
    int[] ans = new int[queries.length];
    Arrays.sort(items, (m1, m2) -> {
        if (m1[0] == m2[0]) return Integer.compare(m2[1], m1[1]);
        return Integer.compare(m1[0], m2[0]);
      }
    );
    for (int i = 0, n = items.length, tmp = items[0][1]; i < n; i++) {
      tmp = Math.max(tmp, items[i][1]);
      items[i][1] = tmp;
    }
    int[] px = new int[items.length];
    for (int i = 0, n = items.length; i < n; i++) px[i] = items[i][0];
    for (int i = 0, n = queries.length; i < n; i++) {
      int tmp = find1st(px, queries[i]);
      if (tmp < 0) ans[i] = 0; else ans[i] = items[tmp][1];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
    int[] queries = {1,2,3,4,5,6};
    System.out.println(Arrays.toString(maximumBeauty(items, queries)));
  }
}
