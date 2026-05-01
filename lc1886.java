import java.util.Arrays;

public class lc1886 {
  static public boolean findRotation(int[][] mat, int[][] target) {
    int lr = mat.length;
    int lc = mat[0].length;
    if (lr == 1)
      return isEqual(mat, target);
    int[] tlp = new int[] { 0, 0 };
    int[] trp = new int[] { 0, lc - 1 };
    int[] blp = new int[] { lr - 1, 0 };
    int[] brp = new int[] { lr - 1, lc - 1 };
    for (int rotation = 0; rotation<4;rotation++){
      tlp[0] = 0;
      tlp[1] = 0;
      trp[0] = 0;
      trp[1] = lc - 1;
      blp[0] = lr - 1;
      blp[1] = 0;
      brp[0] = lr - 1;
      brp[1] = lc - 1;
      for (int i = lr, tmp = 0; i > 1; i -= 2) {
        for (int j = 0, n = blp[0] - tlp[0]; j < n; j++) {
          tmp = mat[tlp[0]][tlp[1] + j];
          mat[tlp[0]][tlp[1] + j] = mat[blp[0] - j][blp[1]];
          mat[blp[0] - j][blp[1]] = mat[brp[0]][brp[1] - j];
          mat[brp[0]][brp[1] - j] = mat[trp[0] + j][trp[1]];
          mat[trp[0] + j][trp[1]] = tmp;
        }
        tlp[0]++;
        tlp[1]++;
        trp[0]++;
        trp[1]--;
        blp[0]--;
        blp[1]++;
        brp[0]--;
        brp[1]--;
      }
      if (isEqual(mat, target))
        return true;
    }
    return false;
  }

  static public boolean isEqual(int[][] mat, int[][] target) {
    int lr = mat.length;
    int lc = mat[0].length;
    for (int r = 0; r < lr; r++)
      for (int c = 0; c < lc; c++)
        if (mat[r][c] != target[r][c])
          return false;
    return true;
  }

  public static void main(String[] args) {
    int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } }, target = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } };
    System.out.println(findRotation(mat, target));
  }
}
