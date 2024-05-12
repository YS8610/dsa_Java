import java.util.Arrays;
import java.util.PriorityQueue;

public class lc1337 {

  private static int[] kWeakestRows(int[][] mat, int k) {
    int n = mat.length;
    int nn = mat[0].length;
    Integer[] rank = new Integer[n];
    for (int i = 0; i < n; i++) rank[i] = i;
    Arrays.sort(
      rank,
      (m1, m2) -> {
        if (
          bSearch(mat[m1], 0, nn - 1) == bSearch(mat[m2], 0, nn - 1)
        ) return Integer.compare(m1, m2); else return (
          bSearch(mat[m1], 0, nn - 1) - bSearch(mat[m2], 0, nn - 1)
        );
      }
    );
    System.out.println(Arrays.toString(rank));
    int[] ans = new int[k];
    for (int i=0;i<k;i++) ans[i] = rank[i];

    return ans;
  }

  private static int[] kWeakestRows1(int[][] mat, int k) {
    int n = mat.length;
    int nn = mat[0].length;
    PriorityQueue<Integer> q = new PriorityQueue<>(n, (m1,m2) ->{
      if (
        bSearch(mat[m1], 0, nn - 1) == bSearch(mat[m2], 0, nn - 1)
        ) return Integer.compare(m1, m2); else return (
          bSearch(mat[m1], 0, nn - 1) - bSearch(mat[m2], 0, nn - 1)
          );
        });
    for (int i = 0; i < n; i++) q.add(i);
    int[] ans = new int[k];
    for (int i=0;i<k;i++) ans[i] = q.poll();
    return ans;
  }

  private static int bSearch(int[] a, int start, int end) {
    int len = a.length;
    if (a[0] == 0) return 0;
    if (a[len - 1] == 1) return len;
    if (len == 2 && a[0] == 1) return 1;
    if (len>2 && a[1]==0) return 1;

    int mid = start + (end - start) / 2;
    if (a[mid] == a[mid - 1] && a[mid] > a[mid + 1]) {
      return mid + 1;
    }
    if (a[mid] == 1 && a[mid - 1] == 1 && a[mid + 1] == 1) {
      return bSearch(a, mid + 1, end);
    }
    if (a[mid] == 0 && a[mid - 1] == 0 && a[mid + 1] == 0) {
      return bSearch(a, start, mid - 1);
    }
    if (a[mid - 1] == 1 && a[mid] == 0 && a[mid + 1] == 0) return mid;
    return 0;
  }

  public static void main(String[] args) {
    int[][] mat = {
      { 1, 1, 0, 0, 0 },
      { 1, 1, 1, 1, 0 },
      { 1, 0, 0, 0, 0 },
      { 1, 1, 0, 0, 0 },
      { 1, 1, 1, 1, 1 },
    };
    int k = 2;
    System.out.println( Arrays.toString(kWeakestRows(mat, k)));
    System.out.println( Arrays.toString(kWeakestRows1(mat, k)));
    // int[] test = new int[] { 0 };
    // System.out.println(bSearch(mat[2], 0, mat[0].length - 1));
  }
}
