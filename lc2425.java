public class lc2425 {

  private static int xorAllNums(int[] nums1, int[] nums2) {
    int l1 = nums1.length;
    int l2 = nums2.length;
    int tmp = 0;
    // both even
    if ((l2 & 1) == 0 && (l1 & 1) == 0) return 0;
    // l1 odd l2 even
    if ((l2 & 1) == 0) {
      for (int n : nums2) tmp ^= n;
      return tmp;
    }
    // l1 even l2 odd
    if ((l1 & 1) == 0) {
      for (int n : nums1) tmp ^= n;
      return tmp;
    }
    // both odd
    for (int n : nums1) tmp ^= n;
    for (int n : nums2) tmp ^= n;
    return tmp;
  }

  public static void main(String[] args) {
    int[] nums1 = { 2, 1, 3 };
    int[] nums2 = { 10, 2, 5, 0 };
    System.out.println(xorAllNums(nums1, nums2));
  }
}
