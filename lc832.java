public class lc832 {

  private static int[][] flipAndInvertImage(int[][] image) {
    int rlen = image.length;
    int clen = image[0].length;
    int temp;
    if (rlen == 1) {
      if (image[0][0] == 0) image[0][0] = 1; else image[0][0] = 0;
      return image;
    }
    for (int r = 0; r < rlen; r++) {
      int lp = 0, rp = clen - 1;
      while (lp < rp) {
        temp = image[r][lp] == 0 ? 1 : 0;
        image[r][lp] = image[r][rp] == 0 ? 1 : 0;
        image[r][rp] = temp;
        lp++;
        rp--;
      }
    }
    if (rlen % 2 != 0) {
      for (int r = 0; r < rlen; r++) {
        image[r][rlen / 2] = image[r][rlen / 2] == 0 ? 1 : 0;
      }
    }
    return image;
  }

  public static void main(String[] args) {
    int[][] image = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
    System.out.println(flipAndInvertImage(image));
  }
}
