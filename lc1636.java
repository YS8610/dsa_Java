import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1636 {

  private static int[] frequencySort(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.computeIfPresent(num, (k, v) -> v + 1);
      map.computeIfAbsent(num, v -> 1);
    }
    int len = map.size();
    int[][] arr = new int[len][2];
    int n = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      arr[n][0] = entry.getKey();
      arr[n][1] = entry.getValue();
      n++;
    }
    Arrays.sort(
      arr,
      (m1, m2) -> {
        if (m1[1] == m2[1]) return Integer.compare(m2[0], m1[0]);
        return Integer.compare(m1[1], m2[1]);
      }
    );
    n = 0;
    for (int[] a : arr) {
      for (int j = 0; j < a[1]; j++) {
        nums[n] = a[0];
        n++;
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    int[] nums = {2,3,1,3,2};
    System.out.println(Arrays.toString(frequencySort(nums)));
  }
}
