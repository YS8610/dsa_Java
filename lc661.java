import java.util.Arrays;

public class lc661 {

  private static int validval(int[][] img, int r, int c) {
    int rlen = img[0].length;
    int clen = img.length;
    if (r < 0 || c < 0 || r >= clen || c >= rlen) return 0;
    return 1;
  }

  private static int validsum(int[][] img, int r, int c) {
    int rlen = img[0].length;
    int clen = img.length;
    if (r < 0 || c < 0 || r >= clen || c >= rlen) return 0;
    return img[r][c];
  }

  private static int[][] imageSmoother(int[][] img) {
    int rlen = img[0].length;
    int clen = img.length;
    int[][] ans = new int[clen][rlen];
    int count, sum;
    for (int r = 0; r < clen; r++) {
      count = 0;
      sum = 0;
      for (int c = 0; c < rlen; c++) {
        count =
          validval(img, r, c) +
          validval(img, r - 1, c) +
          validval(img, r + 1, c) +
          validval(img, r + 1, c + 1) +
          validval(img, r - 1, c - 1) +
          validval(img, r + 1, c - 1) +
          validval(img, r - 1, c + 1) +
          validval(img, r, c + 1) +
          validval(img, r, c - 1);
        sum =
          validsum(img, r, c) +
          validsum(img, r - 1, c) +
          validsum(img, r + 1, c) +
          validsum(img, r + 1, c + 1) +
          validsum(img, r - 1, c - 1) +
          validsum(img, r + 1, c - 1) +
          validsum(img, r - 1, c + 1) +
          validsum(img, r, c + 1) +
          validsum(img, r, c - 1);
        ans[r][c] = sum / count;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] img = { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } };
    System.out.println(Arrays.deepToString(imageSmoother(img)));
  }
}
