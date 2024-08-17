import java.util.Arrays;

public class lc2418 {
  private static String[] sortPeople(String[] names, int[] heights) {
    int len = names.length;
    int[][] a = new int[len][2];
    for (int i=0;i<len;i++){
      a[i][0] = heights[i];
      a[i][1] = i;
    }
    Arrays.sort(a, (m1,m2) -> Integer.compare(m2[0], m1[0]));
    String[] ans = new String[len];
    for (int i=0;i<len;i++) ans[i] = names[a[i][1]];
    return ans;
  }

  public static void main(String[] args) {
    String[] names = {"Mary","John","Emma"};
    int[] heights = {180,165,170};
    System.out.println(Arrays.toString(sortPeople(names, heights)));

  }
}
