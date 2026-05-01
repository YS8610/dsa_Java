public class lc2946 {
  public boolean areSimilar(int[][] mat, int k) {
    int lr = mat.length;
    int lc = mat[0].length;
    for (int r = 0, tmp = 0; r < lr; r++) {
      for (int c = 0; c < lc; c++) {
        if (r % 2 == 0) {
          tmp = (c - k) % lc;
          if (tmp < 0)
            tmp = lc + tmp;
        } else
          tmp = (c + k) % lc;
        if (mat[r][c] != mat[r][tmp])
          return false;
      }
    }
    return true;
  }
}
