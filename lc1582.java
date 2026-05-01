public class lc1582 {
  public int numSpecial(int[][] mat) {
    int row = mat.length;
    int col = mat[0].length;
    int[][] prefix = new int[row + 1][col + 1];
    int[][] prefix1 = new int[row + 1][col + 1];
    int ans = 0;
    for (int r = 0; r < row; r++)
      for (int c = 0; c < col; c++)
        prefix[r + 1][c + 1] = prefix[r + 1][c] + mat[r][c];
    for (int c = 0; c < col; c++)
      for (int r = 0; r < row; r++)
        prefix1[r + 1][c + 1] = prefix1[r][c + 1] + mat[r][c];
    // System.out.println(Arrays.deepToString(prefix));
    // System.out.println(Arrays.deepToString(prefix1));
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (mat[r][c] == 0)
          continue;
        // System.out.printf("%d %d %d %d\n", prefix[r+1][c], prefix[r+1][col],
        // prefix1[r][c+1], prefix1[row][c+1]);
        if (prefix[r + 1][c] != 0 || prefix[r + 1][col] != 1)
          continue;
        if (prefix1[r][c + 1] != 0 || prefix1[row][c + 1] != 1)
          continue;
        ans++;
      }
    }
    return ans;
  }
}
