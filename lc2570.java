import java.util.Arrays;

public class lc2570 {
  static public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    int l1 = nums1.length;
    int l2 = nums2.length;
    boolean[] map = new boolean[1001];
    for (int[] n : nums1)
      map[n[0]] = true;
    for (int[] n : nums2)
      map[n[0]] = true;
    int count = 0;
    for (boolean m : map)
      count += m ? 1 : 0;
    int[][] ans = new int[count][2];
    int i = 0, j = 0, k = 0;
    while (i < l1 && j < l2) {
      if (nums1[i][0] < nums2[j][0]) {
        ans[k][0] = nums1[i][0];
        ans[k++][1] = nums1[i++][1];
        continue;
      }
      if (nums1[i][0] == nums2[j][0]) {
        ans[k][0] = nums1[i][0];
        ans[k++][1] = nums1[i++][1] + nums2[j++][1];
        continue;
      }
      ans[k][0] = nums2[j][0];
      ans[k++][1] = nums2[j++][1];
    }
    while (i < l1) {
      ans[k][0] = nums1[i][0];
      ans[k++][1] = nums1[i++][1];
    }
    while (j < l2) {
      ans[k][0] = nums2[j][0];
      ans[k++][1] = nums2[j++][1];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] nums1 = { { 2, 4 }, { 3, 6 }, { 5, 5 } }, nums2 = { { 1, 3 }, { 4, 3 } };
    System.out.println(Arrays.deepToString(mergeArrays(nums1, nums2)));
  }
}
