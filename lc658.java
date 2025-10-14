import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class lc658 {
  public List<Integer> findClosestElements1(int[] arr, int k, int x) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> {
      if (m1[0] == m2[0])
        return Integer.compare(m1[1], m2[1]);
      return Integer.compare(m1[0], m2[0]);
    });
    List<Integer> ans = new ArrayList<>(k);
    for (int a : arr)
      pq.add(new int[] { Math.abs(a - x), a });
    for (int i = 0; i < k; i++)
      ans.add(pq.poll()[1]);
    Collections.sort(ans);
    return ans;
  }

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int l = arr.length;
    int lp = 0, rp = l - 1;
    List<Integer> ans = new ArrayList<>(k);
    while (rp - lp + 1 > k) {
      if (Math.abs(arr[lp] - x) > Math.abs(arr[rp] - x))
        lp++;
      else
        rp--;
    }
    for (int i = lp; i <= rp; i++)
      ans.add(arr[i]);
    return ans;
  }
}
