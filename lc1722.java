import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1722 {
  static public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
    int l = source.length;
    int[] parent = new int[l];
    int ans = 0;
    Arrays.fill(parent, -1);
    for (int[] a : allowedSwaps) {
      int parA = findpar(parent, a[0]);
      int parB = findpar(parent, a[1]);
      if (parA == parB)
        continue;
      if (parent[parA] < parent[parB]) {
        parent[parA] += parent[parB];
        parent[parB] = parA;
        continue;
      }
      parent[parB] += parent[parA];
      parent[parA] = parB;
    }
    for (int i = 0; i < l; i++) {
      if (parent[i] < 0)
        continue;
      parent[i] = findpar(parent, i);
    }
    // System.out.println(Arrays.toString(parent));
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < l; i++) {
      int par = parent[i];
      if (par < 0) {
        if (map.containsKey(i))
          map.get(i).add(i);
        else
          map.put(i, new ArrayList<>(List.of(i)));
        continue;
      }
      if (map.containsKey(par))
        map.get(par).add(i);
      else
        map.put(par, new ArrayList<>(List.of(i)));
    }
    // System.out.println(map.toString());
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
      ans += diff(source, target, entry.getValue());
    return ans;
  }

  static public int diff(int[] src, int[] tar, List<Integer> list) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int no : list) {
      map.put(src[no], map.getOrDefault(src[no], 0) + 1);
      map.put(tar[no], map.getOrDefault(tar[no], 0) - 1);
    }
    int count = 0;
    for (int val : map.values()) {
      if (val > 0)
        count += val;
    }
    return count;
  }

  static public int findpar(int[] parent, int i) {
    if (parent[i] < 0)
      return i;
    return findpar(parent, parent[i]);
  }

  public static void main(String[] args) {
    int[] source = { 18, 67, 10, 36, 17, 62, 38, 78, 52 };
    int[] target = { 3, 4, 99, 36, 26, 58, 29, 33, 74 };
    int[][] allowedSwaps = { { 4, 7 }, { 3, 1 }, { 8, 4 }, { 5, 6 }, { 2, 8 }, { 0, 7 }, { 1, 6 }, { 3, 7 }, { 2, 5 },
        { 3, 0 }, { 8, 5 }, { 2, 1 }, { 6, 7 }, { 5, 1 }, { 3, 6 }, { 4, 0 }, { 7, 2 }, { 2, 6 }, { 4, 1 }, { 3, 2 },
        { 8, 6 }, { 8, 0 }, { 5, 3 }, { 1, 0 }, { 4, 6 }, { 8, 7 }, { 5, 7 }, { 3, 8 }, { 6, 0 }, { 8, 1 }, { 7, 1 },
        { 5, 0 }, { 4, 3 }, { 0, 2 } };
    System.out.println(minimumHammingDistance(source, target, allowedSwaps));
  }
}
