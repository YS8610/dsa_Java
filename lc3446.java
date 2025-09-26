import java.util.Arrays;

public class lc3446 {
  public int[][] sortMatrix(int[][] grid) {
    int l = grid.length;
    int[] tmp = new int[l];
    // sort bottom left triangle
    for (int r = 0, r1 = 0, c = 0, i = 0; r < l; r++) {
      c = 0;
      r1 = r;
      i = 0;
      while (r1 < l && c < l)
        tmp[i++] = grid[r1++][c++];
      Arrays.sort(tmp, 0, i);
      r1 = r;
      c = 0;
      for (int j = i - 1; j >= 0; j--)
        grid[r1++][c++] = tmp[j];
    }
    // sort top right triangle
    for (int c = 1, r = 0, c1 = c, i = 0; c < l; c++) {
      c1 = c;
      r = 0;
      i = 0;
      while (r < l && c1 < l)
        tmp[i++] = grid[r++][c1++];
      Arrays.sort(tmp, 0, i);
      c1 = c;
      r = 0;
      for (int j = 0; j < i; j++)
        grid[r++][c1++] = tmp[j];
    }
    return grid;
  }
}
