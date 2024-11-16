import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc1331 {

  private static int[] arrayRankTransform(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for (int a : arr) set.add(a);
    int l = set.size();
    int[] tmp = new int[l];
    int n = -1;
    for (int s : set) tmp[++n] = s;
    Arrays.sort(tmp);
    for (int i = 0, m = arr.length; i < m; i++) {
      arr[i] = Arrays.binarySearch(tmp, arr[i]) + 1;
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = {40,10,20,30};
    System.out.println(Arrays.toString(arrayRankTransform(arr)));
  }
}
