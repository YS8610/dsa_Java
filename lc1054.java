import java.util.Arrays;
import java.util.PriorityQueue;

public class lc1054 {
  static public int[] rearrangeBarcodes(int[] barcodes) {
    int[] map = new int[10001];
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (m1, m2) -> {
          if (m2[1] == m1[1])
            return Integer.compare(m1[0], m2[0]);
          return Integer.compare(m2[1], m1[1]);
        });
    for (int b : barcodes)
      map[b]++;
    for (int i = 0; i < 10001; i++)
      if (map[i] > 0)
        pq.add(new int[] { i, map[i] });
    int[] tmp1;
    int[] tmp2;
    int k = 0;
    while (!pq.isEmpty()) {
      tmp1 = pq.poll();
      barcodes[k++] = tmp1[0];
      tmp1[1]--;
      if (pq.isEmpty()) {
        if (tmp1[1] > 0)
          pq.add(tmp1);
      } else {
        tmp2 = pq.poll();
        barcodes[k++] = tmp2[0];
        tmp2[1]--;
        if (tmp2[1] > 0)
          pq.add(tmp2);
        if (tmp1[1] > 0)
          pq.add(tmp1);
      }
    }
    return barcodes;
  }

  public static void main(String[] args) {
    int[] barcodes = { 7, 7, 7, 8, 5, 7, 5, 5, 5, 8 };
    System.out.println(Arrays.toString(rearrangeBarcodes(barcodes)));
  }
}
