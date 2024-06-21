import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1122 {

  private static int[] relativeSortArray(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : arr1) {
      if (map.containsKey(i)) {
        map.computeIfPresent(i, (k, v) -> v + 1);
        continue;
      }
      map.computeIfAbsent(i, k -> 1);
    }
    List<Integer> l = new ArrayList<>(arr1.length);
    for (int i : arr2) {
      for (int j = 0, n = map.get(i); j < n; j++) l.add(i);
      map.remove(i);
    }
    List<Integer> l1 = new ArrayList<>(arr1.length);
    for (int i : map.keySet()) {
      for (int j = 0, n = map.get(i); j < n; j++) l1.add(i);
    }
    l1.sort((m1, m2) -> Integer.compare(m1, m2));
    l.addAll(l1);
    for (int i = 0, n = l.size(); i < n; i++) arr1[i] = l.get(i);
    return arr1;
  }

  private static int[] relativeSortArray1(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0, n = arr2.length; i < n; i++) {
      map.put(arr2[i], i);
    }
    Integer[] a = new Integer[arr1.length];
    for (int i = 0, n = arr1.length; i < n; i++) a[i] = arr1[i];
    Arrays.sort(
      a,
      (m1, m2) -> {
        if (map.containsKey(m1) && map.containsKey(m2)) {
          return Integer.compare(map.get(m1), map.get(m2));
        } else if (map.containsKey(m1)) return -1; else if (
          map.containsKey(m2)
        ) return 1; else return Integer.compare(m1, m2);
      }
    );
    for (int i = 0, n = a.length; i < n; i++) arr1[i] = a[i];
    return arr1;
  }

  public static void main(String[] args) {
    int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};
    int[] arr3 = Arrays.copyOf(arr1, arr1.length);
    System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    System.out.println(Arrays.toString(relativeSortArray1(arr3, arr2)));
    
  }
}
