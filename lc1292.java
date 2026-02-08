public class lc1292 {
  static public int maxSideLength(int[][] mat, int threshold) {
    int lr = mat.length;
    int lc = mat[0].length;
    int maxL = Math.min(lr, lc);
    int[][] prefix = new int[lr + 1][lc + 1];
    for (int c = 0; c <= lc; c++)
      prefix[0][c] = 0;
    for (int r = 0; r <= lr; r++)
      prefix[r][0] = 0;
    // filling the prefix matrix
    for (int r = 1; r <= lr; r++)
      for (int c = 1; c <= lc; c++)
        prefix[r][c] = prefix[r - 1][c] + prefix[r][c - 1] -
            prefix[r - 1][c - 1] + mat[r - 1][c - 1];
    int lp = 0, rp = maxL, mp;
    while (lp < rp) {
      mp = (lp + rp + 1) / 2;
      if (can(mp, threshold, prefix))
        lp = mp;
      else
        rp = mp - 1;
    }
    return lp;
  }

  static public boolean can(int size, int threshold, int[][] prefix) {
    if (--size == -1)
      return true;
    int lr = prefix.length - 1;
    int lc = prefix[0].length - 1;
    for (int r = 0; r < lr; r++) {
      for (int c = 0, tmp = 0; c < lc; c++) {
        if (r + 1 + size > lr || c + 1 + size > lc)
          break;
        tmp = prefix[r + 1 + size][c + 1 + size] - prefix[r + 1 + size][c] -
            prefix[r][c + 1 + size] + prefix[r][c];
        if (tmp <= threshold)
          return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] mat = {
        { 1, 1, 3, 2, 4, 3, 2 },
        { 1, 1, 3, 2, 4, 3, 2 },
        { 1, 1, 3, 2, 4, 3, 2 }
    };
    int threshold = 4;
    System.out.println(maxSideLength(mat, threshold));
  }
}
