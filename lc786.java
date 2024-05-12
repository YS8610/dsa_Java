import java.util.Arrays;
import java.util.PriorityQueue;

public class lc786 {

  private static int[] kthSmallestPrimeFraction(int[] arr, int k) {
    PriorityQueue<int[]> q = new PriorityQueue<>((m1, m2) ->
      Double.compare(
        (double) m1[0] / (double) m1[1],
        (double) m2[0] / (double) m2[1]
      )
    );
    int l = arr.length;
    int[] ans = null;
    for (int rp = l - 1; rp > 0; rp--) {
      for (int lp = 0; lp < rp; lp++) q.add(new int[] { arr[lp], arr[rp] });
    }
    for (int i =0;i<k;i++){
      ans = q.poll();
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 5 };
    int k = 3;
    System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
  }
}
