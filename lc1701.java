public class lc1701 {

  private static double averageWaitingTime(int[][] customers) {
    int l = customers.length;
    int[][] interval = new int[l][2];
    double totaltime = 0;
    for (int i = 0; i < l; i++) {
      interval[i][0] = customers[i][0];
      if (i == 0) {
        interval[i][1] = customers[i][1] + customers[i][0];
        continue;
      }
      if (customers[i][0] < interval[i - 1][1]) {
        interval[i][1] = interval[i - 1][1] + customers[i][1];
      } else interval[i][1] = interval[i][0] + customers[i][1];
    }
    // System.out.println(Arrays.deepToString(interval));
    for (int[] i : interval) totaltime += i[1] - i[0];
    return totaltime / l;
  }

  private static double averageWaitingTime1(int[][] customers) {
    int l = customers.length;
    int t = 0;
    double ans = 0;
    t = 0;
    for (int i = 0; i < l; i++) {
      if (t > customers[i][0]) ans += t - customers[i][0];
      else t = customers[i][0];
      ans += customers[i][1];
      t += customers[i][1];
    }
    return ans / l;
  }

  public static void main(String[] args) {
    int[][] customers = {{1,2},{2,5},{4,3}};
    System.out.println(averageWaitingTime1(customers));
    System.out.println(averageWaitingTime(customers));
  }
}
