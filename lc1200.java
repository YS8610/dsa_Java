import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1200 {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    int l = arr.length;
    int tmp = Math.abs(arr[0] - arr[1]);
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(arr);
    for (int i = 1; i < l; i++)
      tmp = Math.min(tmp, arr[i] - arr[i - 1]);
    for (int i = 1, pair = 0; i < l; i++) {
      pair = arr[i] - arr[i - 1];
      if (pair == tmp)
        ans.add(List.of(arr[i - 1], arr[i]));
    }
    return ans;
  }
}
