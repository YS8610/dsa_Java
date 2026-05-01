public class lc1536 {
  public int minSwaps(int[][] grid) {
    int l = grid.length;
    int[] map = new int[l];
    int ans = 0;
    for (int i = 0, n = l - 1, j = 0; i < l; i++) {
      j = n;
      while (j >= 0 && grid[i][j] != 1)
        j--;
      map[i] = j;
    }
    // System.out.println(Arrays.toString(map));
    for (int i = 0, j = 0, tmp = 0; i < l; i++) {
      j = i;
      while (j < l && map[j] > i)
        j++;
      if (j == l)
        return -1;
      while (j > i && map[j] < j) {
        tmp = map[j];
        map[j] = map[j - 1];
        map[j - 1] = tmp;
        j--;
        ans++;
      }
    }
    return ans;
  }
}
