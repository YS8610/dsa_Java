public class lc799 {
  static public double champagneTower(int poured, int query_row, int query_glass) {
    double[] glasses = new double[1];
    glasses[0] = poured;
    double[] ans = sim(glasses, query_row);
    return ans[query_glass] > 1 ? 1 : ans[query_glass];
  }

  static public double[] sim(double[] glasses, int qr) {
    if (qr == 0)
      return glasses;
    int l = glasses.length;
    double[] sec = new double[l + 1];
    double diff;
    for (int i = 0; i < l; i++) {
      if (glasses[i] <= 1)
        continue;
      diff = glasses[i] - 1;
      sec[i] += diff / 2;
      sec[i + 1] += diff / 2;
    }
    return sim(sec, qr - 1);
  }

  public static void main(String[] args) {
    int poured = 100000009, query_row = 33, query_glass = 17;
    System.out.println(champagneTower(poured, query_row, query_glass));
  }
}
